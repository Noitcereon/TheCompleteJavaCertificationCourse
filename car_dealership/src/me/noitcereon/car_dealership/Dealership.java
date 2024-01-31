package me.noitcereon.car_dealership;

import me.noitcereon.car_dealership.models.Customer;

public class Dealership {
    public static void main(String[] args){
        Customer customer1 = new Customer();
        customer1.setName("Tom");
        customer1.setAddress("123 Anything St.");
        customer1.setCashOnHandDkk(300000);
        /*
        handleCustomer(Customer cust, boolean finance, Vehicle vehicle)
        if (finance == true)
            runCreditHistory(Customer cust, double doubleAmount)
          else if (vehicle.getPrice() <= cust.getCashOnHand()) ;
        processTransaction(Customer cust, Vehicle vehicle
          else:
        tell customer to bring more money.
        */

    }
}
