package Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class ResearchDecorator  {
	private UserFactory user;
	private int hIndex;
	private ArrayList<ResearchPaper> researchPaper;
	private ArrayList<ResearchProject> reserachProjects;
	private Department department;
	private ResearchJournal researchJournal;
	{
		researchPaper = new ArrayList<>();
		reserachProjects = new ArrayList<>();
	}
	public ResearchDecorator() {
		
	}
	public ResearchDecorator(UserFactory user, int hIndex, Department department) {
		this.user = user;
		this.hIndex = hIndex;
		this.department  = department;
	}
	public UserFactory getUser() {
		return user;
	}
	public void setUser(UserFactory user) {
		this.user = user;
	}
	public int gethIndex() {
		return hIndex;
	}
	public void sethIndex(int hIndex) {
		this.hIndex = hIndex;
	}
	public ArrayList<ResearchPaper> getResearchPaper() {
		return researchPaper;
	}
	public void setResearchPaper(ArrayList<ResearchPaper> researchPaper) {
		this.researchPaper = researchPaper;
	}
	public ArrayList<ResearchProject> getReserachProjects() {
		return reserachProjects;
	}
	public void setReserachProjects(ArrayList<ResearchProject> reserachProjects) {
		this.reserachProjects = reserachProjects;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
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
		ResearchDecorator other = (ResearchDecorator) obj;
		return department == other.department && hIndex == other.hIndex
				&& Objects.equals(researchPaper, other.researchPaper)
				&& Objects.equals(reserachProjects, other.reserachProjects) && Objects.equals(user, other.user);
	}
	@Override
	public int hashCode() {
		return Objects.hash(department, hIndex, researchPaper, reserachProjects, user);
	}
	
	@Override
	public String toString() {
		return "User: " + user + " ,h-index: " + hIndex + " ,research Paper: "  + researchPaper + " ,reserach Projects: " + reserachProjects + " ,Department: " + department;
	}
	
	public void calculateHIndex() {
	    int hIndex = 0;
	    for (ResearchPaper paper : researchPaper) {
	        int citations = paper.getNumberOfCitations();
	        if (citations >= hIndex + 1) {
	            hIndex++; 
	        }
	    }
	    sethIndex(hIndex);
	    }

	public void addProject(ResearchProject project) {
		if (project != null && !reserachProjects.contains(project)) {
			reserachProjects.add(project);}}

	
	public boolean removeProject(ResearchProject project) {
	    return reserachProjects.remove(project);
	}

	public void addPaper(ResearchPaper paper) {
        if (paper != null && !researchPaper.contains(paper)) {
            researchPaper.add(paper);
        }
    }
	
	 public boolean removePaper(ResearchPaper paper) {
	        if (paper != null && researchPaper.contains(paper)) {
	            researchPaper.remove(paper);
	            return true;
	        }
	        return false;
	    }
	 
	  public void publishPaper(ResearchJournal researchJournal, String paperName, boolean isFreeAccess) {
	        if (researchJournal != null && paperName != null && !paperName.isEmpty()) {
	            ResearchPaper paper = new ResearchPaper(paperName, researchJournal, hIndex, new Date(), isFreeAccess, 0);
	            researchPaper.add(paper);
	            researchJournal.addPaper(paper);
	        }
	    }

	
	public void printResearchPapers() {
		researchPaper.sort((p1, p2) -> Integer.compare(p2.getNumberOfCitations(), p1.getNumberOfCitations()));
        for (ResearchPaper paper : researchPaper) {
            System.out.println(paper);
		
	}
	}
}
	

