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
package org.geotools.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.geotools.data.DataUtilities;
import org.geotools.data.Query;
import org.geotools.data.complex.AttributeMapping;
import org.geotools.data.complex.FeatureTypeMapping;
import org.geotools.data.complex.filter.XPath;
import org.geotools.data.complex.filter.XPathUtil.StepList;
import org.geotools.factory.CommonFactoryFinder;
import org.opengis.filter.Filter;
import org.opengis.filter.FilterFactory;
import org.opengis.filter.FilterFactory2;
import org.opengis.filter.expression.Expression;

/** @author Fernando Miño - Geosolutions */
public final class IndexQueryUtils {

    private IndexQueryUtils() {}

    /**
     * Extracts List of Sort attributes names from Query
     *
     * @param query
     * @return List of Sort attributes names
     */
    public static List<String> getAttributesOnSort(Query query) {
        List<String> result = new ArrayList<>();
        if (query.getSortBy() == null) return result;
        for (int i = 0; i < query.getSortBy().length; i++) {
            result.add(query.getSortBy()[i].getPropertyName().getPropertyName());
        }
        return result;
    }

    /**
     * Extracts List of attributes names from Filter
     *
     * @param filter
     * @return List of attributes names
     */
    public static List<String> getAttributesOnFilter(Filter filter) {
        String[] attrs = DataUtilities.attributeNames(filter);
        return new ArrayList<String>(Arrays.asList(attrs));
    }

    /**
     * Checks if Expression is empty or Null
     *
     * @param expression
     * @return
     */
    public static boolean isExpressionEmpty(Expression expression) {
        if (expression == null || Expression.NIL.equals(expression)) return true;
        return false;
    }

    /**
     * Checks if property name is equals to source/identifier expression in attribute mapping
     *
     * @param mapping
     * @param propertyName
     * @return
     */
    public static boolean equalsProperty(AttributeMapping mapping, String propertyName) {
        return (equalsPropertyExpression(mapping.getSourceExpression(), propertyName)
                || equalsPropertyExpression(mapping.getIdentifierExpression(), propertyName));
    }

    /**
     * Compare if mapping-xpath == attMapping
     *
     * @param mapping
     * @param attMapping
     * @param xpath
     * @return
     */
    public static boolean equalsXpath(
            FeatureTypeMapping mapping, AttributeMapping attMapping, String xpath) {
        StepList simplifiedSteps =
                XPath.steps(mapping.getTargetFeature(), xpath, mapping.getNamespaces());
        return Objects.equals(attMapping, simplifiedSteps);
    }

    /**
     * Compare if expression == propertyName
     *
     * @param expression
     * @param propertyName
     * @return
     */
    public static boolean equalsPropertyExpression(Expression expression, String propertyName) {
        if (IndexQueryUtils.isExpressionEmpty(expression)) return false;
        String[] name = DataUtilities.attributeNames(expression);
        if (name.length != 1) return false;
        return Objects.equals(name[0], propertyName);
    }

    /**
     * Checks if all unrolled properties are indexed in mapping
     *
     * @param properties
     * @param mapping
     * @return
     */
    public static boolean checkAllUnrolledPropertiesIndexed(
            List<String> properties, FeatureTypeMapping mapping) {
        return !properties.stream().anyMatch(p -> mapping.getIndexAttributeNameUnrolled(p) == null);
    }

    /**
     * Checks if all properties are indexed in mapping
     *
     * @param properties
     * @param mapping
     * @return
     */
    public static boolean checkAllPropertiesIndexed(
            List<String> properties, FeatureTypeMapping mapping) {
        return !properties.stream().anyMatch(p -> mapping.getIndexAttributeName(p) == null);
    }

    /**
     * Builds an OR operator comparing Identifier with ids list
     *
     * @param ids
     * @param mapping
     * @return Or Filter
     */
    public static Filter buildIdInExpressionOr(List<String> ids, FeatureTypeMapping mapping) {
        FilterFactory ff = CommonFactoryFinder.getFilterFactory();

        List<Filter> idFilters = new ArrayList<>();
        ids.forEach(
                idStr -> {
                    idFilters.add(
                            ff.equals(
                                    ff.property(
                                            mapping.getTargetFeature().getName().getLocalPart()),
                                    ff.literal(idStr)));
                });

        return ff.or(idFilters);
    }

    /**
     * Builds a mapping->identifier IN (ids...) like function/clause
     *
     * @param ids
     * @param mapping
     * @return Filter IN function
     */
    public static Filter buildIdInExpressionFunction(List<String> ids, FeatureTypeMapping mapping) {
        FilterFactory2 ff = CommonFactoryFinder.getFilterFactory2();
        List<Expression> idExpressions = new ArrayList<>();
        // add id field name
        idExpressions.add(ff.property(mapping.getTargetFeature().getName().getLocalPart()));
        // add values
        ids.forEach(
                idStr -> {
                    idExpressions.add(ff.literal(idStr));
                });
        // create Filter = id IN (val1, val2, .... valn)
        return ff.equals(
                ff.function("in", idExpressions.toArray(new Expression[] {})), ff.literal(true));
    }

    /**
     * Builds a mapping->identifier IN (ids...) like function/clause
     *
     * @param ids
     * @param mapping
     * @return Filter IN function
     */
    public static Filter buildIdInExpression(List<String> ids, FeatureTypeMapping mapping) {
        return buildIdInExpressionFunction(ids, mapping);
    }
}
