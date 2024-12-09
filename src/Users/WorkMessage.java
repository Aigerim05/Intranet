package Users;

import java.util.Objects;

public class WorkMessage extends Message {
    private Urgency urgencyLevel;

    public WorkMessage() {
        super();
    }

    public WorkMessage(Employee sender, Employee receiver, String content, Urgency urgencyLevel) {
        super(sender, receiver, content);
        this.urgencyLevel = urgencyLevel;
    }

    public Urgency getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(Urgency urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WorkMessage that = (WorkMessage) o;
        return urgencyLevel == that.urgencyLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), urgencyLevel);
    }

    @Override
    public String toString() {
        return "WorkMessage{" +
                "sender=" + getSender() +
                ", receiver=" + getReceiver() +
                ", content='" + getContent() + '\'' +
                ", urgencyLevel=" + urgencyLevel +
                '}';
    }
}
