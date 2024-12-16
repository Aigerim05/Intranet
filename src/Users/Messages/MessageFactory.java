package Users.Messages;

import Users.Employee;
import Users.Teacher;

public class MessageFactory {

    public static Message getMessage(String type, Employee caller) {
        switch (type) {
            case "Complaint":
                if (caller instanceof Teacher) {
                    return new Complaint();
                } else {
                    System.out.println("Only Teacher Can Send Complaints");
                }
            case "WorkMessage":
                return new WorkMessage();
            case "Request":
                return new Request();
            case "SimpleMessage":
                return new SimpleMessage();
            default:
                throw new IllegalArgumentException("Message Type Uknown: " + type);
        }
    }
}
