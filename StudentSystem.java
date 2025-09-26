// Done By | Mayank Rawat | Bsc(Hon.) Cybersecurity | 2401830005
import java.util.Scanner;
class Student {
    int RollNo;
    String Name;
    String Course;
    double Marks;
    char Grade;

    // Constructor to initialize a new student object
    Student(int rollNo, String name, String course, double marks) {
        this.RollNo = rollNo;
        this.Name = name;
        this.Course = course;
        this.Marks = marks;
        this.Grade = calculateGrade(); // Calculate grade when the student is created
    }

    // Method to calculate the grade based on marks
    public char calculateGrade() {
        if (Marks >= 90) {
            return 'A';
        } else if (Marks >= 80) {
            return 'B';
        } else if (Marks >= 70) {
            return 'C';
        } else if (Marks >= 60) {
            return 'D';
        } else {
            return 'F'; // F for marks below 60
        }
    }

    // Method to display the details of this student
    public void displayStudentDetails() {
        System.out.println("Roll No: " + this.RollNo);
        System.out.println("Name: " + this.Name);
        System.out.println("Course: " + this.Course);
        System.out.println("Marks: " + this.Marks);
        System.out.println("Grade: " + this.Grade);
        System.out.println("------------------------------");
    }
}

public class StudentSystem {

    static Scanner scanner = new Scanner(System.in);
    
    static Student[] studentList = new Student[100];
    
    static int studentCount = 0;

    public static void main(String[] args) {
        int choice;

        do {
            // Show the menu options
            System.out.println("===== Student Menu =====");
            System.out.println("1. Add a New Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.println("========================");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Wrong choice! Please enter 1, 2, or 3.");
            }
            System.out.println();

        } while (choice != 3);
    }

    public static void addStudent() {
        // First, check if our array is full
        if (studentCount >= studentList.length) {
            System.out.println("Cannot add more students. The list is full.");
            return;
        }

        System.out.print("Enter Roll No: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();
        
        double marks = -1;
        while (marks < 0 || marks > 100) {
            System.out.print("Enter Marks (between 0 and 100): ");
            marks = scanner.nextDouble();
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Please try again.");
            }
        }
        
        Student newStudent = new Student(rollNo, name, course, marks);
        
        studentList[studentCount] = newStudent;
        studentCount++;

        System.out.println("Student added successfully!");
    }

    public static void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No student records to display.");
            return;
        }
        
        System.out.println("\n--- All Student Details ---");
        for (int i = 0; i < studentCount; i++) {
            studentList[i].displayStudentDetails();
        }
    }
}