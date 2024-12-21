package Controllers;
import java.io.IOException;
import java.util.Scanner;

import Users.Course;
import Users.Data;
import Users.DataOperation;
import Users.ResearchUtils;
import Users.Researcher;
import Users.Student;
import Users.Teacher;
import Users.UserOperation;

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

	public void viewCourses() {
		UserOperation.printList(teacher.getCourses());
	}

	public void viewStudents(Course c) {
		UserOperation.printList(c.getParticipants());
	}


	public void putAssessment(Student student, Course course) {
		System.out.println("Enter 1 for first attestation \nEnter 2 for second attestation \nEnter 3 for final scores");
		int attType = Integer.parseInt(DataOperation.readFromConsole());
		System.out.println("Enter Score:");
		double score = Double.parseDouble(DataOperation.readFromConsole());
		teacher.putMark(student, course, attType, score);
		System.out.println("Succesfully put mark");

	}


	public void run() throws IOException {
		try {
			System.out.println("Welcome, " + teacher.getFirstName() + "!");
			menu : while(true){
				System.out.println("What do you want to do?\n 1) View courses \n 2) Put Mark \n 3) View my rating \n 4) Switch to researcher mode \n 5) Exit");
				int choiceMenu  = in.nextInt();
				if(choiceMenu == 1){
					viewCourse: while(true){
						viewCourses();
						System.out.println("1) Return back \n");
						int choiceViewCourses = in.nextInt();
						if(choiceViewCourses  == 1) {
							continue menu;
						}

					}
				}
				else if (choiceMenu == 2) {
					chooseCourse: while (true) {
						System.out.println("1) Choose course \n2) Return back");
						int choiceChooseCourse = in.nextInt();
						if(choiceChooseCourse == 1) {
							getCourse: while(true) {
								if(teacher.getCourses().isEmpty()) {
									System.out.println("No courses yet... Ask OR manager to assign courses.");
									continue chooseCourse;
								}
								else {

									viewCourses();
									int choiceCourse = in.nextInt();
									Course chosenCourse = teacher.getCourses().get(choiceCourse - 1);

									getStudent: while(true) {
										System.out.println(" 1) ChooseStudent \n 2) Return back ");

										int choiceGetStudent = in.nextInt();
										if(choiceGetStudent == 1) {

											chooseStudent:while(true) {
												viewStudents(chosenCourse);
												System.out.println("Student number: ");
												int studentNumber = in.nextInt();

												Student chosenStudent = chosenCourse.getParticipants().get(studentNumber - 1);
												putAssessment(chosenStudent, chosenCourse);

												System.out.println(" 1) Choose another student \n 2) Return back ");
												int choiceAnotherStudent = in.nextInt();
												if(choiceAnotherStudent == 1) {
													continue chooseStudent;
												}
												else if(choiceAnotherStudent == 2) {
													continue chooseCourse;
												}

											}

										}

										else if(choiceGetStudent == 2) {
											continue chooseCourse;
										}
									}

								}
							}
						}
						else if(choiceChooseCourse == 2) {
							continue menu;
						}
					}

				}
				else if (choiceMenu == 3) {
					displayRating: while(true) {
						displayTeacherRating();
						System.out.println("\n 1) Return back");
						int subChoice = in.nextInt();
						if (subChoice == 1) {
							continue menu;
						} 
					}
				}

				else if (choiceMenu == 4) {
					launchResearcherMode: while(true) {
						Researcher researcher = teacher.getResearcher();
						ResearchUtils.launchResearcherMode(researcher);
						continue menu;
					}

				}
				else if (choiceMenu == 5) {exit(); break menu;}
				break;
			}
		} catch (Exception e) {
			System.out.println("Something bad happened... \n Saving resources...");
			e.printStackTrace();
			save();
		}
	}




	public void displayTeacherRating() {
		if (teacher.getRatings().isEmpty()) {
			System.out.println("No ratings yet for " + teacher.getFirstName() + " " + teacher.getLastName());
			return;
		}
		else {
			System.out.println("Ratings for " + teacher.getFirstName() + " " + teacher.getLastName() + ":");
		}
		double averageRating = teacher.getAverageRating();
		System.out.println("Average Rating: " + averageRating);
	}
}
