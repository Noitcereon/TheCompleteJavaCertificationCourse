package me.noitcereon.car_dealership.models;

public class Vehicle {
    private int horsepower;
    private String carBrand;
    private String modelName;
    private double costDkk;

    public Vehicle(){
        setCarBrand("DefaultBrand");
        setModelName("DefaultModel");
    }
    public Vehicle(int horsepower, String modelName, String carBrand, double costDkk) {
        setHorsepower(horsepower);
        setCarBrand(carBrand);
        setModelName(modelName);
        setCostDkk(costDkk);
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = this.carBrand + " " + modelName;
    }
    private void setCarBrand(String carBrand){
        this.carBrand = carBrand;
    }

    public double getCostDkk() {
        return costDkk;
    }

    public void setCostDkk(double costDkk) {
        this.costDkk = costDkk;
    }
}
