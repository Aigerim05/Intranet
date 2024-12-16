package Users;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import Controllers.AdminController;

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
				if(user instanceof Admin admin) {
					AdminController adminController = new AdminController(admin);
					adminController.run();
					
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



