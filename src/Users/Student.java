package Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
		HashMap<Course, Mark> journal = new HashMap<Course,Mark>();
		HashMap<Course, Mark> takenCourses = new HashMap<Course,Mark>();
		currCredit = 0;
	}

	public Student(){

	}

	public Student(String firstName, String lastName, String userId, String password, String email, Language language, ArrayList<Date> logins,int yearOfStudy, HashMap<Course, Mark> journal, int maxCredit, Department department) {
		super(firstName,lastName,userId,password,language);
		this.yearOfStudy = yearOfStudy;
		this.journal = journal;
		this.maxCredit = maxCredit;
		this.department = department;

	}
	public Student(String firstName, String lastName, String userId, String email, Language language, int yearOfStudy, int maxCredit) {
		super(firstName, lastName, userId, email, language);
		this.yearOfStudy = yearOfStudy;
		this.maxCredit = maxCredit;
	}

	public Student(String firstName, String lastName, String userId, String email, Language language, int yearOfStudy) {
		super(firstName, lastName, userId, email, language);
		this.yearOfStudy = yearOfStudy;
	}

	public Student(String firstName, String lastName, String userId, String email, Language language, int yearOfStudy, Department department) {
		super(firstName, lastName, userId, email, language);
		this.department = department;
	}

	public Student(String firstName, String lastName, String userId, String email, Language language) {
		super(firstName, lastName, userId, email, language);
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

	@Override
	public boolean equals(Object other){
		if(other == null) {
			return false;
		}
		if(other == this) {
			return true;
		}
		if(!(other instanceof Student)) {
			return false;
		}
		Student otherStudent = (Student) other;
		return this.getUserId().equals(otherStudent.getUserId());
	}

	@Override
	public int hashCode(){
		return this.getUserId().hashCode();
	}

	public ArrayList<Course> getTakenCoursesArray() {
		ArrayList<Course> courses = new ArrayList<Course> ();
		for (Map.Entry<Course, Mark> entry : takenCourses.entrySet()) {
			courses.add(entry.getKey());
		}
		return courses;
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
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.print("Rate the Teacher " + teacher.getFirstName() + " " + teacher.getLastName() + " from 1 to 10: ");

			int rating = scanner.nextInt();

			teacher.addRating(rating);
			System.out.println("You rated the teacher " + teacher.getFirstName() + " " + teacher.getLastName() + " with a " + rating + "/10");
		} catch (NullPointerException e) {
			System.out.println("Error: The teacher object or some of its properties are null.");
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		} finally {
			scanner.close();  
		}
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
