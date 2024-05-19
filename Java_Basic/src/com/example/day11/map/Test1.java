package com.example.day11.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(111, "kang");
        map.put(222, "kim");
        map.put(333, "hong");

        System.out.println(map);
        System.out.println(map.get(111));
        System.out.println(map);

        Set<Integer> keys = map.keySet();
        Iterator<Integer> keyIter = keys.iterator();
        while (keyIter.hasNext()) {
            Integer key = keyIter.next();
            System.out.println("key : " + key + " / value : " + map.get(key));
        }
    }
}
