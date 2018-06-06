package org.geotools.data.complex.filter;

import static org.geotools.data.complex.ComplexFeatureConstants.DEFAULT_GEOMETRY_LOCAL_NAME;

import org.apache.commons.lang.StringUtils;
import org.geotools.data.complex.AttributeMapping;
import org.geotools.data.complex.FeatureTypeMapping;
import org.geotools.data.complex.filter.XPathUtil.StepList;
import org.geotools.filter.AttributeExpressionImpl;
import org.geotools.filter.visitor.DuplicatingFilterVisitor;
import org.opengis.feature.type.AttributeDescriptor;
import org.opengis.filter.expression.PropertyName;
import org.xml.sax.helpers.NamespaceSupport;

public class IndexUnmappingVisitor extends DuplicatingFilterVisitor {

    private FeatureTypeMapping mapping;

    public IndexUnmappingVisitor(FeatureTypeMapping mapping) {
        super();
        this.mapping = mapping;
    }

    @Override
    public Object visit(PropertyName expression, Object extraData) {
        String targetXPath = expression.getPropertyName();
        // replace the artificial DEFAULT_GEOMETRY property with the actual one
        if (DEFAULT_GEOMETRY_LOCAL_NAME.equals(targetXPath)) {
            targetXPath = mapping.getDefaultGeometryXPath();
        }
        NamespaceSupport namespaces = mapping.getNamespaces();
        AttributeDescriptor root = mapping.getTargetFeature();
        StepList simplifiedSteps = XPath.steps(root, targetXPath, namespaces);
        AttributeMapping attMapping = mapping.getAttributeMapping(simplifiedSteps);
        if (attMapping == null || StringUtils.isEmpty(attMapping.getIndexField()))
            return expression;
        return new AttributeExpressionImpl(attMapping.getIndexField());
    }

    //    @Override
    //    public Object visit(BBOX filter, Object extraData) {
    //        return null;
    //    }

}
