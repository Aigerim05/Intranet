package Users;

import Enums.Department;
import Enums.Language;
import Enums.Position;

public class UserOperation {
	public UserOperation() {};

	public static Department enterDepartment(int choice) {
		if(choice == 1) {
			return Department.SITE;
		}
		// нужно дописать сюда все департаменты
		return null; // null нужно убрать чтобы не было nullPointerException
	}

	public static Language enterLanguage(int choice) {
		if(choice == 1) {
			return Language.KZ;
		}
		// нужно дописать сюда все languages
		return null; // null нужно убрать чтобы не было nullPointerException
	}


	public static Position enterPosition(int choice) {
		if(choice == 1) {
			return Position.PROFESSOR;
		}
		// нужно дописать сюда все languages
		return null; // null нужно убрать чтобы не было nullPointerException
	}
}
