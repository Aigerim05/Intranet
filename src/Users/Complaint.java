package Users;

public class Complaint extends Message {
    private Urgency urgencyLevel;
    private Student student;

    public Complaint(Employee sender, Employee receiver, String content, Urgency urgencyLevel, Student student) {
        super(sender, receiver, content);
        this.urgencyLevel = urgencyLevel;
        this.student = student;
    }

    public Urgency getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(Urgency urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Complaint)) return false;
        if (!super.equals(o)) return false;
        Complaint that = (Complaint) o;
        return urgencyLevel == that.urgencyLevel &&
                java.util.Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), urgencyLevel, student);
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "sender=" + getSender() +
                ", receiver=" + getReceiver() +
                ", content='" + getContent() + '\'' +
                ", urgencyLevel=" + urgencyLevel +
                ", student=" + student +
                '}';
    }
}
