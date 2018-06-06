package org.geotools.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.geotools.data.DataUtilities;
import org.geotools.data.Query;
import org.opengis.filter.Filter;

public abstract class IndexQueryUtils {

    public static List<String> getAttributesOnSort(Query query) {
        List<String> result = new ArrayList<>();
        if (query.getSortBy() == null) return result;
        for (int i = 0; i < query.getSortBy().length; i++) {
            result.add(query.getSortBy()[i].getPropertyName().getPropertyName());
        }
        return result;
    }

    public static List<String> getAttributesOnFilter(Filter filter) {
        String[] attrs = DataUtilities.attributeNames(filter);
        return new ArrayList<String>(Arrays.asList(attrs));
    }

    public static Map<String, Filter> getAttributeList(Filter rootFilter) {

        return null;
    }
}
