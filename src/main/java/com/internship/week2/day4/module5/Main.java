package com.internship.week2.day4.module5;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String args[]) {
//
//        Student s = new Student(1);
//
//        Map<Student, String> map = new HashMap<>();
//
//        map.put(s, "Ali");
//
//        System.out.println(map.get(s));
//
//        s.rollNo = 10;
//
//        System.out.println(map.get(s));
//
//        System.out.println(map.containsKey(s));
//
//        System.out.println(map);

        HashMap<Integer, String> hashmap = new HashMap<>();
        LinkedHashMap<Integer, String> linkedhashmap = new LinkedHashMap<>();
        TreeMap<Integer, String> treemap = new TreeMap<>();

        hashmap.put(3, "C");
        hashmap.put(1, "A");
        hashmap.put(5, "E");
        hashmap.put(2, "B");
        hashmap.put(4, "D");
        linkedhashmap.put(3, "C");
        linkedhashmap.put(1, "A");
        linkedhashmap.put(5, "E");
        linkedhashmap.put(2, "B");
        linkedhashmap.put(4, "D");
        treemap.put(3, "C");
        treemap.put(1, "A");
        treemap.put(5, "E");
        treemap.put(2, "B");
        treemap.put(4, "D");

        System.out.println("HashMap: " + hashmap);
        System.out.println("LinkedHashMap: " + linkedhashmap);
        System.out.println("TreeMap: " + treemap);
    }
}
