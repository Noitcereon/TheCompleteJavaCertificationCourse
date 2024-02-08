package me.noitcereon.learning.lamda;

public class LamdaMain {
    public static void main(String[] args){
        Human human = new Human();
        Robot robot = new Robot();
        doWalk(human);
        doWalk(robot);
        doWalk(() -> System.out.println("Anon is walking."));
        doWalk(() -> {
            System.out.println("Anon is walking...");
            System.out.println("Anon is still walking.");
        });
    }

    public static void doWalk(Walkable walkableEntity){
        walkableEntity.walk();
    }
}
