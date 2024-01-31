package me.noitcereon.car_dealership.models;

public class Customer {

    private String name;
    private String address;
    private double cashOnHandDkk;
    private double creditDkk;

    public Customer() {
    }

    public Customer(String name, String address, double cashOnHandDkk) {
        setName(name);
        setAddress(address);
        setCashOnHandDkk(cashOnHandDkk);
    }

    public void purchaseCar(Vehicle vehicle, Employee employee, boolean isFinancingWithCredit) {
        System.out.println(this.name + " is purchasing " + vehicle.getModelName() + " for " + vehicle.getCostDkk());
        if (isFinancingWithCredit) {
            setCreditDkk((getCreditDkk() - vehicle.getCostDkk()));
        } else {
            setCashOnHandDkk((getCashOnHandDkk() - vehicle.getCostDkk()));
        }
        employee.incrementVehiclesSold();
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
        System.out.println(this.name + " cash on hand before update " + getCashOnHandDkk());
        this.cashOnHandDkk = cashOnHandDkk;
        System.out.println(this.name + " cash on hand after update " + getCashOnHandDkk());
    }

    public double getCreditDkk() {
        return creditDkk;
    }

    public void setCreditDkk(double creditDkk) {
        System.out.println(this.name + " credit before update " + getCreditDkk());
        this.creditDkk = creditDkk;
        System.out.println(this.name + " credit after update " + getCreditDkk());

    }
}
