package Users;

import java.util.ArrayList;

import Attributes.Message;
import Enums.Language;

public class Employee extends User{


	ArrayList<Message> messages;
	double salary;


	// 1. in Data class create ArrayList<Employee>
	// 2. 

	//
	//	1) Amina   0
	//2) Aigerim    1
	//3) 
	//
	//Choose number of employee
	//int choice = in.nextInt();
	//1


	// -> "To whom you want to send message?"
	// -> UserOperation.printList(Data.getInstance().employees)
	//	Employee chosenEmployee = Data.getInstance().Employees.get(choice - 1);
	// 
	// message.send(teacher, chosenEmployee, content){
	//      MessageFactory.create
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
		return "Employee{" +
				"userId=" + super.getUserId() +"," +
				"password=" +super.getPassword() + "," +
				"firstName=" +super.getFirstName() + ',' +
				"lastName=" + super.getLastName() + ',' +
				"salary=" + salary;
	}

}
