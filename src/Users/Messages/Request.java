package Users.Messages;

import Users.Employee;

import java.util.ArrayList;

import Users.Dean;
import Users.Manager;

public class Request extends Message {
    private boolean assignedStatus = false;
    private Manager managerOR;
    
    public Request() {
        super();
    }  
    
    public Request(Employee sender, Employee receiver, Manager managerOR, String content) {
        super(sender, receiver, content);
        this.managerOR = managerOR;
    }

    public boolean isAssignedStatus() {
        return assignedStatus;
    }

    public void setAssignedStatus(boolean assignedStatus) {
        this.assignedStatus = assignedStatus;
    }
    
    public Dean chooseDean() {
    	System.out.println("Choose Dean:");
    	ArrayList<Dean> deans = Dean.getDeans()
    }
    
    public void send() {
        for(Dean d : Data.instance.getDeans()) {
        	if(this.getSender().getDepartment().equals(d.getDepartment())) {
        		d.signRequest(this);
        	}
        }
        managerOR.addRequest(this);
    }

    @Override
    public String toString() {
        return "Request{" +
                "sender=" + getSender() +
                ", receiver=" + getReceiver() +
                ", content='" + getContent() + '\'' +
                ", assignedStatus=" + assignedStatus +
                '}';
    }
}
