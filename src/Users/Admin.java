package Users;

import Enums.Language;

public class Admin extends User {

	public Admin() {
		super();
	}

	public Admin(String firstName, String lastName, String userId, String password, Language language) {
		super(firstName, lastName, userId, password, language);
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}


	public void addUser(User user) {
		Data.getInstance().users.add(user);
		if (user instanceof Student) {
			Data.getInstance().students.add((Student) user);
		} else if (user instanceof Teacher) {
			Data.getInstance().teachers.add((Teacher) user);
		} else if (user instanceof Manager) {
			Data.getInstance().managers.add((Manager) user);
		}

		else if (user instanceof Master) {
			Data.getInstance().researchers.add(((Master) user).getResearcher());
		}
		else if (user instanceof PhD) {
			Data.getInstance().researchers.add(((PhD) user).getResearcher());
		}

		else if (user instanceof EResearcher) {
			Data.getInstance().researchers.add(((EResearcher) user).getResearcher());
		}
	}


}
