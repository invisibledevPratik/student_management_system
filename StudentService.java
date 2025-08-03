package com.student.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.student.model.Student;

public class StudentService {
    private List<Student> studentList = new ArrayList<>();

    //  Add Student
    public void addStudent(Student s) {
        studentList.add(s);
    }

    //  Display All Students
    public void displayAll() {
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    //  Search by Roll Number
    public void searchByRollNo(int rollNo) {
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            if (s.getStudentrollno() == rollNo) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student not found.");
    }


    //  Delete Student Record
    public void deleteStudent(int rollNo) {
        Iterator<Student> it = studentList.iterator();
        while (it.hasNext()) {
            if (it.next().getStudentrollno() == rollNo) {
                it.remove();
                System.out.println("Student removed.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // 5. Update Student Data
    public void updateStudent(int rollNo, String course, int marks) {
        for (Student s : studentList) {
            if (s.getStudentrollno() == rollNo) {
                s.setCourse(course);
                s.setMarks(marks);
                System.out.println("Student updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    //  Save Data to File (serialization)
    public void saveToFile(String fileName) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(studentList);
            oos.close();
            System.out.println("Data saved.");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // Load Data from File (deserialization)
    public void loadFromFile(String fileName) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            studentList = (List<Student>) ois.readObject();
            ois.close();
            System.out.println("Data loaded.");
        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    // 8. Sort by Name
    public void sortByName() {
        studentList.sort(Comparator.comparing(Student::getStudentName));
        System.out.println("Sorted by name.");
    }

    //  Sort by Marks
    public void sortByMarks() {
        studentList.sort((a, b) -> b.getMarks() - a.getMarks());
        System.out.println("Sorted by marks.");
    }

    // Calculate Grade
    public void calculateGrade(int rollNo) {
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            if (s.getStudentrollno() == rollNo) {
                int marks = s.getMarks();
                String grade;
                if (marks >= 90) grade = "A+";
                else if (marks >= 80) grade = "A";
                else if (marks >= 70) grade = "B";
                else if (marks >= 60) grade = "C";
                else grade = "Fail";
                System.out.println("Grade: " + grade);
                return;
            }
        }
        System.out.println("Student not found.");
    }

     //to show grades
    public void showGrades() {
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            int marks = s.getMarks();
            String grade;

            if (marks >= 90)
                grade = "A+";
            else if (marks >= 80)
                grade = "A";
            else if (marks >= 70)
                grade = "B";
            else if (marks >= 60)
                grade = "C";
            else
                grade = "F";

            System.out.println(s + " | Grade: " + grade);
        }
    }

    //  View Toppers (Top 3)
    public void viewToppers() {
        sortByMarks();
        for (int i = 0; i < Math.min(3, studentList.size()); i++) {
            System.out.println(studentList.get(i));
        }
    }

    //  Filter by Course
    public void filterByCourse(String course) {
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            if (s.getCourse().equalsIgnoreCase(course)) {
                System.out.println(s);
            }
        }
    }


    // Count Total Students
    public int countStudents() {
        return  studentList.size();
    }

    //  Export to file (same as saveToFile)
    public void exportToFile(String fileName) {
        saveToFile(fileName);
    }
}
