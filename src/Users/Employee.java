package Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Users.Messages.Message;
import Users.Messages.MessageFactory;

public class Employee {
    private String name;
    private Scanner inp = new Scanner(System.in);
    private ArrayList<Message> messages = new ArrayList<>();
    
    public Employee(String name, String department) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMessage(Message m) {
    	this.messages.add(m);
    }
    public void sendMessage() {
    	System.out.println("Which Type of Message you want to send?");
    	
    	var messages = List.of("Simple Message", "Work Message", "Complaint", "Request");
    	for(int i=0; i<messages.size(); i++) {
    		System.out.println(i+1 + ") " + messages.get(i));
    	}
    	
    	Message newMessage = null;
    	switch(inp.nextInt()) {
    	case 1:
    		newMessage = MessageFactory.getMessage("SimpleMessage", this);
    	case 2:
    		newMessage = MessageFactory.getMessage("WorkMessage", this);
    	case 3:
    		newMessage = MessageFactory.getMessage("Request", this);
    	case 4:
    		newMessage = MessageFactory.getMessage("Complaint", this);
    	default:
    		System.out.println("Invalid message type");
    		return; // sendMessage() abort? можно сделать цикл пока не введет правильный тип или 0 - чтобы выйти
    	}
    	
    	
    }

}
