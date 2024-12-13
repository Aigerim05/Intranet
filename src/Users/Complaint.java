package Attributes;

import Interfaces.Employee;
import Users.Teacher;
import Data.Data;

public class Complaint extends Message {
    private String department;

    public Complaint() {
        super();
    }

    public Complaint(Employee sender, Employee receiver, String content, String messageId, String department) {
        super(sender, receiver, content, messageId);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void send() {
        Employee decan = Data.getInstance().getDecans().stream()
                .filter(d -> d.getDepartment().equals(this.department))
                .findFirst()
                .orElse(null);

        if (decan != null) {
            decan.getComplaints().add(this);
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
