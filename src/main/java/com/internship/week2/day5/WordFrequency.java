package com.internship.week2.day5;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class WordFrequency {

    public static void main(String args[]) {

        Scanner sc =  new Scanner(System.in);
        String text = sc.nextLine();

        text = text.toLowerCase().replaceAll("[^a-z0-9\\s]", "");

        String words[] = text.split("\\s+");

        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String word: words) {
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        TreeMap<String, Integer> sortedMap = new TreeMap<>(wordCount);

        for(String word: sortedMap.keySet()) {
            System.out.println(word + ": " + sortedMap.get(word));
        }

        sc.close();
    }
}
