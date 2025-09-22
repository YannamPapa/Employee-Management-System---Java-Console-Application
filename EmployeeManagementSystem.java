import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

class Employee {
    private static int idCounter = 1; // Auto-increment counter
    private int id;
    private String name;
    private int age;
    private double salary;

    // Constructor (ID auto-generated)
    public Employee(String name, int age, double salary) {
        this.id = idCounter++;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age + " | Salary: " + salary;
    }
}

public class EmployeeManagementSystem {
    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\n=== Employee Management System ===");
                System.out.println("1. Add Employee");
                System.out.println("2. Display All Employees");
                System.out.println("3. Search Employee by ID");
                System.out.println("4. Update Employee");
                System.out.println("5. Delete Employee");
                System.out.println("6. Sort Employees by Name");
                System.out.println("7. Sort Employees by Salary");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                switch (choice) {
                    case 1: addEmployee(); break;
                    case 2: displayAll(); break;
                    case 3: searchEmployee(); break;
                    case 4: updateEmployee(); break;
                    case 5: deleteEmployee(); break;
                    case 6: sortByName(); break;
                    case 7: sortBySalary(); break;
                    case 8: System.out.println("Exiting..."); System.exit(0);
                    default: System.out.println("Invalid choice!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter numbers only.");
                sc.nextLine(); // clear wrong input
            }
        }
    }

    // Add Employee (ID auto-generated)
    public static void addEmployee() {
        try {
            sc.nextLine(); // consume newline
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(name, age, salary);
            employees.add(emp);
            System.out.println("Employee Added Successfully with ID: " + emp.getId());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter correct data.");
            sc.nextLine(); // clear invalid input
        }
    }

    // Display All Employees
    public static void displayAll() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        System.out.println("\n---- Employee List ----");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    // Search Employee
    public static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.println("Employee Found: " + emp);
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // Update Employee
    public static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                sc.nextLine();
                System.out.print("Enter new Name: ");
                emp.setName(sc.nextLine());
                System.out.print("Enter new Age: ");
                emp.setAge(sc.nextInt());
                System.out.print("Enter new Salary: ");
                emp.setSalary(sc.nextDouble());
                System.out.println("Employee Updated!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // Delete Employee
    public static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                employees.remove(emp);
                System.out.println("Employee Deleted!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // Sort Employees by Name
    public static void sortByName() {
        if (employees.isEmpty()) {
            System.out.println("No employees to sort.");
            return;
        }
        Collections.sort(employees, Comparator.comparing(Employee::getName));
        System.out.println("Employees Sorted by Name:");
        displayAll();
    }

    // Sort Employees by Salary
    public static void sortBySalary() {
        if (employees.isEmpty()) {
            System.out.println("No employees to sort.");
            return;
        }
        Collections.sort(employees, Comparator.comparingDouble(Employee::getSalary));
        System.out.println("Employees Sorted by Salary:");
        displayAll();
    }
}
