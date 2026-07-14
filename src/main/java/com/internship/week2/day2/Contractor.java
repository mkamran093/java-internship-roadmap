package com.internship.week2.day2;

public class Contractor extends Person implements Payable{

    private int hourlyRate;
    private int hoursWorked;

    public Contractor(String name, int age, String address, int hourlyRate, int hoursWorked) {
        super(name, age, address);
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        if (hoursWorked > 0 && hoursWorked < CompanyConstants.MAX_WORKING_HOURS) {
            this.hoursWorked = hoursWorked;
        }
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        if (hourlyRate > 0) {
            this.hourlyRate = hourlyRate;
        }
    }

    @Override
    double calculatePay() {
        return getHourlyRate() * getHoursWorked();
    }

    @Override
    public void processPayment() {
        System.out.println("Paying " + this.getName() + ": " + this.calculatePay());
    }
}
