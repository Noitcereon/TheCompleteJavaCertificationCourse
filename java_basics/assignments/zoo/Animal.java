package java_basics.assignments.zoo;

public class Animal {
    private Gender gender;
    private int age;
    private int weightInKilos;

    public Animal(Gender gender, int age, int weightInKilos) {
        this.gender = gender;
        this.age = age;
        this.weightInKilos = weightInKilos;
    }
    public void eat(){
        System.out.println("Eating...");
    }
    public void sleep(){
        System.out.println("Sleeping...");
    }
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeightInKilos() {
        return weightInKilos;
    }

    public void setWeightInKilos(int weightInKilos) {
        this.weightInKilos = weightInKilos;
    }
}
