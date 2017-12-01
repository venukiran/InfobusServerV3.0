package com.slt.infobus.repository;

import java.util.List;

import com.slt.infobus.entity.User;


public interface UserDao {

	User save(User user);

	User checkAdminCredentials(String userName, String securePassword);

	void updateAdmin(User admin);

	User getUserByEmail(String email);

	User getUserById(int userId);

	List<User> findAll();
	
	User getUserByMobile(String mobile);

	void delete(User usr);
}
