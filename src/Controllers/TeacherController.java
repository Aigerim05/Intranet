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
	public void viewCourses() {
		if(Data.getInstance().courses.isEmpty()) {
			System.out.println("No courses yet...");
		}
		printList(Data.getInstance().courses);
	}
	
//	public void putMark() {
//		while(true) {
//			System.out.println("Choose the number of course: ");
//			int n = 1;
//			for(Course c: teacher.getCourses()) {
//				System.out.println(n++ + " " + c.getCourseName());
//			int option = Integer.parseInt(DataOperation.readFromConsole());
//			Course course = teacher.getCourses().get(option-1);
//			System.out.println("Enter student Id: ");
//			String userId = DataOperation.readFromConsole();
//			Student studentMark = null;
//			for(Student s: course.getParticipants()) {
//				if(s.getUserId() == userId) {
//					studentMark = s;
//					break;
//				}
//			System.out.println("Enter 1 for first attestation \n Enter 2 for second attestaion \n Enter 3 for final scores");
//			int attType = Integer.parseInt(DataOperation.readFromConsole());
//			System.out.println("Enter Score:");
//			double score = Double.parseDouble(DataOperation.readFromConsole());
//			teacher.putMark(studentMark, course, attType, score);
//			}
//		}
//	}
//	}
	
	public void showCourses() {
		int n = 1;
	    for(Course c : teacher.getCourses()) {
	        System.out.println(n++ + ". " + c.getCourseName());
	    }
	}
	public void showStudents(Course c) {
		int n = 1;
	    for(Student s : c.getParticipants()) {
	        System.out.println(n++ + ". " + s.getUserId());
	       
		}
	}
	public void putAssessment(Student student, Course course) {
        System.out.println("Enter 1 for first attestation \nEnter 2 for second attestation \nEnter 3 for final scores");
        int attType = Integer.parseInt(DataOperation.readFromConsole());
        System.out.println("Enter Score:");
        double score = Double.parseDouble(DataOperation.readFromConsole());
        teacher.putMark(student, course, attType, score);
    }

	
	public void putMark() {
		while(true) {
			System.out.println("Choose student to which you want to put marks: (Enter number)");
			showCourses(); 
			int selectedCourseIndex = in.nextInt() - 1; 
			Course selectedCourse = teacher.getCourses().get(selectedCourseIndex);
			showStudents(selectedCourse); 
			int selectedStudentIndex = in.nextInt() - 1; 
			Student student = selectedCourse.getParticipants().get(selectedStudentIndex);
			 putAssessment(student, selectedCourse);
			
		}
	}
	public void displayTeacherRating() {
        double averageRating = teacher.getAverageRating();
        System.out.println("Average Rating: " + averageRating);
	}
	
	public void run() throws IOException {
		try {
			System.out.println("Welcome!");
			menu : while(true){
				System.out.println("What do you want to do?\n 1) View courses \n 2) Put Mark \n 3) Ratings \n 3) Exit");
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
				 else if (choice == 3) {
					 displayTeacherRating();
		                System.out.println("\n 1) Return back \n 2) Exit");
		                int subChoice = in.nextInt();
		                if (subChoice == 1) {
		                    continue menu;
		                } else if (subChoice == 2) {
		                    exit();
		                    break;
		                }
				else if (choice == 4){exit(); break menu;}
				break;

			}
		}} catch (Exception e) {
			System.out.println("Something bad happened... \n Saving resources...");
			e.printStackTrace();
			save();
		}
	}
}


