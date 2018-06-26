/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2018, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.data.complex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.geotools.data.Query;
import org.geotools.data.Transaction;
import org.geotools.feature.FeatureIterator;
import org.geotools.util.IndexQueryUtils;
import org.opengis.feature.Feature;
import org.opengis.filter.Filter;

/**
 * MappingFeatureIterator for full index coverage case
 *
 * @author Fernando Miño, Geosolutions
 */
public class TotalIndexedMappingFeatureIterator extends IndexedMappingFeatureIterator {

    private static int MAX_FEATURES_ROUND = 100;

    private FeatureIterator<? extends Feature> indexIterator;
    private FeatureIterator<? extends Feature> sourceIterator;

    public TotalIndexedMappingFeatureIterator(
            AppSchemaDataAccess store,
            FeatureTypeMapping mapping,
            Query query,
            Filter unrolledFilter,
            Transaction transaction,
            IndexQueryManager indexModeProcessor) {
        super(store, mapping, query, unrolledFilter, transaction, indexModeProcessor);
    }

    private FeatureIterator<? extends Feature> getIndexIterator() {
        if (indexIterator == null) {
            try {
                initializeIndexIterator();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        return indexIterator;
    }

    private void initializeIndexIterator() throws IOException {
        // rebuild Query to fetch only id attributes:
        Query idQuery = transformQueryToIdsOnly();
        // get iterator on new query
        indexIterator = mapping.getIndexSource().getFeatures(idQuery).features();
    }

    private Query transformQueryToIdsOnly() {
        Query idsQuery = new Query(unrollIndexes(query));
        idsQuery.setProperties(Query.NO_PROPERTIES);
        idsQuery.setTypeName(mapping.getIndexSource().getSchema().getTypeName());
        return idsQuery;
    }

    private void initNextSourceIndexRound() {
        Query nextQuery = getNextSourceQuery();
        try {
            sourceIterator =
                    MappingFeatureIteratorFactory.getInstance(
                            store, mapping, nextQuery, unrolledFilter, transaction, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Builds next query for execute in data source
     *
     * @return
     */
    private Query getNextSourceQuery() {
        Query nextQuery = new Query(query);
        Filter idInFilter = IndexQueryUtils.buildIdInExpression(getNextSourceIdList(), mapping);
        nextQuery.setFilter(idInFilter);
        return nextQuery;
    }

    /**
     * Extracts next id list from index iterator
     *
     * @return list of id string
     */
    private List<String> getNextSourceIdList() {
        int numFeatures = 0;
        List<String> ids = new ArrayList<>();
        while (numFeatures < MAX_FEATURES_ROUND && getIndexIterator().hasNext()) {
            Feature feature = getIndexIterator().next();
            ids.add(simplifyIndentifier(feature));
            numFeatures++;
        }
        return ids;
    }

    private void closeIndexIterator() {
        if (indexIterator == null) return;
        indexIterator.close();
    }

    private void closeSourceIterator() {
        if (sourceIterator == null) return;
        sourceIterator.close();
    }

    @Override
    public boolean hasNext() {
        // if sourceIterator is unable to provide more features or it isn't initialized
        if (sourceIterator == null || !sourceIterator.hasNext()) {
            // If there are more features on index, fetch next MAX_FEATURES_ROUND
            if (getIndexIterator().hasNext()) {
                closeSourceIterator();
                initNextSourceIndexRound();
                return this.hasNext();
            } else {
                // no more features from index, return false
                return false;
            }
        }
        return sourceIterator.hasNext();
    }

    @Override
    public Feature next() {
        if (hasNext()) return sourceIterator.next();
        return null;
    }

    @Override
    public void close() {
        closeIndexIterator();
        closeSourceIterator();
    }
}
