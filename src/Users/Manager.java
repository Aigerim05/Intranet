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
	
	public void addCourse(int yearOfStudy, String courseName, String courseCode, int numberOfCredits) {
		Course newCourse = new Course(courseName, courseCode, numberOfCredits);
		    if (this.yearOfStudy == yearOfStudy) {
		        this.courses.add(newCourse);
		        System.out.println("Course " + newCourse.getCourseName() + " added for year " + yearOfStudy);
		    } else {
		        System.out.println("This course is not applicable for the current year of study.");
		    }
	}

	public void removeCourse() {
	}
	
	public void updateCourse() {
	}
	
	public boolean approveStudent(Student parameter) {
	
		return false;	
	}
	
	
	public boolean assignCourseToTeacher(Teacher parameter, Course parameter2, CourseType parameter3) {
	
		return false;	
	}
	
	
	public Void viewInfoOfTeachers(ArrayList<Teacher> parameter) {
	
		return null;	
	}
	
	
	public Void viewInfoOfStudents(ArrayList<Student> parameter) {
		// TODO implement me
		return null;	
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

