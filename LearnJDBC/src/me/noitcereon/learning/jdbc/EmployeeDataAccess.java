package me.noitcereon.learning.jdbc;

import me.noitcereon.learning.jdbc.models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDataAccess {

    private final Connection dbConn;

    public EmployeeDataAccess() {
        this.dbConn = ConnectionManager.getConnection(); // By reusing the same connection we leave it open... I think this is not good practice.
    }

    public EmployeeDataAccess(Connection dbConn) {
        this.dbConn = dbConn;
    }

    public Optional<Employee> getEmployeeById(int id) throws SQLException {
        try (PreparedStatement preparedStatement = dbConn.prepareStatement("SELECT * FROM employees_database.employees WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("department"),
                        resultSet.getInt("salary")));
            }else{
                return Optional.empty();
            }
        }
    }
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();

        try (Connection uniqueConn = ConnectionManager.getConnection(); // Here I've tried to do it without the dbConn. This should close the connection properly.
                Statement statement = uniqueConn.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees_database.employees");
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("department"),
                        resultSet.getInt("salary"));
                employees.add(employee);
            }
        }
        return employees;
    }

    /**
     * Creates an employee in the database
     *
     * @param employee Employee you want to create.
     * @return Number of affected rows.
     * @throws IllegalStateException if something went wrong.
     */
    public int createEmployee(Employee employee) {
        try (PreparedStatement preparedStatement = dbConn.prepareStatement(
                "INSERT INTO EMPLOYEES VALUES(?, ?, ?, ?)")) {
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getDepartment());
            preparedStatement.setInt(4, employee.getSalary());
            return preparedStatement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException contraintException) {
            System.err.println("Failed to create employee. Cause: " + contraintException.getMessage());
            return 0;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public int deleteEmployee(int employeeId) {
        try (PreparedStatement preparedStatement = dbConn.prepareStatement(
                "DELETE FROM employees " +
                        "WHERE id = ?")) {
            preparedStatement.setInt(1, employeeId);
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows == 1 || affectedRows == 0){
                dbConn.commit();
            } else{
                dbConn.rollback();
                return 0;
            }
            return affectedRows;
        } catch (SQLIntegrityConstraintViolationException contraintException) {
            System.err.println("Failed to delete employee. Cause: " + contraintException.getMessage());
            return 0;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public Optional<Employee> update(Employee updatedEmployee) {
        try {
            dbConn.setAutoCommit(false); // when auto commit is disabled you can use .commit and .rollback methods.
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        try (PreparedStatement preparedStatement = dbConn.prepareStatement(
                "UPDATE employees SET name = ?, department = ?, salary = ? WHERE id = ?")) {
            System.out.println("Autocommit = " + dbConn.getAutoCommit());
            preparedStatement.setString(1, updatedEmployee.getName());
            preparedStatement.setString(2, updatedEmployee.getDepartment());
            preparedStatement.setInt(3, updatedEmployee.getSalary());
            preparedStatement.setInt(4, updatedEmployee.getId());
            int updatedRows = preparedStatement.executeUpdate();
            System.out.println("After executeUpdate: " + getEmployeeById(updatedEmployee.getId()));
            dbConn.rollback();
            System.out.println("After rollback: "+getEmployeeById(updatedEmployee.getId()));
            if(updatedRows == 1){
                dbConn.commit();
                return getEmployeeById(updatedEmployee.getId());
            }
            return Optional.empty(); // more or less than 1 row was updated!
        } catch (SQLIntegrityConstraintViolationException contraintException) {
            System.err.println("Failed to update employee. Cause: " + contraintException.getMessage());
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
    public String isConnectionClosed(){
        try {
            return dbConn.isClosed() ? "connecton is closed" : "connection is open";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "connecton is closed (excepton thrown)";
        }
    }
}
