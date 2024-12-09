package Users;
import java.util.Objects;

public class WorkMessage extends Message {
	
    // Конструктор по умолчанию (для работы фабрики)
    public WorkMessage() {
        super(); // Вызываем конструктор родительского класса
    }

    // Constructor
    public WorkMessage(Employee sender, Employee receiver, String content) {
        super(sender, receiver, content);
    }

    // Equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkMessage)) return false;
        if (!super.equals(o)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    // toString method
    @Override
    public String toString() {
        return "WorkMessage{" +
                "sender=" + getSender() +
                ", receiver=" + getReceiver() +
                ", content='" + getContent() + '\'' +
                '}';
    }
}
