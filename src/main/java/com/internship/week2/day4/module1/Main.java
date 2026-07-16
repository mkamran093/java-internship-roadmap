package com.internship.week2.day4.module1;

import java.util.HashMap;
import java.util.Map;

public class Main{

    public static void main(String args[]){

//        Map<Integer, String> students = new HashMap<>();
//        students.put(101, "Ali");
//        String old1 = students.put(102, "Sara");
//        students.put(103, "Ahmed");
//
//        System.out.println(old1);
//
//        String old2 = students.put(102, "Fatima");
//
//        System.out.println(students.get(10));

        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Laptop", 10);
        inventory.put("Mouse", 20);
        inventory.put("Keyboard", 25);

        System.out.println(inventory.get("Laptop"));
        System.out.println(inventory.getOrDefault("Monitor", 0));
        inventory.putIfAbsent("Laptop", 100);
        System.out.println(inventory.get("Laptop"));
        inventory.remove("Mouse");
        System.out.println(inventory);




    }
}
