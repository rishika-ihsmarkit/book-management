package com.osttra.service;

import java.util.Scanner;
import com.osttra.dao.UserDao;
import com.osttra.to.User;


public class UserService {
		
		Scanner sc = new Scanner(System.in);
		
		UserDao userDAO = new UserDao();
		
		public void register() {
			
			System.out.println("Enter your Username!!");
			String username = sc.nextLine();
			
			System.out.println("Enter your Email ID");
			String emailID = sc.nextLine();
			
			System.out.println("Enter your First Name");
			String fname = sc.nextLine();
			
			System.out.println("Enter your Last Name");
			String lname = sc.nextLine();
			
			System.out.println("Enter your password!!");
			String password = sc.nextLine();
			
			System.out.println("Enter your Role!!");
			String role = sc.nextLine();
			
			if(role.equals("admin") || role.equals("customer")) {
				
				User user = new User(username, emailID, fname, lname, password, role);
		
				userDAO.addUser(user);
				
				System.out.println("Registered successfully");
			}
			else {
				
				System.out.println("Please enter correct role !!");
				
			}
			
			
			
		}
		
		public User login() {
					
				System.out.println("Enter your Username!!");
				String username = sc.nextLine();
				
				System.out.println("Enter your password!!");
				String password = sc.nextLine();
				
				User user =  userDAO.getUser(username, password);
				
				return user;
			}
}
