package com.dimple.test;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @className: JsonListUtil
 * @description: Json和List互转
 * @auther: Dimple
 * @date: 05/30/19
 * @version: 1.0
 */
public class JsonListUtil {
    public static <T> String listToJson(List<T> list) {
        String s = JSON.toJSON(list).toString();
        return s;
    }

    public static <T> List<T> jsonToList(String json, Class<T> clazz) {
        List<T> ts = JSON.parseArray(json, clazz);
        return ts;
    }

    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map map = new HashMap();
            map.put("name", UUID.randomUUID().toString().substring(0, 3));
            map.put("order", System.currentTimeMillis() % 10);
            list.add(map);
        }
        System.out.println(listToJson(list));
        String json = "[{\"name\":\"1ba8\",\"order\":2},{\"name\":\"945a\",\"order\":1},{\"name\":\"147e\",\"order\":0},{\"name\":\"7297\",\"order\":3},{\"name\":\"efb0\",\"order\":9},{\"name\":\"0029\",\"order\":5},{\"name\":\"8b0b\",\"order\":6},{\"name\":\"6ae5\",\"order\":7},{\"name\":\"258e\",\"order\":8},{\"name\":\"04cc\",\"order\":4}]";
        List<Item> items = jsonToList(json, Item.class);
        Collections.sort(items);
        System.out.println();
    }
}

class Item implements Serializable, Comparable<Item> {
    private String name;
    private int order;

    public Item() {
        super();
    }

    public Item(String name, int order) {
        this.name = name;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "111";
    }


    @Override
    public int compareTo(Item o) {
        if (o.getOrder() < order) {
            return 1;
        } else if (o.getOrder() > order) {
            return -1;
        }
        return 0;
    }
}
