package Users;

import java.util.ArrayList;
import java.util.Objects;

import com.sun.net.httpserver.Request;
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
	
    public void addCourse(String code, int numberOfCredits, String courseName, String description, CourseType courseType) {
        Course newCourse = new Course();
        newCourse.setCode(code);
        newCourse.setNumberOfCredits(numberOfCredits);
        newCourse.setCourseName(courseName);
        newCourse.setDescription(description);
        newCourse.setCourseType(courseType);
        courses.add(newCourse);
    }


	public void displayCourses() {
        System.out.println("\nList of Courses:");
        for (Course course : courses) {
            System.out.println("Code: " + course.getCode());
            System.out.println("Name: " + course.getCourseName());
            System.out.println("Credits: " + course.getNumberOfCredits());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Type: " + course.getCourseType());
        }
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

	
    public boolean approveStudent(Student student, Course course) {
	     if (course.getParticipants().size() < course.getMaxCountOfStudents()) {
	          course.getParticipants().add(student);
	           System.out.println("Student " + student.getFirstName() + " has been approved for the course " + course.getCourseName() + ".");
	           return true; 
	      } else {
	            System.out.println("No available seats for the course " + course.getCourseName() + ". Approval denied.");
	            return false; 
	        }
	    }

	
	
    public static boolean assignCourseToTeacher(Teacher teacher, Course course) {
        if (teacher != null && course != null) {
            teacher.getCourses().add(course);  
            System.out.println("Teacher " + teacher.getFirstName() + " has been assigned to the course: " + course.getCourseName());
            return true;
        }
        return false;
    }


	
    public void viewInfoOfStudents(ArrayList<Student> students) {
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println("Name: " + student.getFirstName() + ", Age: " + student.getYearOfStudy());
        }
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

	public Void createStatistics(Course parameter) {
		// TODO implement me
		return null;	
	}
	public void manageNews() {
		// TODO implement me	
	}
	
	
	public Void viewRequests() {
		// TODO implement me
		return null;	
	}
	
	public boolean addNews() {
		// TODO implement me
		return false;	
	}
	
	
	public boolean removeNews() {
		// TODO implement me
		return false;	
	}
	public boolean updateNews() {
		// TODO implement me
		return false;	
	}
	
	public Void printResearchPapersOfAllResearchers(ArrayList<ResearcherDecorator> parameter) {
		// TODO implement me
		return null;	
	}
	
	
	public Void printTopCitedResearcher(ArrayList<ResearchDecorator> parameter) {
		// TODO implement me
		return null;	
	}
	
	
	public boolean addNews(News parameter) {
		// TODO implement me
		return false;	
	}
	
	
	public boolean deleteNews(News parameter) {
		// TODO implement me
		return false;	
	}
	
	
	public boolean updateNews(News parameter) {
		// TODO implement me
		return false;	
	}
	
}

