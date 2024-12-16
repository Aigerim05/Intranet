package Users;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import Enums.Format;
public class ResearchPaper {
	private String name;
	private ArrayList<ResearchDecorator> authors;
	private ResearchJournal researchJournal;
	private int pages;
	private Date publicationDate;
	private boolean isFreeAccess;
	private int numberOfCitations;
	protected Format format;
	
	{
		authors = new ArrayList<>();
	}
	
	public  ResearchPaper() {
	}
	
	public ResearchPaper(String name, ResearchJournal researchJournal,int pages, Date publicationDate, boolean isFreeAccess, int numberOfCitations) {
		this.name = name;
		this.pages = pages;
		this.publicationDate = publicationDate;
		this.researchJournal = researchJournal;
		this.isFreeAccess = isFreeAccess;
		this.numberOfCitations = numberOfCitations;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<ResearchDecorator> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<ResearchDecorator> authors) {
		this.authors = authors;
	}

	public ResearchJournal getResearchJournal() {
		return researchJournal;
	}

	public void setResearchJournal(ResearchJournal researchJournal) {
		this.researchJournal = researchJournal;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public boolean isFreeAccess() {
		return isFreeAccess;
	}

	public void setFreeAccess(boolean isFreeAccess) {
		this.isFreeAccess = isFreeAccess;
	}

	public int getNumberOfCitations() {
		return numberOfCitations;
	}

	public void setNumberOfCitations(int numberOfCitations) {
		this.numberOfCitations = numberOfCitations;
	}

	@Override
	public String toString() {
		return "name=" + name + ", authors=" + authors + ", researchJournal=" + researchJournal + " ,pages=" + pages
				+ ", publicationDate=" + publicationDate + ", isFreeAccess=" + isFreeAccess + ", numberOfCitations="
				+ numberOfCitations;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authors, isFreeAccess, name, numberOfCitations,pages, publicationDate, researchJournal);
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
		ResearchPaper other = (ResearchPaper) obj;
		return Objects.equals(authors, other.authors) && isFreeAccess == other.isFreeAccess
				&& Objects.equals(name, other.name) && numberOfCitations == other.numberOfCitations
				&& Objects.equals(pages, other.pages)
				&& Objects.equals(publicationDate, other.publicationDate)
				&& Objects.equals(researchJournal, other.researchJournal);
	}
	
	 public void getCitations(Format format) {
	        if (format == Format.PlainText) {
	          System.out.println(authors);
	        } else if (format == Format.Bibtex) {
	            System.out.println("Research Paper {\n authors={" + authors + " }");
	        }
	    }
}
