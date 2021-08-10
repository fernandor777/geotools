package org.geotools.renderer.style;

import java.util.Iterator;

/**
 * Mark Factories processor extension point interface. Allows to pre-process the obtained
 * MarkFactory iterator to re-order and filter the resulting output iterator.
 */
public interface MarkFactoriesProcessor {

    /**
     * Pre-process the obtained MarkFactory iterator to re-order and filter the resulting output
     * iterator.
     *
     * @param factories the input iterator
     * @return the resulting iterator
     */
    Iterator<MarkFactory> processFactories(Iterator<MarkFactory> factories);

    /**
     * The priority integer to evaluate and order the processors.
     *
     * @return priority integer
     */
    int priority();
}
