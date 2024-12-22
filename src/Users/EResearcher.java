package Users;

import Enums.Language;
import Interfaces.Employeeable;

public class EResearcher extends Employee implements Employeeable{


	@Override
	public String toString() {
		return "EResearcher [researcher=" + researcher + "]";
	}


	private Researcher researcher;

	public EResearcher() {
		super();
	}


	public EResearcher(String firstName, String lastName, String userId, String password, Language language, double salary) {
		super(firstName, lastName, userId, password, language, salary);

		this.researcher = ResearchUtils.createResearcher(this);
	}

	public Researcher getResearcher() {
		return researcher;
	}


	public void setResearcher(Researcher researcher) {
		this.researcher = researcher;
	}

}
