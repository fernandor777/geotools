package org.geotools.data.complex;

import org.geotools.data.Query;
import org.geotools.data.Transaction;
import org.geotools.data.complex.IndexModeProcessor.QueryIndexCoverage;
import org.geotools.data.complex.filter.IndexUnmappingVisitor;
import org.opengis.filter.Filter;
import org.opengis.filter.identity.FeatureId;

/** @author Fernando Miño (Geosolutions) */
public abstract class IndexedMappingFeatureIterator implements IMappingFeatureIterator {

    protected final AppSchemaDataAccess store;
    protected final FeatureTypeMapping mapping;
    protected final Query query;
    protected final Filter unrolledFilter;
    protected final Transaction transaction;

    protected IndexModeProcessor indexModeProc;
    protected QueryIndexCoverage queryMode;

    public IndexedMappingFeatureIterator(
            AppSchemaDataAccess store,
            FeatureTypeMapping mapping,
            Query query,
            Filter unrolledFilter,
            Transaction transaction,
            IndexModeProcessor indexModeProcessor) {
        this.store = store;
        this.mapping = mapping;
        this.query = query;
        this.unrolledFilter = unrolledFilter;
        this.transaction = transaction;
        this.indexModeProc = indexModeProcessor;
        selectExecutionPlan();
    }

    /**
     * Analyze query and select a plan: 1.- All fields indexed, execute all query on index layer 2.-
     * Mixed fields indexed and not, execute indexed operators and re-map query to database
     */
    protected void selectExecutionPlan() {
        queryMode = indexModeProc.getIndexMode();
    }

    protected Query unrollIndexes(Query query) {
        Query newQuery = new Query(query);
        newQuery.setFilter(unrollFilter(query.getFilter()));
        return newQuery;
    }

    protected Filter unrollFilter(Filter filter) {
        IndexUnmappingVisitor visitor = new IndexUnmappingVisitor(mapping);
        Filter unrolledFilter = (Filter) filter.accept(visitor, null);
        return unrolledFilter;
    }

    protected String getIdValue(FeatureId fid) {
        return fid.getID().substring(fid.getID().indexOf('.') + 1, fid.getID().length());
    }
}
