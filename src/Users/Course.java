package Users;

import java.util.ArrayList;
import java.util.Objects;

import Enums.CourseType;

public class Course {

	private String code;
	private int numberOfCredits;
	private String courseName;
	private String description;
	private CourseType courseType;
	private int maxCountOfStudents;
	private int currCountOfStudents;
	private ArrayList<Student> participants;
	private ArrayList<Teacher> instructors;
	private ArrayList<Course> prerequisites;

	{
		participants = new ArrayList<Student>();
		instructors = new ArrayList<Teacher>();
		prerequisites = new ArrayList<Course>();
		currCountOfStudents = 0;
	}

	public Course(){

	}


	public Course(String code) {
		this();
		this.code = code;
	}

	public Course(String code, int numberOfCredits) {
		this(code);
		this.numberOfCredits = numberOfCredits;
	}

	public Course(String code, int numberOfCredits, String courseName) {
		this(code, numberOfCredits);
		this.courseName = courseName;
	}

	public Course(String code, int numberOfCredits, String courseName, String description) {
		this(code, numberOfCredits, courseName);
		this.description = description;
	}

	public Course(String code, int numberOfCredits, String courseName, String description, CourseType courseType) {
		this(code, numberOfCredits, courseName, description);
		this.courseType = courseType;
	}

	public Course(String code, int numberOfCredits, String courseName, String description, CourseType courseType, int maxCountOfStudents) {
		this(code, numberOfCredits, courseName, description, courseType);
		this.maxCountOfStudents = maxCountOfStudents;
	}

	public Course(String code, int numberOfCredits, String courseName, String description, CourseType courseType, int maxCountOfStudents, ArrayList<Student> participants) {
		this(code, numberOfCredits, courseName, description, courseType, maxCountOfStudents);
		this.participants = participants;
	}

	public Course(String code, int numberOfCredits, String courseName, String description, CourseType courseType, int maxCountOfStudents, ArrayList<Student> participants, ArrayList<Course> prerequisites) {
		this(code, numberOfCredits, courseName, description, courseType, maxCountOfStudents);
		this.prerequisites = prerequisites;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getNumberOfCredits() {
		return numberOfCredits;
	}

	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CourseType getCourseType() {
		return courseType;
	}

	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}

	public int getMaxCountOfStudents() {
		return maxCountOfStudents;
	}

	public void setMaxCountOfStudents(int maxCountOfStudents) {
		this.maxCountOfStudents = maxCountOfStudents;
	}

	public ArrayList<Student> getParticipants() {
		return participants;
	}

	public void setParticipants(ArrayList<Student> participants) {
		this.participants = participants;
	}

	public ArrayList<Course> getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(ArrayList<Course> prerequisites) {
		this.prerequisites = prerequisites;
	}

	public ArrayList<Teacher> getInstructors() {
		return instructors;
	}

	public void setInstructors(ArrayList<Teacher> instructors) {
		this.instructors = instructors;
	}

	public void addInstructor(Teacher instructor) {
		instructors.add(instructor);
	}

	@Override
	public String toString() {
		return "Course [code=" + code + ", numberOfCredits=" + numberOfCredits + ", courseName=" + courseName
				+ ", description=" + description + ", courseType=" + courseType + ", maxCountOfStudents="
				+ maxCountOfStudents + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		Course other = (Course) obj;
		return code.equals(other.code);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	public void addParticipant(Student student) {
		try {
			if (participants != null && participants.add(student)) {
				currCountOfStudents++;
				System.out.println("Student " + student.getFirstName() + " " + student.getLastName() + " was added to the course " + course.getCode() + " " + course.getCourseName());
			} else {
				System.out.println("Failed to add student " + student.getFirstName() + " to the course.");
			}
		} catch (NullPointerException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
	}


	public void removeParticipant(Student student) {
		try {
			if (participants != null && participants.contains(student)) {
				participants.remove(student);
				currCountOfStudents--;
				System.out.println("Student " + student.getFirstName() + " " + student.getLastName() + " was removed from the course " + course.getCode() + " " + course.getCourseName());
			} else {
				System.out.println("Student " + student.getFirstName() + " not found in the course " + getCode());
			}
		} catch (NullPointerException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public boolean addPrerequisite(Course c) {
		return prerequisites.add(c);
	}

	public boolean removePrerequisite(Course c) {
		return prerequisites.remove(c);
	}

	public boolean isAvailableCourse() {
		return this.currCountOfStudents < this.maxCountOfStudents;
	}

}
