import java.util.*;

class Employee {

    int empId;
    String empName;
    int score;
    String grade;

    Employee(int empId, String empName, int score) {

        this.empId = empId;
        this.empName = empName;
        this.score = score;

        // Expert System Rules
        if (score >= 90)
            grade = "Excellent";

        else if (score >= 75)
            grade = "Good";

        else if (score >= 50)
            grade = "Average";

        else
            grade = "Poor";
    }
}

public class EmployeePerformanceEvaluation {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Employee
    public static void addEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Performance Score: ");
        int score = sc.nextInt();

        employees.add(new Employee(id, name, score));

        System.out.println("Employee Record Added Successfully.");
    }

    // Display Employees
    public static void displayEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No Employee Records Found.");
            return;
        }

        System.out.println("\nEmployee Performance Details:");

        for (Employee e : employees) {

            System.out.println("Employee ID: " + e.empId);
            System.out.println("Employee Name: " + e.empName);
            System.out.println("Performance Score: " + e.score);
            System.out.println("Performance Grade: " + e.grade);
            System.out.println("--------------------------");
        }
    }

    // Search Employee
    public static void searchEmployee() {

        System.out.print("Enter Employee ID to Search: ");
        int id = sc.nextInt();

        for (Employee e : employees) {

            if (e.empId == id) {

                System.out.println("Employee Found:");
                System.out.println("Name: " + e.empName);
                System.out.println("Score: " + e.score);
                System.out.println("Grade: " + e.grade);
                return;
            }
        }

        System.out.println("Employee Record Not Found.");
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n--- Employee Performance Evaluation Expert System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    displayEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    System.out.println("Exiting Program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}
