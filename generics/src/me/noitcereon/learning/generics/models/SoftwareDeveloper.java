package me.noitcereon.learning.generics.models;

public class SoftwareDeveloper extends Employee {
    public SoftwareDeveloper() {
        super();
    }

    public SoftwareDeveloper(String name, int ageYears) {
        super(name, ageYears);
        this.setRole("Software Developer");
    }

    public void develop(){
        System.out.println("Doing development work");
    }
}
