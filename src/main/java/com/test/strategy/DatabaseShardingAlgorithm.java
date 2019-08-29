package com.test.strategy;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DatabaseShardingAlgorithm implements ComplexKeysShardingAlgorithm {

    @Override
    public Collection<String> doSharding(Collection collection, ComplexKeysShardingValue complexKeysShardingValue) {
        Map<String, Collection> map = complexKeysShardingValue.getColumnNameAndShardingValuesMap();
        Collection valueCollection = map.get("id");
        Object value = valueCollection.toArray()[0];
        int i = Integer.parseInt(value.toString()) % collection.size();
        List<String> list = new ArrayList<>();
        list.add("sharding" + i);
        return list;
    }
}
