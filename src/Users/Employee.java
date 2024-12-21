package Users;

import java.util.ArrayList;

import Attributes.Message;
import Enums.Language;

public class Employee extends User{


	ArrayList<Message> messages;
	double salary;


	{
		messages = new ArrayList<>();
	}

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String userId, String password, Language language, double salary) {
		super(firstName, lastName, userId, password, language);
		this.salary = salary;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "EResearcher{" +
				"userId=" + super.getUserId() +"," +
				"password=" +super.getPassword() + "," +
				"firstName=" +super.getFirstName() + ',' +
				"lastName=" + super.getLastName() + ',' +
				"salary=" + salary;
	}

}
