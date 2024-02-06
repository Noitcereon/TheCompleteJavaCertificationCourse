package me.noitcereon.learning.jdbc;

import me.noitcereon.learning.jdbc.models.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class JDBCDemo {
    public static void main(String[] args) throws SQLException {
        introToJdbc();
        crudWithJdbc();
    }

    /**
     * Create, Read, Update and Delete with JDBC API.
     */
    private static void crudWithJdbc() throws SQLException {
        EmployeeDataAccess employeeDataAccess = new EmployeeDataAccess();
        System.out.println(employeeDataAccess.isConnectionClosed());
        // Read
        List<Employee> employees = employeeDataAccess.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
            System.out.println(employeeDataAccess.isConnectionClosed());
        }

        // Create
        Employee employee = new Employee(1, "Thomas", "NySkat", 34000);
        int affectedRows = employeeDataAccess.createEmployee(employee);
        System.out.println(affectedRows);

        // Update
        System.out.println("Employee before update: " + employee);
        employee.setSalary(35000);
        Optional<Employee> updatedEmployee = employeeDataAccess.update(employee);
        System.out.println("Employee after update: " + updatedEmployee.orElse(null));

        // Delete
        int deletedRows = employeeDataAccess.deleteEmployee(employee.getId());
        System.out.println("Rows deleted: " + deletedRows);

        // Read 1 specific row
        Optional<Employee> employeeFromDb = employeeDataAccess.getEmployeeById(employee.getId());
        System.out.println("Employee from DB: " + employeeFromDb);
        System.out.println(employeeDataAccess.isConnectionClosed());
    }

    private static void introToJdbc() {
        try (Connection conn = ConnectionManager.getConnection();
             Statement statement = conn.createStatement()) {

            ResultSet result = statement.executeQuery("SELECT * FROM EMPLOYEES");

            while (result.next()) {
                System.out.println(result.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
