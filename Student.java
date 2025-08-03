package com.student.model;
import java.io.Serializable;

public class Student implements Serializable {
	String studentName;
	int studentrollno;
	String course;
	int marks;
	
	public Student(String studentName,int studentrollno,String course,int marks) {
		this.studentName=studentName;
		this.studentrollno=studentrollno;
		this.course=course;
		this.marks=marks;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentrollno() {
		return studentrollno;
	}

	public void setStudentrollno(int studentrollno) {
		this.studentrollno = studentrollno;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
     @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return studentName+"|"+studentrollno+"|"+course+"|"+marks;
    }
}
