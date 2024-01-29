package java_basics.assignments.zoo;

public class Zoo {
    public static void main(String[] args){
        Animal human = new Animal(Gender.MALE, 26, 64);
        Animal cow = new Animal(Gender.FEMALE, 8, 350);
        Animal dog = new Animal(Gender.MALE, 6, 30);
        Bird bird = new Bird();


        human.eat();
        cow.eat();
        dog.sleep();
        bird.fly();
    }
}
