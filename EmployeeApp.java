import java.io.*;
import java.util.*;

class Employee implements Serializable 
{
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String designation;
    private double salary;
    public Employee(int id, String name, String designation, double salary) 
    {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }
    @Override
    public String toString() 
    {
        return "Employee ID: " + id + ", Name: " + name + ", Designation: " + designation + ", Salary: " + salary;
    }
}
public class EmployeeApp 
{
    private static final String FILE_NAME = "employees.dat";
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        while (true) 
        {
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) 
            {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    private static void addEmployee(Scanner scanner) 
    {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Designation: ");
        String designation = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        Employee employee = new Employee(id, name, designation, salary);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME, true))) 
        {
            oos.writeObject(employee);
            System.out.println("Employee added successfully.");
        } 
        catch (IOException e) 
        {
            System.err.println("Error saving employee: " + e.getMessage());
        }
    }
    private static void displayEmployees()
     {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) 
        {
            while (true) 
            {
                Employee employee = (Employee) ois.readObject();
                System.out.println(employee);
            }
        } 
        catch (EOFException e) 
        {
            System.out.println("End of employee list.");
        } 
        catch (FileNotFoundException e) 
        {
            System.err.println("No employees found.");
        } 
        catch (IOException | ClassNotFoundException e) 
        {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
