package Users;
import java.io.Serializable;
import java.util.ArrayList;
public class ResearchJournal implements Serializable
{
	
	private String name;
	private ArrayList<Subscriber> listOfSubscribers;
	
	
	public ResearchJournal(){
		
	}
	
	public boolean subscribe() {
		// TODO implement me
		return false;	
	}
	
	public boolean unsubscribe() {
		// TODO implement me
		return false;	
	}
	
	
	public boolean notify() {
		// TODO implement me
		return false;	
	}
	
}

