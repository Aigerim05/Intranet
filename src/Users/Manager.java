package Users;

import java.util.ArrayList;
import java.util.Objects;

import Attributes.Request;
import Enums.CourseType;
import Enums.Language;
import Enums.ManagerType;
import Interfaces.Employee;

public class Manager extends User implements Employee
{

	private ManagerType managerType;
	private ArrayList<Request> requests;

	{
		requests = new ArrayList<Request>();
	}

	public Manager(){
		super();
	}

	public Manager(String password, String email, String firstName, String lastName,
			String userId, Language language,ManagerType managerType) {
		super(firstName,lastName,userId,password,language);
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
	public void assignCourseToTeacher(Teacher teacher, Course course) {
		if (teacher != null && course != null) {
			teacher.addCourse(course);
			System.out.println(course.getCode() + " " + course.getCourseName() + " has been assigned to " + teacher.getFirstName() + ".");
		} else {
			System.out.println("Failed to assign course. Teacher or course is null.");
		}
	}



	public void addCourse(CourseType courseType, String code, int numberOfCredits, String courseName, String description) {
		Course newCourse = new Course();
		newCourse.setCode(code);
		newCourse.setNumberOfCredits(numberOfCredits);
		newCourse.setCourseName(courseName);
		newCourse.setDescription(description);
		newCourse.setCourseType(courseType);

		Data.INSTANCE.courses.add(newCourse);
	} 

	public void removeCourseByCode(String code) {
		for (Course course : Data.INSTANCE.courses) {
			if (course.getCode().equals(code)) {
				Data.INSTANCE.courses.remove(course);
				System.out.println("Course with code " + code + " has been removed.");
				return;
			}
		}
		System.out.println("Course with code " + code + " not found.");
	}
	public void updateCourse(String code, String newName, String newDescription, CourseType newCourseType) {
		for (Course course : Data.INSTANCE.courses) {
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

	public void viewInfoOfTeachers() {
		System.out.println("List of Teachers and Their Courses:");
		for (Teacher teacher : Data.INSTANCE.teachers) {
			System.out.print("Name: " + teacher.getFirstName() + ", Courses: ");
			for (Course course : teacher.getCourses()) {
				System.out.print(course.getCourseName() + " ");
			}
			System.out.println(); 
		}
	}

	public void approveStudent(Student student, Course course) { 
		if(course.isAvailableCourse()) {

			if(student.getCurrCredit() + course.getNumberOfCredits() > student.getMaxCredit()) {
				System.out.println("Student will get overcredit.");
				return;
			} 
			else {

				if(!student.getTakenCoursesArray().containsAll(course.getPrerequisites())) {
					System.out.println("Student do not match prerequisites");
					return;
				}

				else {

					Mark mark = new Mark(); 
					student.getJournal().put(course, mark);
					course.addParticipant(student);  
					System.out.println("Student " + student.getFirstName() + " " + student.getLastName() + " was added to the course " + course.getCode() + " " + course.getCourseName());
					return;
				}
			}
		} 
		else {

			System.out.println("The course " + course.getCode() + " " + course.getCourseName() + " has no available places.");
		}
		return;
	}





}


