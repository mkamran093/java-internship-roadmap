package com.internship.week2.day2;

abstract public class Person {

    private static int nextId = 1;
    private int id;
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        setName(name);
        setAge(age);
        setAddress(address);
        this.id = nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address != null && !address.trim().isEmpty()) {
            this.address = address;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    abstract double calculatePay();
}
