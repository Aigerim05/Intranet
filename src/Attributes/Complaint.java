package Attributes;

import Enums.Urgency;
import Interfaces.Employee;
import Users.Student;

public class Complaint extends Message {
	private Urgency urgencyLevel;
	private Student student;

	public Complaint() {
		super(); 
	}

	public Complaint(Employee sender, Employee receiver, String content, Urgency urgencyLevel, Student student) {
		super(sender, receiver, content);
		this.urgencyLevel = urgencyLevel;
		this.student = student;
	}
	public Urgency getUrgencyLevel() {
		return urgencyLevel;
	}
	public void setUrgencyLevel(Urgency urgencyLevel) {
		this.urgencyLevel = urgencyLevel;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Complaint{" +
				"sender=" + getSender() +
				", receiver=" + getReceiver() +
				", content='" + getContent() + '\'' +
				", urgencyLevel=" + urgencyLevel +
				", student=" + student.toString() +
				'}';
	}
}