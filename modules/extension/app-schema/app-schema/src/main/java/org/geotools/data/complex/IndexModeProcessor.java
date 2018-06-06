package org.geotools.data.complex;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.geotools.data.Query;
import org.geotools.util.IndexQueryUtils;
import org.opengis.filter.Filter;

public class IndexModeProcessor {

    protected final FeatureTypeMapping mapping;
    protected final Query query;

    public IndexModeProcessor(FeatureTypeMapping mapping, Query query) {
        super();
        this.mapping = mapping;
        this.query = query;
    }

    public boolean isIndexDrivenIteratorCase() {
        if (getIndexMode().equals(QueryIndexCoverage.NONE)) return false;
        return true;
    }

    /**
     * Returns the IndexMode usage mode to use for current Query
     *
     * <p>QueryIndexMode.ALL: if all filter and sort attributes are indexed QueryIndexMode.PARTIAL:
     * if at least one filter attribute is indexed, all sort attributes indexed QueryIndexMode.NONE:
     * If no one of previous conditions are accomplished
     *
     * @return QueryIndexMode
     */
    public QueryIndexCoverage getIndexMode() {
        if (query.equals(Query.ALL)
                || query.equals(Query.FIDS)
                || query.getFilter().equals(Filter.INCLUDE)) return QueryIndexCoverage.NONE;
        // Filter match:
        List<String> filterAttributes = IndexQueryUtils.getAttributesOnFilter(query.getFilter());
        int filterMatchCount =
                (int) filterAttributes.stream().filter(attr -> hasIndex(attr)).count();
        // Sort match:
        List<String> sortAttributes = IndexQueryUtils.getAttributesOnSort(query);
        int sortMatchCount = (int) sortAttributes.stream().filter(attr -> hasIndex(attr)).count();
        // Query mode rules:
        if (filterAttributes.size() == filterMatchCount && sortAttributes.size() == sortMatchCount)
            return QueryIndexCoverage.ALL;
        if (filterMatchCount > 0 && sortAttributes.size() == sortMatchCount)
            return QueryIndexCoverage.PARTIAL;
        return QueryIndexCoverage.NONE;
    }

    /**
     * @param propertyName
     * @return
     */
    protected boolean hasIndex(String propertyName) {
        long count =
                mapping.getAttributeMappings()
                        .stream()
                        .filter(
                                x ->
                                        equalsProperty(x, propertyName)
                                                && StringUtils.isNotEmpty(x.getIndexField()))
                        .count();
        return count == 1L;
    }

    private boolean equalsProperty(AttributeMapping mapping, String propertyName) {
        if (mapping.getSourceExpression() != null) {
            return mapping.getSourceExpression().toString().equals(propertyName);
        } else if (mapping.getIdentifierExpression() != null) {
            return mapping.getIdentifierExpression().toString().equals(propertyName);
        }
        return false;
    }

    public static enum QueryIndexCoverage {
        ALL,
        NONE,
        PARTIAL
    }
}
