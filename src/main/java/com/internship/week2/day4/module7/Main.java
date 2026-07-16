package com.internship.week2.day4.module7;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String args[]) {

        Map<BadKey, String> map = new HashMap<>();

        for(int i = 1; i <= 10; i++) {
            map.put(new BadKey(i), "Value " + i);
        }

        System.out.println(map.size());
    }
}
