package br.com.core.java.controllers;

import java.util.Scanner;

import br.com.core.java.dao.UserAccountDAO;
import br.com.core.java.dao.UserAccountDAOInterface;
import br.com.core.java.model.Interest;
import br.com.core.java.model.UserAccount;

public class UserAccountController {

	public static void main(String[] args) {

		UserAccountDAO dao = new UserAccountDAO();
		Scanner scan = new Scanner(System.in);
		boolean continuar = true;
		// MENU
		do {
			System.out.println("Hello! Welcome to this dating app\nHow can we help you?");
			System.out.println(
					"1- Add a new user account\n" + "2- Find an user account by the ID\n" + "3- See all user accounts\n"
							+ "4- Find matches ♥.♥\n" + "5- Delete an user account :(" + "\n6- Get out");
			int opcao = scan.nextInt();

			switch (opcao) {
			// Add a new user
			case 1:
				System.out.println("What's your name?");
				String name = scan.next() + scan.nextLine();
				System.out.println("Enter your password:");
				String password = scan.next() + scan.nextLine();
				System.out.println("What's your age?");
				int age = scan.nextInt();
				System.out.println("What's your e-mail?");
				String email = scan.next() + scan.nextLine();
				System.out.println("What's your phone number?");
				String phone = scan.next() + scan.nextLine();
				System.out.println("What's your gender?");
				String gender = scan.next() + scan.nextLine();
				System.out.println("What's the city where you live?");
				String city = scan.next() + scan.nextLine();
				System.out.println("What's your country?");
				String country = scan.next() + scan.nextLine();

				UserAccount user = new UserAccount(name, password, age, email, phone, gender, city, country);
				dao.save(user);
				System.out.println("User account saved :)");
				break;

			// Find an user by the ID
			case 2:
				System.out.println("Enter the ID of the user account:");
				int id = scan.nextInt();

				System.out.println(dao.findById(id));
				break;

			// Find all user accounts
			case 3:
				System.out.println("All user accounts:\n");
				System.out.println(dao.findAll());
				break;

			// Find match
			case 4:
				System.out.println("What's your age?");
				int age2 = scan.nextInt();
				System.out.println("What's the city you live in?");
				String city2 = scan.next() + scan.nextLine();
				System.out.println("Here is you match: ♥");
				System.out.println(dao.findMatches(age2, city2));
				break;

			// Remove an user account
			case 5:
				System.out.println("Enter with the ID of the user account you want to remove:");
				int id2 = scan.nextInt();
				System.out.println("Are you sure you want to remove user " + id2 + "? (Y/N)");
				String opcao2 = scan.next() + scan.nextLine();
				if (opcao2.equals("Y")) {
					dao.delete(id2);
					System.out.println("User account removed.");
				} else {
					System.out.println("Account not removed.");
				}
				break;

			// Get out
			case 6:
				continuar = false;
				break;

			default:
				System.out.println("Invalid number");
			}
		} while (continuar);

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
		Interest interest = new Interest("watching movies", "sertanejo", "playing games", "www.luisa.com.br",
				"I love dogs");
		UserAccount user = new UserAccount("Luisa", "senha123", 17, "luisa@gmail.com", "11 950311021", "F", "São Paulo",
				"Brasil");

		dao.save(user);

		Interest interest2 = new Interest("cooking", "people that are not nice", "drawing", "www.maria.com",
				"I am in college");
		UserAccount user2 = new UserAccount("Maria", "password123", 23, "maria@gmail.com", "11 912345698", "F",
				"Austin", "USA");

		dao.save(user2);
	}

}
