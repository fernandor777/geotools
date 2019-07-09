package org.geotools.feature;

import java.util.Collections;
import java.util.Map;

public interface MetadataSupplier {

    default Map<Object, Object> getMetadataMap() {
        return Collections.emptyMap();
    }
}
