package me.noitcereon.car_dealership.models;

public class Customer {

    private String name;
    private String address;
    private double cashOnHandDkk;

    public void purchaseCar(Vehicle vehicle, Employee employee, boolean isCustomerBuying){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getCashOnHandDkk() {
        return cashOnHandDkk;
    }

    public void setCashOnHandDkk(double cashOnHandDkk) {
        this.cashOnHandDkk = cashOnHandDkk;
    }
}
