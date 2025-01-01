package Users;

import Enums.Language;

public class Employee extends User{



	double salary;


	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String userId, String password, Language language, double salary) {
		super(firstName, lastName, userId, password, language);
		this.salary = salary;
	}


	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}




	@Override
	public String toString() {
		return "Employee{" +
				"userId=" + super.getUserId() +"," +
				"password=" +super.getPassword() + "," +
				"firstName=" +super.getFirstName() + ',' +
				"lastName=" + super.getLastName() + ',' +
				"salary=" + salary;
	}

}
