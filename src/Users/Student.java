package Users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Enums.Department;
import Enums.Language;

public class Student extends User {

	private int yearOfStudy;
	private HashMap<Course, Mark> journal;
	private int maxCredit;
	private int currCredit = 0;
	private Department department;
	private HashMap<Course, Mark> takenCourses;
	private Researcher researcher;

	{

		this.journal = new HashMap<>();
		this.takenCourses = new HashMap<>();
		currCredit = 0;
	}

	public Student() {

	}

	public Student(String firstName, String lastName, String userId, String password, Language language, int yearOfStudy, int maxCredit, Department department) {
		super(firstName, lastName, userId, password, language);
		this.yearOfStudy = yearOfStudy;
		this.maxCredit = maxCredit;
		this.department = department;

	}

	public Researcher getResearcher() {
		return researcher;
	}

	public void setResearcher(Researcher researcher) {
		this.researcher = researcher;
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
				+ ", department=" + department + "current credits= " + currCredit + "journal: " + journal + "]";
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
	/* Shows transcript of the student.*/
	public void viewTranscript() {
		System.out.println(this.getFirstName() + " " + this.getLastName() + " has marks for the following courses:");
		for (Course course : journal.keySet()) {
			Mark mark = journal.get(course);
			char grade = (mark.getTotal() >= 90) ? 'A'
					: (mark.getTotal() >= 80) ? 'B'
							: (mark.getTotal() >= 70) ? 'C'
									: (mark.getTotal() >= 60) ? 'D' : 'F';
			System.out.println(course.getCode() + " | " + course.getCourseName() + " : " + grade);
		}
	}
	/*Rates teacher.*/
	public void rateTeacher(Teacher teacher) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Rate the Teacher " + teacher.getFirstName() + " " + teacher.getLastName() + " from 1 to 10: ");

		int rating = scanner.nextInt();

		teacher.getRatings().add(rating);
		System.out.println("You rated the teacher " + teacher.getFirstName() + " " + teacher.getLastName() + " with a " + rating + "/10");
	}

	/*Student registeres to course.*/

	public void registerToCourse(Course course, Manager manager) {
		manager.approveStudent(this, course);
	}

	public void viewMarksForCourses() {
		System.out.println(this.getFirstName() + " " + this.getLastName() + "has marks for the following courses:");
		for (Course course : journal.keySet()) {

			Mark mark = journal.get(course);


			System.out.println(course.getCode() + " | " + course.getCourseName() + " first: "
					+ mark.getFirstAttestation() + " | "  + " second: " +
					+ mark.getSecondAttestation() + " | "  + " final: " + 
					+ mark.getFinalExam() + " | " + " total: " +
					mark.getTotal());

			if((mark.getFirstAttestation() + mark.getSecondAttestation()) < 30 || mark.getFinalExam() < 20) {
				System.out.println("RETAKE:");
			}
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
