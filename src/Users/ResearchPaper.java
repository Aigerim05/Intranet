package Users;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import Enums.Format;


public class ResearchPaper implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<Researcher> authors;
	private ResearchJournal researchJournal;
	private int pages;
	private Date publicationDate;
	private boolean isFreeAccess;
	private int numberOfCitations;


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

	public ArrayList<Researcher> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<Researcher> authors) {
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


	public String getCitation(Format f) {
		if (f == Format.PLAIN_TEXT) {
			return getPlainTextCitation();
		} else if (f == Format.BIBTEX) {
			return getBibtexCitation();
		} else {
			return ""; 
		}
	}

	private String getPlainTextCitation() {

		StringBuilder citation = new StringBuilder();

		citation.append("Authors: ");
		for (int i = 0; i < authors.size(); i++) {
			citation.append(authors.get(i).toString());
			if (i < authors.size() - 1) {
				citation.append(", ");
			}
		}

		citation.append("\nTitle: ").append(name);

		citation.append("\nJournal: ").append(researchJournal.getName());

		citation.append("\nPages: ").append(pages);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		citation.append("\nPublication Date: ").append(dateFormat.format(publicationDate));

		citation.append("\nFree Access: ").append(isFreeAccess ? "Yes" : "No");

		citation.append("\nNumber of Citations: ").append(numberOfCitations);

		return citation.toString();
	}

	private String getBibtexCitation() {
		StringBuilder citation = new StringBuilder();

		citation.append("@article{").append(name.replaceAll(" ", "_")).append(",\n");

		citation.append("  author = {");
		for (int i = 0; i < authors.size(); i++) {
			citation.append(authors.get(i).toString());
			if (i < authors.size() - 1) {
				citation.append(", ");
			}
		}
		citation.append("},\n");

		citation.append("  title = {").append(name).append("},\n");


		citation.append("  journal = {").append(researchJournal.getName()).append("},\n");

		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		citation.append("  year = {").append(yearFormat.format(publicationDate)).append("},\n");

		citation.append("  pages = {").append(pages).append("},\n");

		citation.append("  numberOfCitations = {").append(numberOfCitations).append("}\n");

		citation.append("}");

		return citation.toString();
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
		return Objects.equals(name, other.name);
	}



}