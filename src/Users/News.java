package Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class News {
    private String newsId;
    private NewsTopic topic;
    private ArrayList<Comment> comments;
    private Date publicationDate;
    private String content;

    // Пустой конструктор
    public News() {
        this.comments = new ArrayList<>(); // Инициализация ArrayList
    }

    // Конструктор с параметрами
    public News(String newsId, NewsTopic topic, ArrayList<Comment> comments, Date publicationDate, String content) {
        this.newsId = newsId;
        this.topic = topic;
        this.comments = comments != null ? comments : new ArrayList<>();
        this.publicationDate = publicationDate;
        this.content = content;
    }

    // Getters и Setters
    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public NewsTopic getTopic() {
        return topic;
    }

    public void setTopic(NewsTopic topic) {
        this.topic = topic;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments != null ? comments : new ArrayList<>();
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
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
        News news = (News) o;
        return Objects.equals(newsId, news.newsId) &&
                topic == news.topic &&
                Objects.equals(comments, news.comments) &&
                Objects.equals(publicationDate, news.publicationDate) &&
                Objects.equals(content, news.content);
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(newsId, topic, comments, publicationDate, content);
    }

    // toString
    @Override
    public String toString() {
        return "News{" +
                "newsId='" + newsId + '\'' +
                ", topic=" + topic +
                ", comments=" + comments +
                ", publicationDate=" + publicationDate +
                ", content='" + content + '\'' +
                '}';
    }
}
