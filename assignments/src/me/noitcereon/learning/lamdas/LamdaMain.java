package me.noitcereon.learning.lamdas;

import me.noitcereon.learning.lamdas.interfaces.Calculation;
import me.noitcereon.learning.lamdas.interfaces.GenericInterface;
import me.noitcereon.learning.lamdas.interfaces.OneNumberManipulation;
import me.noitcereon.learning.lamdas.interfaces.StringManipulation;

public class LamdaMain {
    public static void main(String[] args) {
        doWork();
    }

    public static void doWork() {
        // Task 1: sumOfTwoNumbers
        Calculation sumOfTwoNumbers = (n1, n2) -> n1.intValue() + n2.intValue();
        System.out.println(sumOfTwoNumbers.calculate(3, 1));

        // Task 2 nonZeroDivide
        Calculation nonZeroDivide = ((n1, n2) -> {
            if (n1.intValue() == 0) {
                return 0;
            }
            if (n2.intValue() == 0) {
                return n1.intValue();
            }
            return n1.intValue() / n2.intValue();
        });
        System.out.println(nonZeroDivide.calculate(0, 1)); // 0
        System.out.println(nonZeroDivide.calculate(5, 0)); // 5
        System.out.println(nonZeroDivide.calculate(5, 5)); // 1

        // Task 3: reverseInput
        StringManipulation reverseInput = (String inputStr) -> {
            StringBuilder output = new StringBuilder();
            for (int i = inputStr.length() - 1; i > -1; i--) {
                output.append(inputStr.charAt(i));
            }
            return output.toString();
        };
        String stringToReverse = "Noitcereon";
        System.out.println(reverseInput.manipulate(stringToReverse)); // noerectioN
        // Task 4: Factorial method as lamda.
        OneNumberManipulation factorial = (Number number) -> {
            int result = 1;
            for (int i = 1; i <= number.intValue(); i++) {
                result = i * result;
            }
            return result;
        };
        System.out.println(factorial.manipulate(5)); // 120

        // Task 5: Generic functional interface
        GenericInterface<String> genericReverseInput = (String inputStr) -> {
            StringBuilder output = new StringBuilder();
            for (int i = inputStr.length() - 1; i > -1; i--) {
                output.append(inputStr.charAt(i));
            }
            return output.toString();
        };
        System.out.println("genericReverseInput: " + genericReverseInput.work(stringToReverse)); // noerectioN

        GenericInterface<Number> genericFactorial = (Number number) -> {
            int result = 1;
            for (int i = 1; i <= number.intValue(); i++) {
                result = i * result;
            }
            return result;
        };
        System.out.println("genericFactorial: " + genericFactorial.work(5)); // 120

    }
}

