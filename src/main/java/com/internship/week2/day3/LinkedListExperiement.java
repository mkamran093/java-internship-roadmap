package com.internship.week2.day3;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListExperiement {

    public static void main(String args[]) {

        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        arrayList.add("Ali");
        arrayList.add("Ahmed");
        arrayList.add("Sara");
        arrayList.add("Fatima");
        arrayList.add("Kamran");
        linkedList.add("Ali");
        linkedList.add("Ahmed");
        linkedList.add("Sara");
        linkedList.add("Fatima");
        linkedList.add("Kamran");

        arrayList.add(0, "Ayesha");
        linkedList.add(0, "Ayesha");
        arrayList.remove(1);
        linkedList.remove(1);
        System.out.println("Element at 3rd index arraylist: " + arrayList.get(3));
        System.out.println("Element at 3rd index linkedlist: " + linkedList.get(3));

        // Why is get(index) slower in LinkedList?
        // because it will first do searching from start and the worst case is O(n).
        // Why doesn't LinkedList need to shift elements during insertion?
        // because elements are not stored in contagious memory locations. we just need to change the reference of next and previous element
        // Why might ArrayList still be faster than LinkedList in many real applications?
        // because in Arraylist, we don't need to search, we can access items with index

    }
}
