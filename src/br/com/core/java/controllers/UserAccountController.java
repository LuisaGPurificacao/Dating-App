package br.com.core.java.controllers;

import br.com.core.java.dao.UserAccountDAO;
import br.com.core.java.dao.UserAccountDAOInterface;
import br.com.core.java.model.Interest;
import br.com.core.java.model.UserAccount;

public class UserAccountController {

	public static void main(String[] args) {

		UserAccountController controller = new UserAccountController();
		controller.findAllUsers();
		System.out.println("\nMatch for age 17 and city São Paulo: ");
		controller.findMatchingUsers();

	}


	public void findAllUsers() {
		UserAccountDAOInterface dao = new UserAccountDAO();
		createUsers(dao);
		
		// dao.delete(1);

		System.out.println(dao.findAll());

	}
	
	public void findMatchingUsers() {
		UserAccountDAOInterface dao = new UserAccountDAO();
		createUsers(dao);
		
		System.out.println(dao.findMatches(17, "São Paulo"));
	}

	private void createUsers(UserAccountDAOInterface dao) {
		Interest interest = new Interest(1, "watching movies", "sertanejo", "playing games", "www.luisa.com.br",
				"I love dogs");
		UserAccount user = new UserAccount(1, "Luisa", "senha123", 17, "luisa@gmail.com", "11 950311021", "F",
				"São Paulo", "Brasil", interest);

		dao.save(user);
		
		Interest interest2 = new Interest(2, "cooking", "people that are not nice", "drawing", "www.maria.com",
				"I am in college");
		UserAccount user2 = new UserAccount(2, "Maria", "password123", 23, "maria@gmail.com", "11 912345698", "F",
				"Austin", "USA", interest2);

		dao.save(user2);
	}

}
