import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;




public class Data implements Serializable {
	ArrayList<User> users = new ArrayList<User>();
	ArrayList<Course> courses = new ArrayList<Course>();
	ArrayList<Student> students = new ArrayList<Student>();
	ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	ArrayList<Manager> managers = new ArrayList<Manager>();
	ArrayList<News> news = new ArrayList<News>();



	public static Data INSTANCE;
	//	static {
	//		if(new File("data").exists()) {
	//			try {
	//				INSTANCE = read();
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		} else {
	//			INSTANCE = new Data();
	//		}
	//	}
	//	private Data() {
	//
	//	}
	//	public static Data read() throws IOException, ClassNotFoundException{
	//		FileInputStream fis = new FileInputStream("data");
	//		ObjectInputStream oin = new ObjectInputStream(fis);
	//		return (Data) oin.readObject();
	//	}
	//	public static void write()throws IOException{
	//		FileOutputStream fos = new FileOutputStream("data");
	//		ObjectOutputStream oos = new ObjectOutputStream(fos);
	//		oos.writeObject(INSTANCE);
	//		oos.close();
	//	}
	//	public static int nextId() {
	//		// TODO Auto-generated method stub
	//		return  INSTANCE.students.size()+1;
}


}
