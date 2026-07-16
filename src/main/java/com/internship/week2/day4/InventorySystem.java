package com.internship.week2.day4;

import java.util.HashMap;
import java.util.Map;

public class InventorySystem {

    public static void main(String args[]) {

        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("P101", 10);
        inventory.put("P102", 365);
        inventory.put("P103", 165);
        inventory.put("P104", 132);
        inventory.put("P105", 134);

        System.out.println(inventory);
        int oldStock = inventory.get("P101");
        inventory.put("P101", oldStock+15);
        oldStock = inventory.get("P103");
        inventory.put("P103", oldStock-5);
        inventory.remove("P105");
        System.out.println(inventory);

        System.out.println("Check for P133: " + inventory.containsKey("P133"));
        System.out.println("Check another product: " + inventory.getOrDefault("P134", 0));

    }
}
