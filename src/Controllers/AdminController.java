package Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Users.Admin;
import Users.Data;
import Users.DataOperation;
import Users.UserFactory;

public class AdminController {
	private Admin admin;

	public AdminController(Admin admin) {
		this.admin = admin;
	}

	Scanner in = new Scanner(System.in);

	private void save() throws IOException {
		Data.write();
	}
	private void exit() {
		System.out.println("Bye bye");
		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printList(ArrayList list) {
		for(int i=0; i<list.size(); i++) {
			System.out.println(i+1+ ")" +list.get(i));
		}
	}

	public boolean viewUsers() {
		if(Data.getInstance().users.isEmpty()) {
			System.out.println("No users yet...Try adding one");
			return false;
		}
		printList(Data.getInstance().users);
		return true;
	}



	public void createUser() throws NumberFormatException {
		UserFactory uf = new UserFactory();
		System.out.println("Who do you want to add?\n");
		System.out.println("1) Student \n 2) Teacher \n 3) Manager");
		int option = Integer.parseInt(DataOperation.readFromConsole());
		switch(option) {
		case 1: {admin.addUser(uf.createUser("Student"));break;}
		case 2: {admin.addUser(uf.createUser("Teacher"));break;}
		case 3: {admin.addUser(uf.createUser("Manager"));break;}
		}
	} 

	public void run() throws IOException {
		try {
			System.out.println("Welcome!");
			menu : while(true){
				System.out.println("What do you want to do?\n 1) View users \n 2) Create new user \n 3) Exit");
				int choice = in.nextInt();
				if(choice==1){
					viewUser: while(true){
						viewUsers();
						System.out.println("\n 1) Return back \n");
						choice = in.nextInt();
						if(choice==1) {
							continue menu;
						}
					}
				}
				else if(choice == 2) {

					createUser: while(true) {
						createUser();
						System.out.println("\n 1) Create another user  \n 2) Return back ");
						choice = in.nextInt();
						if(choice==1) {
							continue createUser;
						}
						if(choice==2) {
							continue menu;
						}
					}

				}
				else if (choice == 3){exit(); break menu;}
				break;

			}
		} catch (Exception e) {
			System.out.println("Something bad happened... \n Saving resources...");
			e.printStackTrace();
			save();
		}
	}

}
