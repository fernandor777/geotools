package org.geotools.renderer.style;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.IteratorUtils;

public class OrderedMarkFactoriesProcessor implements MarkFactoriesProcessor {

    @Override
    public Iterator<MarkFactory> processFactories(Iterator<MarkFactory> factories) {
        List<MarkFactory> factoryList = IteratorUtils.toList(factories);
        factoryList.sort(new MarkFactoryComparator());
        return factoryList.iterator();
    }

    @Override
    public int priority() {
        return 1;
    }

    private static class MarkFactoryComparator implements Comparator<MarkFactory> {

        @Override
        public int compare(MarkFactory f1, MarkFactory f2) {
            return f1.getClass().getSimpleName().compareTo(f2.getClass().getSimpleName());
        }
    }
}
