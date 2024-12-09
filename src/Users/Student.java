package Users;

import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Student{
	private int yearOfStudy = 0;
	private HashMap<Course, Mark> journal;
	private int maxCredit = 0;
	private Department department = Department.SITE;
	
	{
		HashMap<Course, Mark> journal = new HashMap<Course,Mark>();
	}

	public Student(){

	}

	public Student(){
		super();
		this.yearOfStudy = (Integer) null;
		this.journal = null;
		this.maxCredit = (Integer) null;
	}
	
	public Student(String firstName, String lastName, String userId, String password, String email, Language language, ArrayList<Date> logins,int yearOfStudy, HashMap<Course, Mark> journal, int maxCredit, Department department) {
		super(firstName,lastName,userId,password,language,logins);
		this.yearOfStudy = yearOfStudy;
		this.journal = journal;
		this.maxCredit = maxCredit;
		this.department = department;
		
	}
	public Student(String firstName, String lastName, String userId, String password, String email, Language language, ArrayList<Date> logins,int yearOfStudy,int maxCredit) {
		super(firstName,lastName,userId,password,language,logins);
		this.yearOfStudy = yearOfStudy;
		this.maxCredit = maxCredit;
	}
	public Student(String firstName, String lastName, String userId, String password, String email, Language language, ArrayList<Date> logins,int yearOfStudy) {
		super(firstName,lastName,userId,password,language,logins);
		this.yearOfStudy = yearOfStudy;
	}
	public Student(String firstName, String lastName, String userId, String password, String email, Language language, ArrayList<Date> logins,int yearOfStudy) {
		super(firstName,lastName,userId,password,language,logins);
		this.yearOfStudy = yearOfStudy;
		
	}
	public Student(String firstName, String lastName, String userId, String password, String email, Language language, ArrayList<Date> logins) {
		super(firstName,lastName,userId,password,language,logins);
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

	@Override
	public String toString() {
		return super().toString + "Student [yearOfStudy=" + yearOfStudy + ", maxCredit=" + maxCredit
				+ ", department=" + department + "]";
	}

	@Override
	public boolean equals(Object other){
		if(other == null) return false;
		if(other == this) return true;
		if(!(other instanceof Student)) return false;
		Student otherStudent = (Student) other;
		return this.getId().equals(otherStudent.getId());
	}

	@Override
	public int hashCode(){
		return this.getId().hashCode();
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

		public boolean rateTeacher() {
        Scanner scanner = new Scanner(System.in);
        for (Course course : journal.keySet()) {
            System.out.println(course.getCourseName() + ":");
            ArrayList<User> instructors = course.getInstructors();
            for (User instructor : instructors) {
                System.out.print(instructor.getName() + " ");
            }
            System.out.println();
            System.out.print("Rate the Instructor of this Course from 1 to 10: ");
            double rating = scanner.nextDouble();
            for (User instructor : instructors) {
                instructor.setRating(rating);
            }
						course.setInstructors(instructors);
            System.out.println("You rated the instructor(s) of " + course.getCourseName() + " with a " + rating);
        }
        scanner.close();
        return true;
    }

		// public boolean registerForCourse(Course course) {
		// здесь будет логика того что студент отправляет запрос на регистрацию на курс, а менеджер курса его одобряет/отклоняет
		// }

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
            ArrayList<User> instructors = course.getInstructors();
            for (User instructor : instructors) {
                System.out.println("Instructor: " + instructor.getFirstName() + " " + instructor.getLastName());
            }
        }
    }
}
