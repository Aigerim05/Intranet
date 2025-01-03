package Users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class ResearchJournal implements Serializable{


	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<ResearchPaper> listOfSubscribers;
	private ArrayList<ResearchPaper> listOfResearchPapers;

	{
		listOfSubscribers = new ArrayList<>();
		listOfResearchPapers = new ArrayList<>();
	}
	public ResearchJournal() {
	}

	public ResearchJournal(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<ResearchPaper> getListOfSubscribers() {
		return listOfSubscribers;
	}

	public void setListOfSubscribers(ArrayList<ResearchPaper> listOfSubscribers) {
		this.listOfSubscribers = listOfSubscribers;
	}

	public ArrayList<ResearchPaper> getListOfResearchPapers() {
		return listOfResearchPapers;
	}

	public void setListOfResearchPapers(ArrayList<ResearchPaper> listOfResearchPapers) {
		this.listOfResearchPapers = listOfResearchPapers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(listOfResearchPapers, listOfSubscribers, name);
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
		ResearchJournal other = (ResearchJournal) obj;
		return Objects.equals(other.getName(), name);

	}

	@Override
	public String toString() {
		return "name=" + name;
	}




}