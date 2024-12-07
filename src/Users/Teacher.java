package Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Vector;
public class Teacher extends User implements Employee 
{
	private ArrayList<Course> courses;
	private Position position;
	private Department department;
	
	public Teacher(){
		
	}
	public Teacher( Position position, Department department, String password, String email, String firstName, String lastName, String userId, Language language, Vector<Date> logins,
            Vector<ResearchJournal> subscriptions) {
        super(password, email, firstName, lastName, userId, language, logins, subscriptions);
        this.position = position;
        this.department = department;
    }
	{
		courses = new ArrayList<Course>();
	}

	public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
    
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return courses.equals(teacher.courses) &&
        		position.equals(teacher.position) &&
        		department.equals(teacher.department);
    }

    public int hashCode() {
        return Objects.hash(courses, position, department);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Teacher{\n");
        sb.append("courses=");
        for (Course course : courses) {
            sb.append(course.getCode()).append(" ");
        }

        sb.append(", position=").append(position)
          .append(", department=").append(department)
          .append('}');
        
        return sb.toString();
    }

    
    
    
	public void viewCourses(Course parameter) {
		if (courses != null && !courses.isEmpty()) {
	        for (Course course : courses) {
	            System.out.println("Course Code: " + course.getCode());
	            System.out.println("Course Name: " + course.getCourseName());
	            System.out.println();
	        }
	    } else {
	        System.out.println("No courses available.");
	    }
	    	
	}

	public void viewInfoOfStudents(ArrayList<Student> students) {
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println("Name: " + student.getFirstName() + ", Age: " + student.getYearOfStudy());
        }
    }
	
	
	public void sendComplaint(Complaint complaint) {
		// TODO implement me	
	}
	
	
	
	public boolean putMark(Mark parameter, Student parameter2) {
		// TODO implement me
		return false;	
	}

	
	public void addResearchPaper() {
		// TODO implement me	
	}
	
	
	public void viewAttendance() {
		// TODO implement me	
	}
	
	public void viewFiles() {
		// TODO implement me	
	}
	

	
	public void assignCourse() {
		// TODO implement me	
	}

	public boolean addCourse(Course parameter) {
		// TODO implement me
		return false;	
	}
	

	public boolean removeCourse(Course parameter) {
		// TODO implement me
		return false;	
	}

	
	public void () {
		// TODO implement me	
	}
	
}

