package org.acme.springboothazelcast.cache;

import java.util.Map;

public interface MapCacheService {

    void putAll(Map<String,String> objects);

    void put(String key,String value);

    String get(String key);

    void clear();

    void debug();
}
