package com.internship.week3.day1.topic1;

import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {

        ArrayList list = new ArrayList();
        list.add("Kamran");
        list.add(1);
        list.add(true);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        ArrayList<String> names = new ArrayList<>();
        names.add("Ali");
        //names.add(100); // java: incompatible types: int cannot be converted to java.lang.String

        String s = names.get(0);
        System.out.println(s);
    }
}
