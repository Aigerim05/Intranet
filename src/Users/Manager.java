package Users;

import java.util.ArrayList;
import java.util.Objects;

public class Manager extends User 
{
	private ArrayList<Course> courses;
	private ManagerType managerType;
	private ArrayList<Request> requests;
	public Manager(){
		
	}
	
	public Manager(ManagerType managerType) {
		this.managerType = managerType;
	}
	{
		requests = new ArrayList<Request>();
		courses = new ArrayList<Course>();
	}
	public ManagerType getManagerType() {
        return managerType;
    }

    public void setManagerType(ManagerType managerType) {
        this.managerType = managerType;
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

    public void setRequests(ArrayList<Request> requests) {
        this.requests = requests;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return managerType.equals(manager.managerType) &&
        		requests.equals(manager.requests);
    }

    public int hashCode() {
        return Objects.hash(managerType, requests);
    }

    public String toString() {
        return super.toString() + " " + managerType + " " + requests; 
    }
    public void assignCourseToTeacher(Teacher teacher, Course course) {
        if (teacher != null && course != null) {
            teacher.addCourse(course);
            System.out.println("Course " + course.getCourseName() + " has been assigned to " + teacher.getFirstName() + ".");
        } else {
            System.out.println("Failed to assign course. Teacher or course is null.");
        }
    }


	
	public void addCourse(int yearOfStudy,String code, int numberOfCredits, String courseName) {
		Course newCourse = new Course();
		Course newCourse = new Course();
	    newCourse.setCode(code);
	    newCourse.setNumberOfCredits(numberOfCredits);
	    newCourse.setCourseName(courseName);
	    newCourse.setDescription(description);
	    newCourse.setCourseType(courseType);

	    courses.add(newCourse);
	} 
	
	public void removeCourseByCode(String code) {
	    for (Course course : courses) {
	        if (course.getCode().equals(code)) {
	            courses.remove(course);
	            System.out.println("Course with code " + code + " has been removed.");
	            return;
	        }
	    }
	    System.out.println("Course with code " + code + " not found.");
	}
	public void updateCourse(String code, String newName, String newDescription, CourseType newCourseType) {
	    for (Course course : courses) {
	        if (course.getCode().equals(code)) {
	            course.setCourseName(newName);
	            course.setDescription(newDescription);
	            course.setCourseType(newCourseType);
	            System.out.println("Course with code " + code + " has been updated.");
	            return; 
	        }
	    }
	    System.out.println("Course with code " + code + " not found.");
	}
	
	public void viewInfoOfTeachers(ArrayList<Teacher> teachers) {
	    System.out.println("List of Teachers and Their Courses:");
	    for (Teacher teacher : teachers) {
	        System.out.print("Name: " + teacher.getFirstName() + ", Courses: ");
	        for (Course course : teacher.getCourses()) {
	            System.out.print(course.getCourseName() + " ");
	        }
	        System.out.println(); 
	    }
	}
	

	}


}