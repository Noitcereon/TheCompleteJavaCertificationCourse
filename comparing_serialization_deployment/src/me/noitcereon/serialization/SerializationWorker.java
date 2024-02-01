package me.noitcereon.serialization;

import me.noitcereon.serialization.models.Employee;

import java.io.*;

/**
 * This class shows example usage of {@link java.io.Serializable}.
 */
public class SerializationWorker {
    private SerializationWorker(){}
    private static final String FILE_PATH = "/tmp/employee.ser";
    public static void doSerializationWork(boolean shouldExecute){
        if(shouldExecute == false){
            System.out.println("Skipping doSerializationWork.");
            return;
        }
        Employee employee = new Employee("John Doe", 35);
        serializeEmployee(employee);

        Employee deserializedEmployee = deserializeEmployee();
        System.out.println(deserializedEmployee);
    }

    private static void serializeEmployee(Employee employee) {
        System.out.println("Serializing: " + employee);
        // Note: FileOutputStream may not create the file specified, so it has to be created first, or it will throw an exception.
        try (FileOutputStream fileOut = new FileOutputStream(FILE_PATH)){
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(employee);
            out.close();
            System.out.println("Serialized data is saved in /tmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    private static Employee deserializeEmployee() {
        Employee employee;
        try (FileInputStream fileIn = new FileInputStream(FILE_PATH)){
            ObjectInputStream in = new ObjectInputStream(fileIn);
            employee = (Employee) in.readObject();
            in.close();
            System.out.println("Successfully deserialized employee from '" + FILE_PATH + "'");
            return employee;
        } catch (IOException i) {
            throw new IllegalStateException(i.getMessage(), i);
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return null;
        }

    }
}
