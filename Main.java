import java.util.List;
import java.util.Scanner;

public class Main {
    private static final StudentDAO dao = new StudentDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- STUDENT MANAGEMENT SYSTEM ---");
            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student Details");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = readInt();
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewAllStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> {
                    System.out.println("Exiting Application. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option! Try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Name: "); String name = scanner.nextLine();
        System.out.print("Enter Age: "); int age = readInt();
        System.out.print("Enter Department: "); String dept = scanner.nextLine();
        System.out.print("Enter Email: "); String email = scanner.nextLine();
        System.out.print("Enter Phone: "); String phone = scanner.nextLine();
        System.out.print("Enter Marks 1: "); double m1 = readDouble();
        System.out.print("Enter Marks 2: "); double m2 = readDouble();
        System.out.print("Enter Marks 3: "); double m3 = readDouble();

        Student student = new Student(name, age, dept, email, phone, m1, m2, m3);
        if (dao.addStudent(student)) {
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Failed to add student.");
        }
    }

    private static void viewAllStudents() {
        List<Student> students = dao.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        System.out.printf("%-5s %-15s %-5s %-15s %-12s %-8s %-8s %-5s\n", "ID", "Name", "Age", "Department", "Phone", "Total", "Percentage", "Grade");
        for (Student s : students) {
            System.out.printf("%-5d %-15s %-5d %-15s %-12s %-8.2f %-8.2f %-5s\n",
                    s.getStudentId(), s.getName(), s.getAge(), s.getDepartment(), s.getPhone(), s.getTotalMarks(), s.getPercentage(), s.getGrade());
        }
    }

    private static void searchStudent() {
        System.out.print("Enter Student ID to Search: ");
        int id = readInt();
        Student s = dao.getStudentById(id);
        if (s != null) {
            System.out.println("ID: " + s.getStudentId() + " | Name: " + s.getName() + " | Dept: " + s.getDepartment() + " | Email: " + s.getEmail());
            System.out.println("Marks: " + s.getMark1() + ", " + s.getMark2() + ", " + s.getMark3() + " | Total: " + s.getTotalMarks() + " | %: " + s.getPercentage() + " | Grade: " + s.getGrade());
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to Update: ");
        int id = readInt();
        Student s = dao.getStudentById(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter New Name (" + s.getName() + "): "); String name = scanner.nextLine();
        System.out.print("Enter New Department (" + s.getDepartment() + "): "); String dept = scanner.nextLine();
        System.out.print("Enter New Mark 1 (" + s.getMark1() + "): "); double m1 = readDouble();
        System.out.print("Enter New Mark 2 (" + s.getMark2() + "): "); double m2 = readDouble();
        System.out.print("Enter New Mark 3 (" + s.getMark3() + "): "); double m3 = readDouble();

        if (!name.isEmpty()) s.setName(name);
        if (!dept.isEmpty()) s.setDepartment(dept);
        s.setMark1(m1); s.setMark2(m2); s.setMark3(m3);
        s.calculatePerformance();

        if (dao.updateStudent(s)) System.out.println("Student record updated successfully!");
        else System.out.println("Failed to update record.");
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        int id = readInt();
        if (dao.deleteStudent(id)) System.out.println("Student record deleted successfully.");
        else System.out.println("Student not found or deletion failed.");
    }

    private static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter an integer: ");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }

    private static double readDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Enter a number: ");
            scanner.next();
        }
        double val = scanner.nextDouble();
        scanner.nextLine();
        return val;
    }
}