package me.noitcereon.learning.generics.models;

public class Accountant extends Employee {
    public Accountant() {
        super();
    }

    public Accountant(String name, int ageYears) {
        super(name, ageYears);
        this.setRole("Accountant");
    }

    public void doAccounting(){
        System.out.println("Accounting stuff");
    }
}
