package Users;

import Enums.Department;
import Enums.Language;

public class GraduateStudent extends Student{
	private ResearchDecorator supervisor;
	private ResearchDecorator researcher;

	private ResearchProject researchProject;

	public GraduateStudent() {
		super();
	}

	public GraduateStudent(String firstName, String lastName, String userId, String password, Language language,
			int yearOfStudy, int maxCredit, Department department, ResearchDecorator supervisor, 
			ResearchProject researchProject) {
		super(firstName, lastName, userId, password, language, yearOfStudy, maxCredit, department);
		this.supervisor = supervisor;
		this.researcher = ResearchUtils.createResearcher(this);
		this.researchProject = researchProject;
		researchProject.getParticipants().add(researcher);
	}

	public ResearchDecorator getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(ResearchDecorator supervisor) {
		this.supervisor = supervisor;
	}

	public ResearchDecorator getResearcher() {
		return researcher;
	}

	public void setResearcher(ResearchDecorator researcher) {
		this.researcher = researcher;
	}

	public ResearchProject getResearchProject() {
		return researchProject;
	}

	public void setResearchProject(ResearchProject researchProject) {
		this.researchProject = researchProject;
	}





}
