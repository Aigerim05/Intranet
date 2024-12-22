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
	public void sendMessage() {
		System.out.println("Which Type of Message you want to send?\n1) WorkMessage\n2) Request\n3) Complaint");

		Message newMessage = null;
		switch(inp.nextInt()) {
		case 1:
			newMessage = MessageFactory.getMessage("WorkMessage");
		case 2:
			newMessage = MessageFactory.getMessage("Request");
		case 3:
			if(this instanceof Teacher) {
				newMessage = MessageFactory.getMessage("Complaint");
			}
			else System.out.println("Only teacher can send complaints");
		default:
			System.out.println("Invalid message type");
			// sendMessage() abort? можно сделать цикл пока не введет правильный тип или 0 - чтобы выйти
		}

		System.out.println("Select Employee you want to send message to");
		UserOperation.printList(Data.getInstance().employees); 
		Employee chosenEmployee = Data.getInstance().employees.get(inp.nextInt() - 1); // тоже нужно будет сделать проверку на инвалид чойс

		System.out.println("Write a content of the message");
		String content = inp.nextLine();
		newMessage.setSender(this);
		newMessage.setReceiver(chosenEmployee);
		newMessage.setContent(content);
		// здесь можно выписать весь мессадж перед отправлением и спросить вы готовы отправить? и можно также его отредактирова
		newMessage.send();
		System.out.println("Message has been sent!");
	}

}
