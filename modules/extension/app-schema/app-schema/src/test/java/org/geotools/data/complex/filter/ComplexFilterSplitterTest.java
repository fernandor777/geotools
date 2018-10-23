package org.geotools.data.complex.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.geotools.data.complex.FeatureTypeMapping;
import org.geotools.data.complex.filter.FeatureChainedAttributeVisitor.FeatureChainedAttributeDescriptor;
import org.geotools.data.complex.filter.XPathUtil.StepList;
import org.geotools.feature.NameImpl;
import org.geotools.filter.AttributeExpressionImpl;
import org.junit.Test;
import org.opengis.filter.expression.PropertyName;

public class ComplexFilterSplitterTest {

    @Test
    public void testCheckAttributeFound() throws Exception {
        ComplexFilterSplitter splitter =
                new ComplexFilterSplitter(null, null) {
                    @Override
                    protected boolean isXlinkHRef(StepList exprSteps) {
                        return false;
                    }
                };
        List<FeatureChainedAttributeDescriptor> fcAttrs = new ArrayList<>();
        FeatureTypeMapping mapping = new FeatureTypeMapping();
        FeatureChainedAttributeVisitor nestedAttrExtractor =
                new FeatureChainedAttributeVisitor(mapping) {
                    @Override
                    public boolean conditionalMappingWasFound() {
                        return false;
                    }
                };
        FeatureChainedAttributeVisitor existsAttrExtractor =
                new FeatureChainedAttributeVisitor(mapping) {
                    @Override
                    public List<FeatureChainedAttributeDescriptor> getFeatureChainedAttributes() {
                        return Arrays.asList(new FeatureChainedAttributeDescriptor());
                    }
                };
        PropertyName name = new AttributeExpressionImpl(new NameImpl("name"));
        splitter.checkAttributeFound(name, null, nestedAttrExtractor, existsAttrExtractor, fcAttrs);
    }
}
