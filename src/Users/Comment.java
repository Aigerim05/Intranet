package Users;

import java.util.Objects;

public class Comment {
    private Commentable author;
    private String content;

    // Пустой конструктор
    public Comment() {}

    // Конструктор с параметрами
    public Comment(Commentable author, String content) {
        this.author = author;
        this.content = content;
    }

    // Getters и Setters
    public Commentable getAuthor() {
        return author;
    }

    public void setAuthor(Commentable author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(author, comment.author) &&
                Objects.equals(content, comment.content);
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(author, content);
    }

    // toString
    @Override
    public String toString() {
        return "Comment{" +
                "author=" + author +
                ", content='" + content + '\'' +
                '}';
    }
}
