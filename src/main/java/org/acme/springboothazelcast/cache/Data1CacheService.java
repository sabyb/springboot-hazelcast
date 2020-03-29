package org.acme.springboothazelcast.cache;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Data1CacheService implements MapCacheService{

    private static final String CACHE_NAME="data1map";

    private CacheInstance cacheInstance;

    public Data1CacheService(CacheInstance cacheInstance) {
        this.cacheInstance = cacheInstance;
    }


    @Override
    public void putAll(Map<String, String> objects) {

        Map<String, String> data1ReplicatedMap = getReplicatedData1Map();
        data1ReplicatedMap.putAll(objects);
    }


    @Override
    public void put(String key,String value) {
        Map<String, String> data1ReplicatedMap = getReplicatedData1Map();
        data1ReplicatedMap.put(key,value);

    }

    @Override
    public String get(String key) {
        Map<String, String> data1ReplicatedMap = getReplicatedData1Map();
        return data1ReplicatedMap.get(key);
    }

    @Override
    public void clear() {
        Map<String, String> data1ReplicatedMap = getReplicatedData1Map();
        data1ReplicatedMap.clear();
    }

    @Override
    public void debug() {
        Map<String, String> data1ReplicatedMap = getReplicatedData1Map();

        for (Map.Entry<String, String> entry : data1ReplicatedMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private Map<String, String> getReplicatedData1Map() {

        return cacheInstance.get().getReplicatedMap(CACHE_NAME);
    }

}
