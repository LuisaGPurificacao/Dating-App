package br.com.core.java.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.core.java.model.UserAccount;

public class UserAccountDAO implements UserAccountDAOInterface {

	Map<Integer, UserAccount> users = new HashMap<>();

	@Override
	public void save(UserAccount user) {
		users.put(user.getId(), user);
	}

	@Override
	public UserAccount findById(int id) {
		return users.get(id);
	}

	@Override
	public List<UserAccount> findAll() {
		return new ArrayList<UserAccount>(users.values());
	}

	@Override
	public List<UserAccount> findMatches(int age, String city) {
		Collection<UserAccount> accounts = users.values();
		ArrayList<UserAccount> matches = new ArrayList<UserAccount>();
		for (UserAccount user : accounts) {
			if (user.getAge() == age && user.getCity().equals(city)) {
				matches.add(user);
			}
		}
		return matches;
	}

	@Override
	public void delete(int id) {
		users.remove(id);
	}

}