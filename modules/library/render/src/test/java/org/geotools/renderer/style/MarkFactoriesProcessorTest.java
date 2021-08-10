package org.geotools.renderer.style;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.apache.commons.collections4.IteratorUtils;
import org.geotools.renderer.style.markwkt.MeteoMarkFactory;
import org.junit.Test;

public class MarkFactoriesProcessorTest {

    @Test
    public void testFilteredMarkFactories() {
        List<MarkFactory> factoriesList =
                IteratorUtils.toList(SLDStyleFactory.getMarkFactoriesIterator());
        // check TTFMarkFactory was discarded from the resulting iterator
        assertFalse(
                factoriesList.stream().anyMatch(f -> f.getClass().equals(MockMarkFactory.class)));
    }

    @Test
    public void testOrderedMarkFactories() {
        List<MarkFactory> factoriesList =
                IteratorUtils.toList(SLDStyleFactory.getMarkFactoriesIterator());
        // check ordered by name response
        assertTrue(factoriesList.get(0) instanceof MeteoMarkFactory);
    }
}
