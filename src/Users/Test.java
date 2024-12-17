package Users;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// тут добавить логику чтобы проверять если такой админ есть в системе, то не создавать нового
		//		Admin admin = new Admin("Tech", 
		//				"Guy", "somUserId", "111", Language.KZ);
		//		Data.getInstance().users.add(admin);

		//		Teacher teacher = Data.getInstance().teachers.get(0);
		//		Course course = new Course("CsCI332", 3, "OOP", "", CourseType.MAJOR, 30);
		//		course.getParticipants().add(new Student("Name", "Last", "user@student", "222", Language.KZ, 2, 21, Department.SITE));
		//		teacher.getCourses().add(course);


		DataOperation dataOperation = new DataOperation();
		dataOperation.login();


	}

}
