public class Employee {
    int id;
    String name;
    int age;
    double salary;

    // Constructor
    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // To print employee details
    public String toString() {
        return id + " " + name + " " + age + " " + salary;
    }
}
