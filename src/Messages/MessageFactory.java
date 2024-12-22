package Messages;

import Users.Employee;
import Users.Teacher;

public class MessageFactory {

    public static Message getMessage(String type) {
        switch (type) {
            case "Complaint":
                return new Complaint();
            case "WorkMessage":
                return new WorkMessage();
            case "Request":
                return new Request();
            default:
                throw new IllegalArgumentException("Message Type Uknown: " + type);
        }
    }
}
