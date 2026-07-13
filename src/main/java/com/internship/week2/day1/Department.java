package com.internship.week2.day1;

public class Department {

    private static int nextId = 1001;
    private int departmentId;
    private String departmentName;

    public Department() {}

    public Department(String departmentName) {
        this.departmentId = nextId++;
        setDepartmentName(departmentName);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        if (departmentName != null && !departmentName.trim().isEmpty()) {
            this.departmentName = departmentName;
        }
    }

    @Override
    public String toString() {
        return "Department {departmentId: " + this.departmentId +
                ", DepartmentName: " + this.departmentName + "}";
    }
}
