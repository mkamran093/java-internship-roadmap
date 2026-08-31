package com.internship.finalPrep;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class Product {

    private String name;
    private double revenue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public Product(String name, double revenue) {
        this.name = name;
        this.revenue = revenue;
    }
}

public class ProductSorting {

    public static void main(String[] args) {

        List<Product> productList = Arrays.asList(
                new Product("A", 500),
                new Product("B", 1200),
                new Product("C", 300),
                new Product("D", 900)
        );

        productList.stream()
                .sorted((p1, p2) -> Double.compare(p2.getRevenue(), p1.getRevenue()))
                .limit(3)
                .map(Product::getName)
                .forEach(new Consumer<String>() {

                    private int rank = 1;
                    @Override
                    public void accept(String name) {
                        System.out.println(rank++ + ": " + name);
                    }
                });
    }
}
