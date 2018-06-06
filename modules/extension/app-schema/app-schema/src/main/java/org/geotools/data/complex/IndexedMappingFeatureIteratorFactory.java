package org.geotools.data.complex;

import org.geotools.data.Query;
import org.geotools.data.Transaction;
import org.geotools.data.complex.IndexModeProcessor.QueryIndexCoverage;
import org.opengis.filter.Filter;

public class IndexedMappingFeatureIteratorFactory {

    protected final AppSchemaDataAccess store;
    protected final FeatureTypeMapping mapping;
    protected final Query query;
    protected final Filter unrolledFilter;
    protected final Transaction transaction;

    private IndexModeProcessor indexModeProcessor;

    public IndexedMappingFeatureIteratorFactory(
            AppSchemaDataAccess store,
            FeatureTypeMapping mapping,
            Query query,
            Filter unrolledFilter,
            Transaction transaction) {
        this.store = store;
        this.mapping = mapping;
        this.query = query;
        this.unrolledFilter = unrolledFilter;
        this.transaction = transaction;
        this.indexModeProcessor =
                new IndexModeProcessor(mapping, store.unrollQuery(query, mapping));
    }

    public IndexedMappingFeatureIterator buildInstance() {
        if (indexModeProcessor.getIndexMode().equals(QueryIndexCoverage.NONE)) return null;
        return new TotalIndexedMappingFeatureIterator(
                store, mapping, query, unrolledFilter, transaction, indexModeProcessor);
    }

    public IndexModeProcessor getIndexModeProcessor() {
        return indexModeProcessor;
    }
}
