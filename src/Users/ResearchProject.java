package Users;

import java.util.ArrayList;
import java.util.Objects;

public class ResearchProject {
	private String topic;
	private ArrayList<ResearchDecorator> participants;
	private ArrayList<ResearchPaper> publishedPaper;
	{
		participants = new ArrayList<>();
		publishedPaper = new ArrayList<>();
	}
	public ResearchProject() {
		
	}
	public ResearchProject(String topic) {
		this.topic = topic;
	}
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ResearchProject other = (ResearchProject) obj;
		return participants.equals(other.participants) && publishedPaper.equals(other.publishedPaper)
				&& topic.equals(other.topic);
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(participants, publishedPaper, topic);
	}
	@Override
	public String toString() {
		return "Topic: " + topic + " Participants: " + participants + " Published Paper:" + publishedPaper;
	}
	
	public void addParticipants(ResearchDecorator participant) {
		 if (participant != null && !participants.contains(participant)) {
		        participants.add(participant);
		 }
	}
	
	public boolean removeParticipants(ResearchDecorator participant) {
		return participants.remove(participant);
	}
	
	public void addResearchPaper(ResearchPaper paper) {
		if (paper != null && !publishedPaper.contains(paper)) {
	        publishedPaper.add(paper);}
	}
	
		public boolean removeResearchPaper(ResearchPaper paper) {
		    return publishedPaper.remove(paper);
	}
}
