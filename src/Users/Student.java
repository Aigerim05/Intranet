package Users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Enums.Department;
import Enums.Language;

public class Student extends User{
	private int yearOfStudy;
	private HashMap<Course, Mark> journal;
	private int maxCredit;
	private int currCredit;
	private Department department;
	private HashMap<Course, Mark> takenCourses;
	{
		HashMap<Course, Mark> journal = new HashMap<>();
		HashMap<Course, Mark> takenCourses = new HashMap<>();
		currCredit = 0;
	}

	public Student(){

	}

	public Student(String firstName, String lastName, String userId, String password, Language language, int yearOfStudy, int maxCredit, Department department) {
		super(firstName,lastName,userId,password,language);
		this.yearOfStudy = yearOfStudy;
		this.maxCredit = maxCredit;
		this.department = department;

	}


	public int getYearOfStudy() {
		return yearOfStudy;
	}
	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	public HashMap<Course, Mark> getJournal() {
		return journal;
	}
	public HashMap<Course, Mark> getTakenCourses() {
		return takenCourses;
	}
	public void addToJournal(Course course, Mark mark) {
		this.journal.put(course, mark);
	}
	public int getMaxCredit() {
		return maxCredit;
	}
	public void setMaxCredit(int maxCredit) {
		this.maxCredit = maxCredit;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public int getCurrCredit() {
		return currCredit;
	}
	public void setCurrCredit(int currCredit) {
		this.currCredit = currCredit;
	}
	@Override
	public String toString() {
		return super.toString() + "Student [yearOfStudy=" + yearOfStudy + ", maxCredit=" + maxCredit
				+ ", department=" + department + "current credits= " + currCredit + "]";
	}

	public ArrayList<Course> getTakenCoursesArray() {
		return new ArrayList<>(takenCourses.keySet());
	}

	public void viewCourses() {
		System.out.println(this.getFirstName() + " " + this.getLastName() + " is taking the following courses:");
		for (Course course : journal.keySet()) {
			System.out.println("Course Code: " + course.getCode() + ", Course Name: " + course.getCourseName() + ", Course Type: " + course.getCourseType());
		}
	}

	public void viewTranscript() {
		System.out.println(this.getFirstName() + " " + this.getLastName() + " has marks for the following courses:");
		for (Course course : journal.keySet()) {
			Mark mark = journal.get(course);
			char grade = (mark.getTotal() >= 90) ? 'A' :
				(mark.getTotal() >= 80) ? 'B' :
					(mark.getTotal() >= 70) ? 'C' :
						(mark.getTotal() >= 60) ? 'D' : 'F';
			System.out.println(course.getCode() + " | " + course.getCourseName() + " : " + grade);
		}
	}

	public void rateTeacher(Teacher teacher) { 
		//		Scanner scanner = new Scanner(System.in);
		//
		//		try (scanner) {
		//			System.out.print("Rate the Teacher " + teacher.getFirstName() + " " + teacher.getLastName() + " from 1 to 10: ");
		//
		//			int rating = scanner.nextInt();
		//
		//			teacher.getRatings().add(rating);
		//			System.out.println("You rated the teacher " + teacher.getFirstName() + " " + teacher.getLastName() + " with a " + rating + "/10");
		//		} catch (NullPointerException e) {
		//			System.out.println("Error: The teacher object or some of its properties are null.");
		//		} catch (Exception e) {
		//			System.out.println("An unexpected error occurred: " + e.getMessage());
		//		}
		Scanner scanner = new Scanner(System.in);
		System.out.print("Rate the Teacher " + teacher.getFirstName() + " " + teacher.getLastName() + " from 1 to 10: ");

		int rating = scanner.nextInt();

		teacher.getRatings().add(rating);
		System.out.println("You rated the teacher " + teacher.getFirstName() + " " + teacher.getLastName() + " with a " + rating + "/10");
	}


	public void registerToCourse(Course course, Manager manager) {
		manager.approveStudent(this, course);
	}

	public void viewMarksForCourses() {
		System.out.println(this.getFirstName() + " " + this.getLastName() + "has marks for the following courses:");
		for (Course course : journal.keySet()) {
			Mark mark = journal.get(course);
			System.out.println(course.getCode() + " | " + course.getCourseName() + " : " 
					+ mark.getFirstAttestation() + " | " 
					+ mark.getSecondAttestation() + " | " 
					+ mark.getFinalExam() + " | " 
					+ mark.getTotal());
		}
	}

	public void viewInstructors() {
		System.out.println(this.getFirstName() + " " + this.getLastName() + " has the following instructors for their courses:");
		for (Course course : journal.keySet()) {
			System.out.println("Course Code: " + course.getCode() + ", Course Name: " + course.getCourseName());
			ArrayList<Teacher> instructors = course.getInstructors();
			for (Teacher instructor : instructors) {
				System.out.println("Instructor: " + instructor.getFirstName() + " " + instructor.getLastName());
			}
		}
	}
}
