package Users;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// тут добавить логику чтобы проверять если такой админ есть в системе, то не создавать нового
		//		Admin admin = new Admin("Tech", 
		//				"Guy", "somUserId", "111", Language.KZ);
		//		Data.getInstance().users.add(admin);
		DataOperation dataOperation = new DataOperation();
		dataOperation.login();


	}

}
