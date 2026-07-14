package com.internship.week2.day2;

public class Employee extends Person implements Payable{

    private double salary;
    private String department;

    public Employee(String name, int age, String address, double salary, String department) {
        super(name, age, address);
        setSalary(salary);
        setDepartment(department);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (department != null && !department.trim().isEmpty()) {
            this.department = department;
        }
    }

    double calculatePay(){
        return getSalary() - getSalary() * CompanyConstants.TAX_RATE;
    }

    @Override
    public void processPayment() {
        System.out.println("Paying " + this.getName() + ": " + this.calculatePay());
    }
}
