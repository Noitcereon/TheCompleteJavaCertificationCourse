package me.noitcereon.car_dealership.models;

import java.text.MessageFormat;

public class Employee {

    private String name;
    private int carsSold = 0;

    public void handleCustomer(Customer customer, boolean wantToFinanceWithCredit, Vehicle car) {
        System.out.println("Employee " + getName() + " is handling customer " + customer.getName());
        String customerGoal = wantToFinanceWithCredit ? MessageFormat.format(" is looking to finance {0} with credit ", car.getModelName()) : MessageFormat.format(" is looking to finance {0} with cash ", car.getModelName());
        System.out.println(customerGoal);
        boolean customerCanAffordWithCredit = false;
        if (wantToFinanceWithCredit) {
            customerCanAffordWithCredit = runCreditHistory(customer, car.getCostDkk());
            customer.purchaseCar(car, this, customerCanAffordWithCredit);
            processTransaction(car, customer);
        } else if (customer.getCashOnHandDkk() > car.getCostDkk()) {
            customer.purchaseCar(car, this, customerCanAffordWithCredit);
            processTransaction(car, customer);
        } else {
            System.out.println(customer.getName() + " does not have enough cash on hand nor enough credit to purchase " + car.getModelName());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCarsSold() {
        return carsSold;
    }

    public void setVehiclesSold(int vehiclesSold) {
        this.carsSold = vehiclesSold;
        System.out.println(getName() + " has now sold x vehicles " + getCarsSold());
    }
    public void incrementVehiclesSold() {
        this.carsSold += 1;
        System.out.println(getName() + " has now sold x vehicles " + getCarsSold());
    }

    private boolean runCreditHistory(Customer customer, double priceDkk) {
        System.out.println("Checking " + customer.getName() + " credit history.");
        if (customer.getCreditDkk() > priceDkk) {
            System.out.println("Customer can afford the car (with credit).");
            return true;
        }
        return false;
    }

    private void processTransaction(Vehicle vehicle, Customer customer) {
        System.out.println("Starting transaction.");
        System.out.println("Giving " + vehicle.getModelName() + " to " + customer.getName() + " for " + vehicle.getCostDkk() + "DKK");
        System.out.println("Simulate making receipt... Customer name: " + customer.getName() + " Address: " + customer.getAddress());
        System.out.println("Transaction completed.");
    }
}
