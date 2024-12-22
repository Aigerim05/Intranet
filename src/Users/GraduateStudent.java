package Users;

import Enums.Department;
import Enums.Language;

public class GraduateStudent extends Student{

	private static final long serialVersionUID = 1L;


	private Researcher supervisor;

	private ResearchProject researchProject;

	public GraduateStudent() {
		super();
	}

	public GraduateStudent(String firstName, String lastName, String userId, String password, Language language,
			int yearOfStudy, int maxCredit, Department department, Researcher supervisor, 
			ResearchProject researchProject) {
		super(firstName, lastName, userId, password, language, yearOfStudy, maxCredit, department);
		this.supervisor = supervisor;

		this.researchProject = researchProject;
		if (researchProject != null && getResearcher() != null) {
			researchProject.getParticipants().add(getResearcher());
		}
	}

	public Researcher getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Researcher supervisor) {
		this.supervisor = supervisor;
	}

	// public Researcher getResearcher() {
	// 	return researcher;
	// }

	// public void setResearcher(Researcher researcher) {
	// 	this.researcher = researcher;
	// }

	public ResearchProject getResearchProject() {
		return researchProject;
	}

	public void setResearchProject(ResearchProject researchProject) {
		this.researchProject = researchProject;
	}





}
