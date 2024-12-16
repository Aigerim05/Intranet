package Users;

import Enums.Department;
import Enums.Language;

public class Master extends GraduateStudent{

	public Master() {
		super();

	}

	public Master(String firstName, String lastName, String userId, String password, Language language, int yearOfStudy,
			int maxCredit, Department department, ResearchDecorator supervisor, 
			ResearchProject researchProject) {
		super(firstName, lastName, userId, password, language, yearOfStudy, maxCredit, department, supervisor, 
				researchProject);

	}


}
