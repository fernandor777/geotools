/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2008-2011, Open Source Geospatial Foundation (OSGeo)
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

package org.geotools.appschema.resolver.data;

import java.io.IOException;
import java.util.ArrayList;
import org.geotools.api.feature.Feature;
import org.geotools.api.feature.FeatureVisitor;
import org.geotools.api.feature.type.FeatureType;
import org.geotools.api.filter.Filter;
import org.geotools.api.filter.sort.SortBy;
import org.geotools.api.util.ProgressListener;
import org.geotools.data.DataUtilities;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.geometry.jts.ReferencedEnvelope;

/**
 * Collection of features from a {@link SampleDataAccess}.
 *
 * @author Ben Caradoc-Davies (CSIRO Earth Science and Resource Engineering)
 * @version $Id$
 * @since 2.6
 */
@SuppressWarnings("serial")
public class SampleDataAccessFeatureCollection extends ArrayList<Feature>
        implements FeatureCollection<FeatureType, Feature> {

    /**
     * @see org.geotools.feature.FeatureCollection#accepts(org.geotools.api.feature.FeatureVisitor,
     *     org.geotools.api.util.ProgressListener)
     */
    @Override
    public void accepts(FeatureVisitor visitor, ProgressListener progress) throws IOException {
        DataUtilities.visit(this, visitor, progress);
    }

    /**
     * Get an iterator over the features.
     *
     * @see org.geotools.feature.FeatureCollection#features()
     */
    @Override
    public FeatureIterator<Feature> features() {
        return new SampleDataAccessFeatureIterator(iterator());
    }

    /**
     * Not yet implemented.
     *
     * @see org.geotools.feature.FeatureCollection#getBounds()
     */
    @Override
    public ReferencedEnvelope getBounds() {
        // FIXME implement this
        return null;
    }

    /**
     * Not yet implemented.
     *
     * @see org.geotools.feature.FeatureCollection#getID()
     */
    @Override
    public String getID() {
        // FIXME implement this
        return null;
    }

    /**
     * Return type of features.
     *
     * @see org.geotools.feature.FeatureCollection#getSchema()
     */
    @Override
    public FeatureType getSchema() {
        return SampleDataAccessData.MAPPEDFEATURE_TYPE;
    }

    /**
     * Unsupported operation.
     *
     * @see org.geotools.feature.FeatureCollection#sort(org.geotools.api.filter.sort.SortBy)
     */
    @Override
    public FeatureCollection<FeatureType, Feature> sort(SortBy order) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation.
     *
     * @see org.geotools.feature.FeatureCollection#subCollection(org.geotools.api.filter.Filter)
     */
    @Override
    public FeatureCollection<FeatureType, Feature> subCollection(Filter filter) {
        throw new UnsupportedOperationException();
    }
}
