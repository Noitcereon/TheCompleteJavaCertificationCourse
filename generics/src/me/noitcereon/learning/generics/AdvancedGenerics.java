package me.noitcereon.learning.generics;

import me.noitcereon.learning.generics.models.Accountant;
import me.noitcereon.learning.generics.models.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AdvancedGenerics {
    private AdvancedGenerics(){}

    public static void doWork(){
        Employee employee = new Employee("Tom", 27);
        Accountant accountant = new Accountant("George", 53);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        List<Accountant> accountants = new ArrayList<>();
        accountants.add(accountant);

        Collection<? extends Employee> employeesWildCard = combineEmployees(employees, accountants);
        for (Employee e : employeesWildCard){
            System.out.println(e.getName() + " is a " + e.getRole());
        }
    }
    public static Collection<Employee> combineEmployees(Collection<Employee> mainCollection, Collection<? extends Employee> collectionToAdd){
        mainCollection.addAll(collectionToAdd);

        return mainCollection;
    }
}
