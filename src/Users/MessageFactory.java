package Attributes;

import Interfaces.Employee;
import Users.Teacher;

public class MessageFactory {

    public Message getMessage(String type, Employee caller) {
        switch (type) {
            case "Complaint":
                if (caller instanceof Teacher) {
                    return new Complaint();
                } else {
                    // Возвращаем простое сообщение или выводим сообщение об ошибке
                    return new SimpleMessage(null, null, "Access Denied");
                }
            case "WorkMessage":
                return new WorkMessage();
            case "Request":
                return new Request();
            case "SimpleMessage":
                return new SimpleMessage();
            default:
                throw new IllegalArgumentException("Неизвестный тип сообщения: " + type);
        }
    }
}
