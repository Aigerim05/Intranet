package Users;

import java.util.ArrayList;

import Users.Messages.*;

public class Dean extends Employee{

    private String name;
    private ArrayList<Complaint> complaints;
    public Dean(String name) {
        this.name = name;
    }

    public void update(Message message) {
        System.out.println(name + " получил уведомление о новом сообщении: " + message.getContent());
        if (message instanceof Complaint) {
            handleComplaint((Complaint) message);
        } else if (message instanceof Request) {
            handleRequest((Request) message);
        }
    }
    
    public void addComplaint(Message c) {
    	this.complaints.add(c);
    }
    
    public void signRequest(Request r) {
    	r.setAssignedStatus(true);
    }
    
    private void handleComplaint(Complaint complaint) {
        System.out.println(name + " обрабатывает жалобу: " + complaint.getContent());
    }

    private void handleRequest(Request request) {
        System.out.println(name + " подписывает запрос: " + request.getContent());
    }
}
