package Users;

import java.util.ArrayList;
import java.util.Objects;

import Attributes.Request;
import Enums.CourseType;
import Enums.Language;
import Enums.ManagerType;

public class Manager extends Employee{

	private ManagerType managerType;
	private ArrayList<Request> requests;

	{
		requests = new ArrayList<>();
	}

	public Manager(){
		super();
	}

	public Manager(String password, String firstName, String lastName,
			String userId, Language language,ManagerType managerType, double salary) {
		super(firstName,lastName,userId,password,language, salary);
		this.managerType = managerType;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}
		Manager manager = (Manager) o;
		return managerType.equals(manager.managerType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(managerType, super.hashCode());
	}

	@Override
	public String toString() {
		return super.toString() + " " + managerType; 
	}




	public void addCourse(CourseType courseType, String code, int numberOfCredits, String courseName, String description, int maxCountOfStudents, ArrayList<Course> prerequisites) {
		Course newCourse = new Course();
		newCourse.setCode(code);
		newCourse.setNumberOfCredits(numberOfCredits);
		newCourse.setCourseName(courseName);
		newCourse.setDescription(description);
		newCourse.setCourseType(courseType);
		newCourse.setMaxCountOfStudents(maxCountOfStudents);
		newCourse.setPrerequisites(prerequisites);
		Data.getInstance().courses.add(newCourse);
	} 


	public void removeCourseByCode(String code) {
		for (Course course : Data.getInstance().courses) {
			if (course.getCode().equals(code)) {
				Data.getInstance().courses.remove(course);
				System.out.println("Course with code " + code + " has been removed.");
				return;
			}
		}
		System.out.println("Course with code " + code + " not found.");
	}
	public void updateCourse(String code, String newName, String newDescription, CourseType newCourseType) {
		for (Course course : Data.getInstance().courses) {
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




	public void approveStudent(Student student, Course course) { 
		if(course.isAvailableCourse()) {
			if (student.getCurrCredit() + course.getNumberOfCredits() > student.getMaxCredit()) {
				System.out.println("Student will get overcredit.");
				return;
			} 

			if (!student.getTakenCoursesArray().containsAll(course.getPrerequisites())) {
				System.out.println("Student does not meet prerequisites.");
				return;
			}
			Mark mark = new Mark(0, 0, 0);  

			student.getJournal().put(course, mark);


			course.addParticipant(student);
			System.out.println(student.getFirstName() + " was added to the course " + course.getCourseName() + ' ' + course.getCode());

		}
		else {
			System.out.println("The course " + course.getCode() + " " + course.getCourseName() + " has no available places.");
		}
	} 
}


