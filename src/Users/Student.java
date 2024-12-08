package Users;

import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;

public class Student extends User{
	private int yearOfStudy = 0;
	private HashMap<Course, Mark> journal;
	private int maxCredit = 0;
	private Department department = Department.SITE;
	
	{
		HashMap<Course, Mark> journal = new HashMap<Course,Mark>();
	}

	public Student(){

	}

	public Student(){
		super();
		this.yearOfStudy = (Integer) null;
		this.journal = null;
		this.maxCredit = (Integer) null;
	}
	
	public Student(String firstName, String lastName, String userId, String password, String email, Language language, ArrayList<Date> logins,int yearOfStudy, HashMap<Course, Mark> journal, int maxCredit, Department department) {
		super(firstName,lastName,userId,password,language,logins);
		this.yearOfStudy = yearOfStudy;
		this.journal = journal;
		this.maxCredit = maxCredit;
		this.department = department;
		
	}
	public Student(String firstName, String lastName, String userId, String password, String email, Language language, ArrayList<Date> logins,int yearOfStudy,int maxCredit) {
		super(firstName,lastName,userId,password,language,logins);
		this.yearOfStudy = yearOfStudy;
		this.maxCredit = maxCredit;
	}
	public Student(String firstName, String lastName, String userId, String password, String email, Language language, ArrayList<Date> logins,int yearOfStudy) {
		super(firstName,lastName,userId,password,language,logins);
		this.yearOfStudy = yearOfStudy;
	}
	public Student(String firstName, String lastName, String userId, String password, String email, Language language, ArrayList<Date> logins,int yearOfStudy) {
		super(firstName,lastName,userId,password,language,logins);
		this.yearOfStudy = yearOfStudy;
		
	}
	public Student(String firstName, String lastName, String userId, String password, String email, Language language, ArrayList<Date> logins) {
		super(firstName,lastName,userId,password,language,logins);
	}
	public int getYearOfStudy() {
		return yearOfStudy;
	}
	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	public HashMap<Course, Mark> getJournal() {
		return journal;
	}
	public void addToJournal(Course course, Mark mark) {
		this.journal.put(course, mark);
	}
	public int getMaxCredit() {
		return maxCredit;
	}
	public void setMaxCredit(int maxCredit) {
		this.maxCredit = maxCredit;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return super().toString + "Student [yearOfStudy=" + yearOfStudy + ", maxCredit=" + maxCredit
				+ ", department=" + department + "]";
	}

	@Override
	public boolean equals(Object other){
		if(other == null) return false;
		if(other == this) return true;
		if(!(other instanceof Student)) return false;
		Student otherStudent = (Student) other;
		return this.getId().equals(otherStudent.getId());
	}

	@Override
	public int hashCode(){
		return this.getId().hashCode();
	}
}
