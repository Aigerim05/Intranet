package Attributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import Enums.NewsTopic;

public class News {
	private String newsId;
	private NewsTopic topic;
	private ArrayList<Comment> comments;
	private Date publicationDate;
	private String content;

	{
		comments = new ArrayList<Comment>();
	}

	public News() {

	}


	public News(String newsId, NewsTopic topic, ArrayList<Comment> comments, Date publicationDate, String content) {
		this.newsId = newsId;
		this.topic = topic;
		this.comments = comments;
		this.publicationDate = publicationDate;
		this.content = content;
	}

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
		this.comments = comments;
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


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		News news = (News) obj;
		return this.newsId.equals(news.newsId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(newsId, publicationDate, content);
	}
}