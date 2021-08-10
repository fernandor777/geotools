package org.geotools.renderer.style;

import java.awt.Graphics2D;
import java.awt.Shape;
import org.opengis.feature.Feature;
import org.opengis.filter.expression.Expression;

public class MockMarkFactory implements MarkFactory {

    @Override
    public Shape getShape(Graphics2D graphics, Expression symbolUrl, Feature feature)
            throws Exception {
        return null;
    }
}
