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

    {
        participants = new ArrayList<>();
    }

    public Course() {
        this.code = "";
        this.numberOfCredits = 0;
        this.courseName = "";
        this.description = "";
        this.courseType = CourseType.MAJOR;
        this.maxCountOfStudents = 0;
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

    public void addParticipant (Student student) {
				participants.add(student);				
    }
		

    @Override
    public String toString() {
        return "Course [code=" + code + ", numberOfCredits=" + numberOfCredits + ", courseName=" + courseName
                + ", description=" + description + ", courseType=" + courseType + ", maxCountOfStudents="
                + maxCountOfStudents + ", participants=" + participants + "]";
    }

    @Override
    public boolean equals(Object obj) {
			if(this == obj) return true;
			if(obj == null) return false;
			if(getClass() != obj.getClass()) return false;
			Course other = (Course) obj;
			return code.equals(other.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

}
