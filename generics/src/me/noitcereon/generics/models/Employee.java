package me.noitcereon.generics.models;

public class Employee
{
    private String name;
    private int ageYears;
    private String role;

    public Employee() {
        this.name = "";
        this.role = "";
    }

    public Employee(String name, int ageYears) {
        this.name = name;
        this.ageYears = ageYears;
        this.setRole("Generalist employee");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public void setAgeYears(int ageYears) {
        this.ageYears = ageYears;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
