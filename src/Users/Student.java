 package Users;

import java.lang.classfile.Superclass;

import User;

public class Student extends User{
	private int yearOfStudy;
	private HashMap<Course, Mark> journal;
	private int maxCredit;
	private Department department;
	
	public Student(String firstName, String lastName, String userId, String password, String email, Language language, ArrayList<Date> logins, ArrayList<ResearchJournal> subscriptions,int yearOfStudy, HashMap<Course, Mark> journal, int maxCredit, Department department) {
		super(firstName,lastName,userId,password,language,logins,subscriptions);
		this.yearOfStudy = yearOfStudy;
		this.journal = journal;
		this.maxCredit = maxCredit;
		this.department = department;
		
	}
	public Student(String firstName, String lastName, String userId, String password, String email, Language language, ArrayList<Date> logins, ArrayList<ResearchJournal> subscriptions,int yearOfStudy, HashMap<Course, Mark> journal, int maxCredit) {
		super(firstName,lastName,userId,password,language,logins,subscriptions);
		this.yearOfStudy = yearOfStudy;
		this.journal = journal;
		this.maxCredit = maxCredit;
		this.department = null;
	}
	public Student(String firstName, String lastName, String userId, String password, String email, Language language, ArrayList<Date> logins, ArrayList<ResearchJournal> subscriptions,int yearOfStudy, HashMap<Course, Mark> journal) {
		super(firstName,lastName,userId,password,language,logins,subscriptions);
		this.yearOfStudy = yearOfStudy;
		this.journal = journal;
		this.maxCredit = (Integer) null;
		this.department = null;
	}
	public Student(String firstName, String lastName, String userId, String password, String email, Language language, ArrayList<Date> logins, ArrayList<ResearchJournal> subscriptions,int yearOfStudy) {
		super(firstName,lastName,userId,password,language,logins,subscriptions);
		this.yearOfStudy = yearOfStudy;
		this.journal = null;
		this.maxCredit = (Integer) null;
		this.department = null;
		
	}
	public Student(String firstName, String lastName, String userId, String password, String email, Language language, ArrayList<Date> logins, ArrayList<ResearchJournal> subscriptions) {
		super(firstName,lastName,userId,password,language,logins,subscriptions);
		this.yearOfStudy = (Integer) null;
		this.journal = null;
		this.maxCredit = (Integer) null;
		this.department = null;
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
	public void setJournal(HashMap<Course, Mark> journal) {
		this.journal = journal;
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
		return super().toString + "Student [yearOfStudy=" + yearOfStudy + ", journal=" + journal + ", maxCredit=" + maxCredit
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
