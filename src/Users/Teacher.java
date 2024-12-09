package Users ;
import java.util.ArrayList;
import java.util.Objects;
public class Teacher extends User 
{
	

	private Position position;
	private Department department;
	
	public Teacher(){
		super()
	}

	public Teacher(String password, String email, String firstName, String lastName,
            String userId, Language language,Position position, Department department) {
		super(password, email, firstName, lastName,userId, language);
		this.position = position;
		this.department = department;
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
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return super.equals(o);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode());
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
    

   
}
	