import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class InformationManagement {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        students.add(new Student(id, name));

        System.out.println("Record Added Successfully.");
    }

    public static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No Records Found.");
            return;
        }

        System.out.println("\nStudent Records:");
        for (Student s : students) {
            System.out.println("ID: " + s.id + " Name: " + s.name);
        }
    }

    public static void searchStudent() {
        System.out.print("Enter Student ID to Search: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Record Found:");
                System.out.println("ID: " + s.id);
                System.out.println("Name: " + s.name);
                return;
            }
        }

        System.out.println("Record Not Found.");
    }

    public static void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();

        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {
            Student s = it.next();

            if (s.id == id) {
                it.remove();
                System.out.println("Record Deleted Successfully.");
                return;
            }
        }

        System.out.println("Record Not Found.");
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n--- Information Management Expert System ---");
            System.out.println("1. Add Record");
            System.out.println("2. Display Records");
            System.out.println("3. Search Record");
            System.out.println("4. Delete Record");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Exiting Program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}
