package Users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class ResearchProject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String topic;
	private String projectId;
	private ArrayList<Researcher> participants;
	private ArrayList<ResearchPaper> publishedPapers;


	{
		participants = new ArrayList<>();
		publishedPapers = new ArrayList<>();
	}

	public ResearchProject() {

	}
	public ResearchProject(String topic, String projectId) {
		this.topic = topic;
		this.projectId = projectId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public ArrayList<Researcher> getParticipants() {
		return participants;
	}

	public void setParticipants(ArrayList<Researcher> participants) {
		this.participants = participants;
	}

	public ArrayList<ResearchPaper> getPublishedPapers() {
		return publishedPapers;
	}

	public void setPublishedPapers(ArrayList<ResearchPaper> publishedPapers) {
		this.publishedPapers = publishedPapers;
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
		return projectId.equals(other.projectId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(projectId);
	}


	@Override
	public String toString() {
		return "ResearchProject [topic=" + topic + ", projectId=" + projectId + "]";
	}


	public boolean addParticipants(Researcher participant) {
		if (participant != null && !participants.contains(participant)) {
			return participants.add(participant);
		}
		return false;
	}

	public boolean removeParticipants(Researcher participant) {
		if (participants.contains(participant)) {
			return participants.remove(participant);
		}
		return false;
	}

	public boolean addResearchPaper(ResearchPaper paper) {
		if (paper != null && !publishedPapers.contains(paper)) {
			return publishedPapers.add(paper);
		}
		return false;
	}

	public boolean removeResearchPaper(ResearchPaper paper) {
		if (paper != null && !publishedPapers.contains(paper)) {
			return publishedPapers.remove(paper);
		}
		return false;
	}

	public void printParticipants() {
		if (participants == null || participants.isEmpty()) {
			System.out.println("No participants found.");
		} else {
			for (Researcher participant : participants) {
				System.out.println(participant.toString());
			}
		}
	}
}