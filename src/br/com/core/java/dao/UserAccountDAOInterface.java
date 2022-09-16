package br.com.core.java.dao;

import java.util.List;

import br.com.core.java.model.UserAccount;

public interface UserAccountDAOInterface {
	
	void save(UserAccount userAccount);
	
	UserAccount findById(int id);
	
	List<UserAccount> findAll();
	
	List<UserAccount> findMatches(int age, String city);
	
	void delete(int id);

}
