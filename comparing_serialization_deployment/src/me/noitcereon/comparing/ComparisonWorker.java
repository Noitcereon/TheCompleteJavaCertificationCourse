package me.noitcereon.comparing;

import me.noitcereon.comparing.models.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * A class showing usage examples of the {@link java.util.Comparator} and {@link Comparable } interfaces.
 *
 */
public class ComparisonWorker {
    private ComparisonWorker(){}
    public static void doComparisonWork(boolean shouldExecute){
        if(shouldExecute == false){
            System.out.println("Skipping doComparisonWork.");
            return;
        }
        Student studentA = new Student(25, "Thomas", 26);
        Student studentB = new Student(2, "Sue", 30);
        Student studentC = new Student(65, "John", 31);
        Student studentD = new Student(64, "John", 31);

        int outcome = studentB.compareTo(studentA);
        System.out.println("outcome = " + outcome);


        List<Student> students = new ArrayList<>();
        students.add(studentA);
        students.add(studentB);
        students.add(studentC);
        //students.add(studentD);
        System.out.println(students);

        // Ascending order based on the first digit in a number: (2, 65, 25) or (2, 25, 65) depending on initial order.
        students.sort((Student a, Student b) -> {
            if (a.rollNumber%10 > b.rollNumber%10) return 1;
            else return -1;
        });
        System.out.println(students);

        // Ascending order (2, 25, 65)
        students.sort((Student a, Student b) -> {
            if (a.rollNumber > b.rollNumber) return 1;
            else return -1;
        });
        System.out.println(students);
        // Descending order (65, 25, 2)
        students.sort((Student a, Student b) -> {
            if (a.rollNumber > b.rollNumber) return -1;
            else return 1;
        });
        System.out.println(students);
        // Ascending order based on the first digit in a number and student's compareTo method (Comparable). (2, 25, 65)
        students.sort((Student a, Student b) -> {
            int studentAFirstRollNoDigit = a.rollNumber%10;
            int studentBFirstRollNoDigit = b.rollNumber%10;
            if (studentAFirstRollNoDigit > studentBFirstRollNoDigit) return 1;
            if(studentAFirstRollNoDigit == studentBFirstRollNoDigit){
               return a.compareTo(b);
            }
            else return -1;
        });
        System.out.println(students);
    }
}
