package com.koey.anonnity_api_spring_boot.cache;

import javax.swing.text.html.Option;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class Cache<TKey, TValue> {
    private final ConcurrentHashMap<TKey, TValue> cache;

    public Cache() {
        this.cache = new ConcurrentHashMap<>();
    }

    public void putAll(Map<TKey, TValue> datas) {
        this.cache.putAll(datas);
    }

    public Optional<TValue> get(TKey key) {
        var value = this.cache.getOrDefault(key, null);
        if (value == null) {
            return Optional.empty();
        }

        return Optional.of(value);
    }

    public void put(TKey key, TValue value) {
        this.cache.put(key, value);
    }
}
