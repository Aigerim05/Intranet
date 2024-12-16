package Users;

import java.util.ArrayList;
import java.util.Scanner;

import Users.Messages.Message;
import Users.Messages.MessageFactory;

public class Employee {
    private String name;

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
    
}
