package com.internship.week2.day4;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    public static void main(String args[]) {

        String sentence = "I am happy that I am alive and healthy and fit";
        String[] words = sentence.split(" ");

        Map<String, Integer> frequency = new HashMap<>();
        int old = 0;
        for (String word: words) {
            if (frequency.containsKey(word)) {
                old = frequency.remove(word);
                frequency.put(word, old + 1);
            } else {
                frequency.put(word, 1);
            }
        }

        System.out.print(frequency);

    }
}
