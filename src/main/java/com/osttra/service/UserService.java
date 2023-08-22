package com.osttra.service;

import java.util.Scanner;
import com.osttra.dao.UserDao;
import com.osttra.to.User;


public class UserService {
		
		Scanner sc = new Scanner(System.in);
		
		UserDao userDAO = new UserDao();
		
		public void register() {
			
			System.out.println("Enter your Username!!");
			String username = sc.next();
			
			System.out.println("Enter your Email ID");
			String emailID = sc.next();
			
			System.out.println("Enter your First Name");
			String fname = sc.next();
			
			System.out.println("Enter your Last Name");
			String lname = sc.next();
			
			System.out.println("Enter your password!!");
			String password = sc.next();
			
			System.out.println("Enter your Role!!");
			String role = sc.next();
			
			User user = new User(username, emailID, fname, lname, password, role);
			
			userDAO.addUser(user);
			
		}
		
		public User login() {
					
				System.out.println("Enter your Username!!");
				String username = sc.next();
				
				System.out.println("Enter your password!!");
				String password = sc.next();
				
				User user =  userDAO.getUser(username, password);
				
				return user;
			}
}
