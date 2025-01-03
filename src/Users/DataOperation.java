package Users;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import Controllers.AdminController;
import Controllers.ManagerController;
import Controllers.ResearcherController;
import Controllers.StudentController;
import Controllers.TeacherController;

public class DataOperation {

	private static BufferedReader in;

	public DataOperation() throws ClassNotFoundException, IOException {
		if (new File("data.ser").exists()) {Data data = Data.read();}
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	public static String readFromConsole()   {
		String read = "";
		try {
			read = in.readLine();
		}
		catch(IOException e) {
			System.out.println("Unsupported format");
		}
		return read; 	
	}


	public void login() {

		System.out.println("Enter userId: ");
		String userId = readFromConsole();
		System.out.println("Enter password: ");
		String password = readFromConsole();
		User user = null;

		for(User u: Data.getInstance().users) {
			if(u.getUserId().equals(userId) && u.getPassword().equals(password)) {
				System.out.println("Login was successful!");
				user = u;
				break;
			}
		}

		try {
			if( user != null) {
				if(user instanceof Admin) {
					Admin admin = (Admin) user;
					AdminController adminController = new AdminController(admin);
					adminController.run();
				}
				else if(user instanceof Teacher) {
					Teacher teacher = (Teacher) user;
					TeacherController teacherController = new TeacherController(teacher);
					teacherController.run();
				}
				else if(user instanceof EResearcher) {
					EResearcher eResearcher = (EResearcher) user;
					ResearcherController eResearcherController = new ResearcherController(eResearcher.getResearcher());
					eResearcherController.run();
				}

				else if(user instanceof Student) {
					Student student = (Student) user;
					StudentController studentController = new StudentController(student);
					studentController.run();
				}
				else if (user instanceof Manager manager) {
					ManagerController managerController = new ManagerController(manager);
					managerController.run();
				}

			}

			else {
				System.out.println("No such user in the system.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}



