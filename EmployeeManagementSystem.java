import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {

    // List to store employees
    static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            // Display menu
            System.out.println("Main Menu");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All");
            System.out.println("3. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployee(sc);
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    System.out.println("Exiting the system.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Function to add an employee
    public static void addEmployee(Scanner sc) {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, age, salary);
        employees.add(emp);
    }

    // Function to display all employees
    public static void displayAll() {
        System.out.println("----Report-----");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        System.out.println("----End of Report-----");
    }
}
