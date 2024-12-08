package Users ;
import java.util.ArrayList;
import java.util.Objects;
public class Teacher extends User 
{
	
	private ArrayList<Student> students;
	private ArrayList<Course> courses;
	private Position position;
	private Department department;
	
	public Teacher(){
		
	}

	public Teacher(Position position, Department department) {
		super();
		this.position = position;
		this.department = department;
	}
	{
		courses = new ArrayList<Course>();
		students = new ArrayList<Student>();
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
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(courses, teacher.courses);
    }

    public int hashCode() {
        return Objects.hash(courses);
    }

    public String toString() {
        return "Teacher{" +
               "courses=" + courses +
               ", position=" + position +
               ", department=" + department +
               '}';
    }
    
    
    
    public void viewCourses() { 
        if (courses != null && !courses.isEmpty()) {
            for (Course course : courses) {
                System.out.println("Course Code: " + course.getCode() + " | Course Name: " + course.getCourseName());
            }
        } else {
            System.out.println("No courses available.");
        }
    }
    
    public void assignCourse(Course course) {
        if (course != null) {
            this.addCourse(course);
            System.out.println("Course " + course.getCourseName() + " has been assigned to " + this.getFirstName() + ".");
        } else {
            System.out.println("Failed to assign course. Course is null.");
        }
    }

    public void viewInfoAboutStudents(ArrayList<Student> students) {
        if (students != null && !students.isEmpty()) {
            System.out.println("Students Information:");
            for (Student student : students) {
                System.out.println(student.toString());
            }
        } else {
            System.out.println("No students available.");
        }
    }
}
	