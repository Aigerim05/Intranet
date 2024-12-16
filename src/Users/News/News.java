package Users.News;

import java.util.Queue;
import java.util.Random;
import java.util.Date;
import java.util.LinkedList;

public class News implements Comparable<News>{
	private String id;
	private String content;
	private NewsTopic topic;
	private final Queue<Comment> comments = new LinkedList<>();
	private Date publicationDate;
	
	public News(String content, NewsTopic topic) {
		this.content = content;
		this.topic = topic;
		this.publicationDate = new Date();
		this.id = idGenerator();
	}
	
	private String idGenerator() {
		Random random = new Random();
		return "N"+ String.valueOf(1000 + random.nextInt(9000));
	}
	
	public void addComment(Comment c) {
		this.comments.add(c);
	}
	public Queue<Comment> getComments() {
		return this.comments;
	}
	
	public void printNews() {
		System.out.println(this.publicationDate);
		System.out.println(this.topic.toString()+"\n");
		System.out.println(this.content+"\n\n");
		for(Comment c : this.comments) {
			System.out.println(c.getComment()+"/n");
		}
	}

	public String toString() {
		return "News[id=" + id + ", topic=" + topic + ", publicationDate=" + publicationDate + "]";
	}

	@Override
	public int compareTo(News o) {
		return this.publicationDate.compareTo(o.publicationDate);
	}
	
}
