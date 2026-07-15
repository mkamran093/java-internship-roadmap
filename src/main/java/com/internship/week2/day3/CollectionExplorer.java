package com.internship.week2.day3;

import java.util.ArrayList;
import java.util.List;

public class CollectionExplorer {

    public static void main(String[] args) {

        String[] cities = {"Karachi", "Lahore", "Islamabad", "Rawalpindi", "Peshawar"};
        System.out.println("Printing cities in static array");
        for (String city: cities) {
            System.out.print(city + ", ");
        }

        List<String> listCities = new ArrayList<>();
        listCities.add("Quetta");
        listCities.add("Faisalabad");
        listCities.add("Kohat");
        listCities.add("Sukkur");
        listCities.add("Hangu");

        listCities.remove(1);
        listCities.add("Chakwal");
        System.out.println("\nSize of Arraylist of cities: " + listCities.size());

        System.out.println("Printing cities in Arraylist");
        for (String city: listCities) {
            System.out.print(city + ", ");
        }
    }
}
