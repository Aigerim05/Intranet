package Users;

import java.util.*;

public class Course {
	private String code;
	private int numberOfCredits;
	private String courseName;
	private String description;
	private CourseType courseType;
	private int maxCountOfStudents;
	private ArrayList<Student> participants;
	

	public Course(String code, int numberOfCredits, String courseName, String description, CourseType courseType,
			int maxCountOfStudents, ArrayList<Student> participants) {
		this.code = code;
		this.numberOfCredits = numberOfCredits;
		this.courseName = courseName;
		this.description = description;
		this.courseType = courseType;
		this.maxCountOfStudents = maxCountOfStudents;
		this.participants = participants;
	}
	
	public Course(String code, int numberOfCredits, String courseName, String description, CourseType courseType,
			int maxCountOfStudents) {
		this.code = code;
		this.numberOfCredits = numberOfCredits;
		this.courseName = courseName;
		this.description = description;
		this.courseType = courseType;
		this.maxCountOfStudents = maxCountOfStudents;
		this.participants = new ArrayList<Student>();
	}
	

	public Course(String code, int numberOfCredits, String courseName, String description, CourseType courseType) {
		this.code = code;
		this.numberOfCredits = numberOfCredits;
		this.courseName = courseName;
		this.description = description;
		this.courseType = courseType;
		this.maxCountOfStudents = 0;
		this.participants = new ArrayList<Student>();
	}

	public Course(String code, int numberOfCredits, String courseName, String description) {
		this.code = code;
		this.numberOfCredits = numberOfCredits;
		this.courseName = courseName;
		this.description = description;
		this.courseType = CourseType.MANDATORY;
		this.maxCountOfStudents = 0;
		this.participants = new ArrayList<Student>();
	}
	

	public Course(String code, int numberOfCredits, String courseName) {
		this.code = code;
		this.numberOfCredits = numberOfCredits;
		this.courseName = courseName;
		this.description = "";
		this.courseType = CourseType.MANDATORY;
		this.maxCountOfStudents = 0;
		this.participants = new ArrayList<Student>();
	}
	

	public Course(String code, int numberOfCredits) {
		this.code = code;
		this.numberOfCredits = numberOfCredits;
		this.courseName = "";
		this.description = "";
		this.courseType = CourseType.MANDATORY;
		this.maxCountOfStudents = 0;
		this.participants = new ArrayList<Student>();
	}
	

	public Course(String code) {
		this.code = code;
		this.numberOfCredits = 0;
		this.courseName = "";
		this.description = "";
		this.courseType = CourseType.MANDATORY;
		this.maxCountOfStudents = 0;
		this.participants = new ArrayList<Student>();
	}

	public Course() {
		this.code = "";
		this.numberOfCredits = 0;
		this.courseName = "";
		this.description = "";
		this.courseType = CourseType.MANDATORY;
		this.maxCountOfStudents = 0;
		this.participants = new ArrayList<Student>();

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

	@Override
	public String toString() {
		return "Course [code=" + code + ", numberOfCredits=" + numberOfCredits + ", courseName=" + courseName
				+ ", description=" + description + ", courseType=" + courseType + ", maxCountOfStudents="
				+ maxCountOfStudents + ", participants=" + participants + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Course))
			return false;
		Course other = (Course) obj;
		return code.equals(other.code);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

}
