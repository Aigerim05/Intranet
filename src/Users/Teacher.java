package Users ;
import java.util.ArrayList;
import java.util.Objects;

import Enums.Department;
import Enums.Language;
import Enums.Position;
import Interfaces.Employeeable;
public class Teacher extends Employee implements Employeeable
{
	private Researcher researcher;

	private Position position;
	private Department department;
	private ArrayList<Integer> ratings;
	private ArrayList<Course> courses;

	{
		courses = new ArrayList<Course>();
		ratings = new ArrayList<Integer>();
	}

	public Teacher(){
		super();
	}


	public Teacher(String firstName, String lastName,
			String userId, String password,  Language language, Position position, Department department, double salary) {
		super(firstName,lastName,userId,password,language, salary);
		this.position = position;
		this.department = department;
		if (position == Position.PROFESSOR) {
			this.researcher = ResearchUtils.createResearcher(this);

		}
		else {
			this.researcher = ResearchUtils.askForResearcherRole(this);
		}
	}



	public Researcher getResearcher() {
		return researcher;
	}


	public void setResearcher(Researcher researcher) {
		this.researcher = researcher;
	}


	public ArrayList<Integer> getRatings() {
		return ratings;
	}

	public void setRatings(ArrayList<Integer> ratings) {
		this.ratings = ratings;
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

	public ArrayList<Course> getCourses(){
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		if (!super.equals(o))
		{
			return false; 
		}

		Teacher teacher = (Teacher) o;  
		return this.department.equals(teacher.department) &&
				this.position.equals(teacher.position);  
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), position, department);
	}

	@Override
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

	public boolean addCourse(Course course) {
		return courses.add(course);
	}



	public double getAverageRating() {
		if (ratings.isEmpty()) {
			return 0.0;  
		}

		int sum = 0;
		for (int rating : ratings) {
			sum += rating;
		}
		return sum / (double) ratings.size();  
	}
}
