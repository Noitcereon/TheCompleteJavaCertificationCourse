package me.noitcereon.learning.lamdas.built_in;

import me.noitcereon.learning.lamdas.built_in.models.Car;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class App {

    public static void main(String[] args) {
        String toyota = "Toyota";
        String white = "White";
        List<Car> cars = Arrays.asList(
                new Car("Honda", "Accord", "Red", 22300),
                new Car("Honda", "Civic", "Blue", 17700),
                new Car(toyota, "Land Cruiser", white, 48500),
                new Car(toyota, "Corolla", "Black", 16200),
                new Car(toyota, "Camry", "Blue", 24000),
                new Car("Nissan", "Sentra", white, 17300),
                new Car("Mitsubishi", "Lancer", white, 20000),
                new Car("Jeep", "Wrangler", "Red", 24500)
        );
        Function<Car, String> priceAndColor = (Car c) -> " price = " + c.getPrice() + " color = " + c.getColor();
        String stringCar = priceAndColor.apply(cars.get(0));
        System.out.println(stringCar);

        System.out.println("Printing cars between price 18000 and 22000");
        printCars(cars, (Car car) -> car.getPrice() >= 18000 && car.getPrice() <= 22000);

        System.out.println("Printing cars that are blue");
        System.out.println("Print blue cars");
        printCars(cars, (Car car) -> car.getColor().equals("Blue"));

    }


    /**
     * @deprecated This method uses a self-made functional interface called CarCondition.
     * This is redundant, because of the built-in functional interfaces (in this case {@link Predicate}).
     * Use {@link #printCars(List, Predicate)} instead.
     */
    @Deprecated
    public static void printCarsNonBuiltin(List<Car> cars, CarCondition condition) {
        for (Car car : cars) {
            if (condition.test(car)) {
                car.printCar();
            }
        }
    }

    public static void printCars(List<Car> cars, Predicate<Car> predicate) {
        for (Car car : cars) {
            if (predicate.test(car)) {
                car.printCar();
            }
        }
    }
}


