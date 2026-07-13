package com.internship.week2.day1;

public class Address {

    private String houseNo;
    private String street;
    private String city;
    private String country;

    public Address() {}

    public Address(String houseNo, String street, String city, String country) {
        setHouseNo(houseNo);
        setStreet(street);
        setCity(city);
        setCountry(country);
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        if (houseNo != null && !houseNo.trim().isEmpty()) {
            this.houseNo = houseNo;
        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if (street != null && !street.trim().isEmpty()) {
            this.street = street;
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city != null && !city.trim().isEmpty()) {
            this.city = city;
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country != null && !country.trim().isEmpty()) {
            this.country = country;
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNo=" + houseNo +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
