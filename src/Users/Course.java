package Users;
import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable
{
	private String code;
	private int numberOfCredits;
	private String courseName;
	private String description;
	private CourseType courseType;
	private int maxCountOfStudents;
	private ArrayList<Student> participants;
	private ArrayList<Teacher> instructors;
	public ArrayList<Student> getParticipants() {
		return participants;
	}

	public Course(String code, int numberOfCredits, String courseName, String description, CourseType courseType,
			int maxCountOfStudents) {
		super();
		this.code = code;
		this.numberOfCredits = numberOfCredits;
		this.courseName = courseName;
		this.description = description;
		this.courseType = courseType;
		this.maxCountOfStudents = maxCountOfStudents;
	}
	{
		participants = new ArrayList<Student>();
		instructors = new ArrayList<Teacher>();
		}

	public void setParticipants(ArrayList<Student> participants) {
		this.participants = participants;
	}

	public ArrayList<Teacher> getInstructors() {
		return instructors;
	}

	public void setInstructors(ArrayList<Teacher> instructors) {
		this.instructors = instructors;
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

	public Course(){
		
	}

	public boolean isRegistrationOpen() {
		// TODO implement me
		return false;	
	}
	
}

