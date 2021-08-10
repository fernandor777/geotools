package org.geotools.renderer.style;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.IteratorUtils;

public class FilteredMarkFactoriesProcessor implements MarkFactoriesProcessor {

    @Override
    public Iterator<MarkFactory> processFactories(Iterator<MarkFactory> factories) {
        List<MarkFactory> resultLits =
                IteratorUtils.toList(factories)
                        .stream()
                        .filter(f -> isValidClass(f))
                        .collect(Collectors.toList());
        return resultLits.iterator();
    }

    private boolean isValidClass(MarkFactory markFactory) {
        return !(markFactory instanceof MockMarkFactory);
    }

    @Override
    public int priority() {
        return 0;
    }
}
