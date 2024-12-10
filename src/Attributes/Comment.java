package Attributes;
import java.util.Objects;

import Interfaces.Commentable;
public class Comment {
	private Commentable author;
	private String content;

	public Comment() {}



	public Comment(Commentable author, String content) {
		this.author = author;
		this.content = content;
	}



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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Comment comment = (Comment) o;
		return Objects.equals(author, comment.author) &&
				Objects.equals(content, comment.content);
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, content);
	}

	@Override
	public String toString() {
		return "Comment{" +
				"author=" + author.toString() +
				", content='" + content + '\'' +
				'}';
	}
}