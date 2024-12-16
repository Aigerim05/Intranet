package Users.News;

import java.util.Date;

public class Comment implements Commentable{
	
	Commentable author;
	String content;
	Date commentDate;
	@Override
	public void addComment(News n, String content) {
		// TODO Auto-generated method stub
		n.addComment(this);
		commentDate = new Date();
	}
	
	public String getComment() {
		return this.commentDate + "/n" + this.author + "/n/n" + this.content;
	}
	
}
