package Users;

<<<<<<< HEAD
=======
import java.util.ArrayList;

import Attributes.Message;
import Enums.Language;

public class Employee extends User{

	private ArrayList<Message> messages;

	{
		messages = new ArrayList<>();
	}

	public Employee() {
		super();
	}


	public Employee(String firstName, String lastName, String userId, String password, Language language, ResearchDecorator researcher) {
		super(firstName, lastName, userId, password, language);
	}

}