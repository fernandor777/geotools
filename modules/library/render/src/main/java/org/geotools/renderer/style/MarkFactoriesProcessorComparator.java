package org.geotools.renderer.style;

import java.util.Comparator;

/**
 * Compares the involved {@link MarkFactoriesProcessor} instances and return the order comparison
 * integer based on their returned priority int.
 */
public class MarkFactoriesProcessorComparator implements Comparator<MarkFactoriesProcessor> {

    @Override
    public int compare(MarkFactoriesProcessor proc1, MarkFactoriesProcessor proc2) {
        int priority1 = getPriority(proc1);
        int priority2 = getPriority(proc2);
        if (priority1 == priority2) {
            return 0;
        } else if (priority1 > priority2) {
            return -1;
        } else {
            return 1;
        }
    }

    private int getPriority(MarkFactoriesProcessor proc) {
        if (proc == null) {
            return Integer.MIN_VALUE;
        }
        return proc.priority();
    }
}
