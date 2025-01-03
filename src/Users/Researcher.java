package Users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;

public class Researcher implements Serializable{



	//	private static final long serialVersionUID = 1L;
	private User user;
	private ArrayList<ResearchPaper> researchPapers;
	private ArrayList<ResearchProject> researchProjects;
	private String field;

	{
		researchPapers = new ArrayList<>();
		researchProjects = new ArrayList<>();
	}
	public Researcher() {

	}

	public Researcher(User user, String field) {
		this.user = user;
		this.field  = field;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<ResearchPaper> getResearchPapers() {
		return researchPapers;
	}
	public void setResearchPapers(ArrayList<ResearchPaper> researchPapers) {
		this.researchPapers = researchPapers;
	}
	public ArrayList<ResearchProject> getReserachProjects() {
		return researchProjects;
	}
	public void setReserachProjects(ArrayList<ResearchProject> reserachProjects) {
		this.researchProjects = reserachProjects;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return  "Name: " + user.getFirstName() + " userId: " + user.getUserId() +"  field: " + field ;
	}

	public boolean addProject(ResearchProject project) {
		if (project != null && !researchProjects.contains(project)) {
			return researchProjects.add(project);
		}
		return false;
	}

	/* Calculates h-index from the published papers.*/

	public int calculateHIndex() {
		ArrayList<Integer> citations = new ArrayList<>();
		if(!this.getResearchPapers().isEmpty()) {
			for(ResearchPaper paper: this.getResearchPapers()) {
				citations.add(paper.getNumberOfCitations());
			}
			Collections.sort(citations, Collections.reverseOrder());

			int hIndex = 0;
			for (int i = 0; i < citations.size(); i++) {
				if (citations.get(i) >= i + 1) {
					hIndex = i + 1; 
				} else {
					break; 
				}
			}

			return hIndex;
		}
		else {
			return -1;
		}

	}

	/* Publishes research paper in research journal.*/
	public void publishPaper(ResearchJournal researchJournal, ResearchPaper paper) {
		if (researchJournal != null && paper != null) {
			researchJournal.getListOfResearchPapers().add(paper);
			getResearchPapers().add(paper);
			Data.getInstance().researchPapers.add(paper);
			System.out.println("The " + paper.getName() + " is succesfully published in " + paper.getResearchJournal().getName());
		}
		else {
			System.out.println("Either the research journal or the paper is null.");
		}
	}
	/*Creates research paper*/
	public ResearchPaper createResearchPaper(String name, ResearchJournal researchJournal, int pages, Date publicationDate, boolean isFreeAccess, int numberOfCitations) {
		ResearchPaper paper = new ResearchPaper(name, researchJournal, pages, publicationDate, isFreeAccess, numberOfCitations);
		return paper;
	}

	@Override
	public int hashCode() {
		return Objects.hash(user.getUserId());
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
		Researcher other = (Researcher) obj;
		return Objects.equals(user.getUserId(), other.user.getUserId());
	}



}
