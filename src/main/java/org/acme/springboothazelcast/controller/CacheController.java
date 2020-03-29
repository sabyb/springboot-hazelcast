package org.acme.springboothazelcast.controller;

import org.acme.springboothazelcast.cache.Data1CacheService;
import org.acme.springboothazelcast.dto.Data1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Only to test out the caches real life implementations would vary
 */
@RestController
public class CacheController {

    private Data1CacheService data1CacheService;

    public CacheController(Data1CacheService data1CacheService) {
        this.data1CacheService = data1CacheService;
    }

    @PutMapping(path = "/v1/data1cache", consumes = "application/json")
    public void put(Data1 data1) {
        data1CacheService.put(data1.getKey(), data1.getValue());
    }


    @PutMapping(path = "/v1/data1cache/all", consumes = "application/json")
    public void putAll(Data1[] data1) {
        Map<String, String> dataMap = new HashMap<>();
        Arrays.asList(data1)
                .stream()
                .forEach(e -> {
                    dataMap.put(e.getKey(), e.getValue());
                });
        data1CacheService.clear();
        data1CacheService.putAll(dataMap);

    }

    @GetMapping(path = "/v1/data1cache/{key}", consumes = "application/json")
    public String get(@PathVariable("key") String key) {
        return data1CacheService.get(key);
    }


}
