package Users.News;

import java.util.Date;

public class Comment{
	
	User author;
	String content;
	Date commentDate;
	News news;
	@Override
	public void addComment(User author, News n, String content) {
		this.author = author;
		this.news = n;
		this.content = content;
		commentDate = new Date();
		n.addComment(this);
	}
	
	public String getComment() {
		return this.commentDate + "/n" + this.author + "/n/n" + this.content + "/n";
	}
	
}
