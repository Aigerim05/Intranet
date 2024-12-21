package Users;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Attributes.News;

public class Data implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Data INSTANCE;

	public ArrayList<User> users = new ArrayList<>();
	public ArrayList<Course> courses = new ArrayList<>();
	public ArrayList<News> news = new ArrayList<>();
	public ArrayList<Teacher> teachers = new ArrayList<>();
	public ArrayList<Student> students = new ArrayList<>();
	public ArrayList<Manager> managers = new ArrayList<>();
	public ArrayList<Admin> admins = new ArrayList<>();
	public ArrayList<Researcher> researchers = new ArrayList<>();
	public ArrayList<ResearchJournal> researchJournals = new ArrayList<>();
	public ArrayList<ResearchProject> researchProjects = new ArrayList<>();
	public ArrayList<ResearchPaper> researchPapers = new ArrayList<>();

	static{
		if(new File("data.ser").exists()){
			try {
				INSTANCE = read();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			INSTANCE = new Data();
		}
	}
	private Data() {}


	public static synchronized Data getInstance() {
		return INSTANCE;
	}

	public static Data read() throws IOException, ClassNotFoundException {
		try (FileInputStream fis = new FileInputStream("data.ser");
				ObjectInputStream oin = new ObjectInputStream(fis)) {
			return (Data) oin.readObject();
		}
	}

	public static synchronized void write() throws IOException {
		if (INSTANCE != null) {
			try (FileOutputStream fos = new FileOutputStream("data.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(INSTANCE);
			}
		}
	}
}