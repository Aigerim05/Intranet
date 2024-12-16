package Controllers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Users.Course;
import Users.Data;
import Users.DataOperation;
import Users.Student;
import Users.Teacher;

public class TeacherController {
    private Teacher teacher;
    public TeacherController(Teacher teacher) {
    	this.teacher = teacher;
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
	public boolean viewCourses() {
		if(Data.getInstance().courses.isEmpty()) {
			System.out.println("No courses yet...");
			return false;
		}
		printList(Data.getInstance().courses);
		return true;
	}
	
	public void putMark() {
	    Data data = Data.getInstance();
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter the student ID:");
	    String studentId = DataOperation.readFromConsole();
	    Student student = null;
	    for (Student s : data.students) {
	        if (s.getUserId().equals(studentId)) {
	            student = s;
	            break;
	        }
	    }
	    if (student == null) {
	        System.out.println("Student not found!");
	        return;
	    }
	    System.out.println("Enter the course code:");
	    String courseCode = DataOperation.readFromConsole();
	    Course course = null;
	    for (Course c : data.courses) {
	        if (c.getCode().equals(courseCode)) {
	            course = c;
	            break;
	        }
	    }
	    if (course == null) {
	        System.out.println("Course not found!");
	        return;
	    }
	    System.out.println("Enter 1 for first attestation, 2 for second attestation, 3 for final:");
	    int attType = Integer.parseInt(DataOperation.readFromConsole());
	    System.out.println("Enter the score:");
	    double score = Double.parseDouble(DataOperation.readFromConsole());

	    teacher.putMark(student, course, attType, score);
	}

	public void run() throws IOException {
		try {
			System.out.println("Welcome!");
			menu : while(true){
				System.out.println("What do you want to do?\n 1) View courses \n 2) Put Mark \n 3) Exit");
				int choice = in.nextInt();
				if(choice==1){
					viewCourse: while(true){
						viewCourses();
						System.out.println("\n 1) Return back \n");
						choice = in.nextInt();
						if(choice==1) {
							continue menu;
						}
					}
				}
				 else if (choice == 2) {
	                    while (true) {
	                        putMark();
	                        System.out.println("\n 1) Continue \n 2) Return back \n 3) Exit");
	                        int subChoice = in.nextInt();
	                        if (subChoice == 1) {
	                            continue;
	                        } else if (subChoice == 2) {
	                            break;
	                        } else if (subChoice == 3) {
	                            exit();
	                            break;
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


