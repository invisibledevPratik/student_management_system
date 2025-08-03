package com.student.app;

import java.util.Scanner;

import com.student.model.Student;
import com.student.service.StudentService;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        String file = "C:\\Users\\DELL\\eclipse-workspace\\StudentManagementSystem\\bin\\com\\students.txt";


        // Load data from file if available
        service.loadFromFile(file);

        int choice;

        do {
            System.out.println("\n--- Student Record System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Search by Roll No");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Save Records");
            System.out.println("7. Load Records");
            System.out.println("8. Sort by Name");
            System.out.println("9. Sort by Marks");
            System.out.println("10. Show Grades");
            System.out.println("11. Show Toppers");
            System.out.println("12. Filter by Course");
            System.out.println("13. Total Students");
            System.out.println("0. Exit");
            System.out.print("Enter option: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Course: ");
                    String course = sc.nextLine();
                    System.out.print("Marks: ");
                    int marks = sc.nextInt();
                    service.addStudent(new Student(name, roll, course, marks));
                    break;

                case 2:
                    service.displayAll();
                    break;

                case 3:
                    System.out.print("Enter Roll No: ");
                    int rollNo = sc.nextInt();
                    service.searchByRollNo(rollNo);
                    break;

                case 4:
                    System.out.print("Enter Roll No to Delete: ");
                    int delRoll = sc.nextInt();
                    service.deleteStudent(delRoll);
                    break;

                case 5:
                    System.out.print("Roll No: ");
                    int updateRoll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Course: ");
                    String newCourse = sc.nextLine();
                    System.out.print("New Marks: ");
                    int newMarks = sc.nextInt();
                    service.updateStudent(updateRoll, newCourse, newMarks);
                    break;

                case 6:
                    service.saveToFile(file);
                    break;

                case 7:
                    service.loadFromFile(file);
                    break;

                case 8:
                    service.sortByName();
                    break;

                case 9:
                    service.sortByMarks();
                    break;

                case 10:
                	service.showGrades();
                    break;



                case 11:
                	System.out.println("Top 3 Students:");
                	service.viewToppers();
                	break;

                case 12:
                    System.out.print("Course name: ");
                    String courseFilter = sc.nextLine();
                    service.filterByCourse(courseFilter);
                    break;

                case 13:
                	int count = service.countStudents();
                	System.out.println("Total students: " + count);
                	break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}

