package Controllers;

import java.io.IOException;
import java.util.Scanner;

import Attributes.Message;
import Attributes.MessageFactory;
import Users.Course;
import Users.Data;
import Users.DataOperation;
import Users.Employee;
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
		if (teacher.getCourses().isEmpty()) {
			System.out.println("No courses yet...");
		}
		UserOperation.printList(Data.getInstance().courses);
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
			menu:
				while (true) {
					System.out.println("What do you want to do?\n 1) View courses \n 2) Put Mark \n 3) View my rating \n 4) Switch to researcher mode \n 5) Send message \n 6) Exit");
					int choiceMenu = in.nextInt();
					if (choiceMenu == 1) {
						viewCourse:
							while (true) {
								viewCourses();
								System.out.println("1) Return back \n");
								int choiceViewCourses = in.nextInt();
								if (choiceViewCourses == 1) {
									continue menu;
								}

							}
					} else if (choiceMenu == 2) {
						chooseCourse:
							while (true) {
								System.out.println("\n 1) Choose course \n 2) Return back");
								int choiceChooseCourse = in.nextInt();
								if (choiceChooseCourse == 1) {
									getCourse:
										while (true) {
											viewCourses();
											int choiceCourse = in.nextInt();
											final Course chosenCourse = teacher.getCourses().get(choiceCourse - 1);
											Course realCourse = Data.getInstance().courses
													.stream()
													.filter(c -> c.equals(chosenCourse))
													.findFirst()
													.orElse(null);
											if (realCourse == null) {
												System.out.println("Course not found in Data.");
												break;
											}

											getStudent:
												while (true) {
													System.out.println(" 1) Choose Student \n 2) Return back ");

													int choiceGetStudent = in.nextInt();
													if (choiceGetStudent == 1) {

														chooseStudent:
															while (true) {
																viewStudents(chosenCourse);
																System.out.println(" Student number: ");
																int studentNumber = in.nextInt();

																Student chosenStudent = chosenCourse.getParticipants().get(studentNumber - 1);
																putAssessment(chosenStudent, realCourse);

																System.out.println(" 1) Choose another student \n 2) Return back ");
																int choiceAnotherStudent = in.nextInt();
																if (choiceAnotherStudent == 1) {
																	continue chooseStudent;
																} else if (choiceAnotherStudent == 2) {
																	continue chooseCourse;
																}

															}

													} else if (choiceGetStudent == 2) {
														continue chooseCourse;
													}

												}
										}
								} else if (choiceChooseCourse == 2) {
									continue menu;
								}
							}

					} else if (choiceMenu == 3) {
						displayRating:
							while (true) {
								displayTeacherRating();
								System.out.println("\n 1) Return back");
								int subChoice = in.nextInt();
								if (subChoice == 1) {
									continue menu;
								}
							}
					} else if (choiceMenu == 4) {
						launchResearcherMode:
							while (true) {
								Researcher researcher = teacher.getResearcher();
								ResearchUtils.launchResearcherMode(researcher);
								continue menu;
							}

					} else if (choiceMenu == 6) {
						exit();
						break menu;
					}
					break;
				}
		} catch (Exception e) {
			System.out.println("Something bad happened... \n Saving resources...");
			e.printStackTrace();
			save();
		}
	}

	public void sendMessage() {
		System.out.println("Which Type of Message you want to send?\n1) WorkMessage\n2) Request\n3) Complaint");

		Message newMessage = null;
		switch(in.nextInt()) {
		case 1:
			newMessage = MessageFactory.getMessage("WorkMessage");
		case 2:
			newMessage = MessageFactory.getMessage("Request");
		case 3:
			if(this instanceof Teacher) {
				newMessage = MessageFactory.getMessage("Complaint");
			} else {
				System.out.println("Only teacher can send complaints");
			}
		default:
			System.out.println("Invalid message type");
			// sendMessage() abort? можно сделать цикл пока не введет правильный тип или 0 - чтобы выйти
		}

		System.out.println("Select Employee you want to send message to");
		UserOperation.printList(Data.getInstance().employees); 
		Employee chosenEmployee = Data.getInstance().employees.get(inp.nextInt() - 1); // тоже нужно будет сделать проверку на инвалид чойс

		System.out.println("Write a content of the message");
		String content = inp.nextLine();
		newMessage.setSender(this);
		newMessage.setReceiver(chosenEmployee);
		newMessage.setContent(content);
		// здесь можно выписать весь мессадж перед отправлением и спросить вы готовы отправить? и можно также его отредактирова
		newMessage.send();
		System.out.println("Message has been sent!");
	}
	public void displayTeacherRating() {
		if (teacher.getRatings().isEmpty()) {
			System.out.println("No ratings yet for " + teacher.getFirstName() + " " + teacher.getLastName());
			return;
		} else {
			System.out.println("Ratings for " + teacher.getFirstName() + " " + teacher.getLastName() + ":");
		}
		double averageRating = teacher.getAverageRating();
		System.out.println("Average Rating: " + averageRating);
	}
}