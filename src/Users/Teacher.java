package Users;


import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
public class Teacher extends User
{


	private Position position;
	private Department department;
	private ArrayList<Integer> ratings;
	private ArrayList<Course> courses;
	private ResearchDecorator researchDecorator;
	{
		courses = new ArrayList<>();
		ratings = new ArrayList<>();
	}

	public Teacher(){
		super();
	}

	public Teacher(String password, String email, String firstName, String lastName,
			String userId, Language language,Position position, Department department, ResearchDecorator researchDecorator) {
		super(password, email, firstName, lastName, userId, language);
		this.position = position;
		this.department = department;
		this.researchDecorator = researchDecorator;
	}

	public ResearchDecorator getResearchDecorator() {
		return researchDecorator;
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

	

	public void putMark(Student student, Course course, int attType, double score) {
	    if (student.getJournal().containsKey(course)) {
	        Mark mark = student.getJournal().get(course);

	        if (attType == 1) {
	            mark.setFirstAttestation(score);  
	        } else if (attType == 2) {
	            mark.setSecondAttestation(score);  
	        } else if (attType == 3) {
	            mark.setFinalExam(score);  
	        }

	        student.getJournal().put(course, mark);
	    }
	}


	public boolean addRating(int rate) {
		return this.ratings.add(rate);
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
	
	public ResearchDecorator createResearcher(Teacher teacher) {
	    if (teacher.getPosition() == Position.PROFESSOR) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter User Name: ");
	        String name = scanner.nextLine();

	        System.out.print("Enter Department: ");
	        String department = scanner.nextLine();

	        System.out.print("Enter H-Index: ");
	        int hIndex = scanner.nextInt();
	        return new ResearchDecorator(new User(), hIndex, teacher.getDepartment());
	    } else {
	        return null; 
	    }
	}

	

	public ResearchDecorator askForResearcherRole() {
	    Scanner scanner = new Scanner(System.in);

	    System.out.print("Do you want to become a researcher? (yes/no): ");
	    String response = scanner.nextLine().trim().toLowerCase();

	    if ("yes".equals(response)) {
	        return createResearcher(this);
	    } else {
	        return null;
	    }
	}


}



	