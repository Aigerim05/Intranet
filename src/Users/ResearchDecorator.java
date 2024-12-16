package Users;

import java.util.ArrayList;

public class ResearchDecorator {


	private User user;
	private int hIndex;
	private ArrayList<ResearchPaper> researchPapers;
	private ArrayList<ResearchProject> reserachProjects;
	private String field;

	{
		researchPapers = new ArrayList<>();
		reserachProjects = new ArrayList<>();
	}
	public ResearchDecorator() {

	}
	public ResearchDecorator(User user, int hIndex, String field) {
		this.user = user;
		this.hIndex = hIndex;
		this.field  = field;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int gethIndex() {
		return hIndex;
	}
	public void sethIndex(int hIndex) {
		this.hIndex = hIndex;
	}
	public ArrayList<ResearchPaper> getResearchPaper() {
		return researchPapers;
	}
	public void setResearchPaper(ArrayList<ResearchPaper> researchPaper) {
		this.researchPapers = researchPaper;
	}
	public ArrayList<ResearchProject> getReserachProjects() {
		return reserachProjects;
	}
	public void setReserachProjects(ArrayList<ResearchProject> reserachProjects) {
		this.reserachProjects = reserachProjects;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return user.toString() +" [hIndex=" + hIndex + ", field=" + field + "]";
	}

	public void calculateHIndex() {
		int hIndex = 0;
		for (ResearchPaper paper : researchPapers) {
			int citations = paper.getNumberOfCitations();
			if (citations >= hIndex + 1) {
				hIndex++; 
			}
		}
		sethIndex(hIndex);
	}

	public boolean addProject(ResearchProject project) {
		if (project != null && !reserachProjects.contains(project)) {
			return reserachProjects.add(project);
		}
		return false;
	}

	public boolean removeProject(ResearchProject project) {
		if(reserachProjects.contains(project)) {
			return reserachProjects.remove(project);
		}
		return false;
	}

	public boolean addPaper(ResearchPaper paper) {
		if (paper != null && !researchPapers.contains(paper)) {
			return researchPapers.add(paper);
		}
		return false;
	}

	public boolean removePaper(ResearchPaper paper) {
		if (paper != null && researchPapers.contains(paper)) {
			researchPapers.remove(paper);
			return true;
		}
		return false;
	}

	public boolean publishPaper(ResearchJournal researchJournal, ResearchPaper paper) {
		if (researchJournal != null && paper != null) {
			researchJournal.getListOfResearchPapers().add(paper);
		}
		return false;
	}


	public void printResearchPapers() {
		researchPapers.sort((p1, p2) -> Integer.compare(p2.getNumberOfCitations(), p1.getNumberOfCitations()));
		for (ResearchPaper paper : researchPapers) {
			System.out.println(paper);

		}
	}

}
