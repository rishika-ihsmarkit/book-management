package com.osttra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.osttra.to.User;
import com.osttra.utils.DBUtils;

public class UserDao {

	public void addUser(User user) {
		
		try {

			Connection conn = DBUtils.getConnection();

			PreparedStatement statement = conn.prepareStatement("insert into user values(?, ?, ?, ?, ?, ?)");

			statement.setString(1, user.getUsername());
			statement.setString(2, user.getEmailID());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getRole());

			statement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("inside catch of add() of UserDAO...");
			
		}
		
	}

	public User getUser(String username, String password) {
		
		User user = null;

		try {

			Connection conn = DBUtils.getConnection();

			PreparedStatement statement = conn.prepareStatement("select * from user where username = ? and password = ?");

			statement.setString(1, username);
			statement.setString(2, password);

			ResultSet resultSet = statement.executeQuery();
			
			if( resultSet.next()) {
				
				String uname = resultSet.getString(1);
				String email = resultSet.getString(2);
				String fname = resultSet.getString(3);
				String lname = resultSet.getString(4);
				String pwd = resultSet.getString(5);
				String role = resultSet.getString(6);
				
				user = new User(uname, email, fname, lname, pwd, role);
			}
			
		} catch (Exception e) {
			System.out.println("inside catch of add() of UserDAO...");
		}
		return user;
	}

}
