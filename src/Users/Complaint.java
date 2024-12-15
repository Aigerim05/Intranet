package Attributes;

import Interfaces.Employee;
import Users.Teacher;
import Data.Data;

package Users.Messages;

import Users.Employee;
import Users.Dean;
import Users.Teacher;
import Data.Data;

public class Complaint extends Message implements Sendable{
    private String department;

    public Complaint() {
        super();
    }

    public Complaint(Employee sender, Employee receiver, String content, String messageId, String department) {
        super(sender, receiver, content);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void send() {
        Dean decan;
        for(Users.Employee d : Data.getEmployees()) {
        	if(d instanceof Dean && this.getSender().getDepartment().equals(d.getDepartment())) {
        		decan = (Dean) d;
        	}
        }
        if (decan != null) {
            decan.addComplaint(this);
        }
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "sender=" + getSender() +
                ", receiver=" + getReceiver() +
                ", content='" + getContent() + '\'' +
                ", messageId='" + getMessageId() + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
