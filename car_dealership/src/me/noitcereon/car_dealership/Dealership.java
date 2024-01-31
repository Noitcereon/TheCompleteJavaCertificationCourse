package me.noitcereon.car_dealership;

import me.noitcereon.car_dealership.models.Customer;
import me.noitcereon.car_dealership.models.Employee;
import me.noitcereon.car_dealership.models.Vehicle;

public class Dealership {
    public static void main(String[] args){
        // Customers
        Customer customer1 = new Customer();
        customer1.setName("Tom");
        customer1.setAddress("123 Anything St.");
        customer1.setCashOnHandDkk(300000);
        Customer customer2 = new Customer();

        // Employees
        Employee employee = new Employee();
        employee.setName("John");

        // Vehicles
        Vehicle car1 = new Vehicle(100, "Berlingo", "Citroën", 120000);
        Vehicle car2 = new Vehicle(300, "Vroom", "SuperCarz", 350000);

        employee.handleCustomer(customer1, false, car1);

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
