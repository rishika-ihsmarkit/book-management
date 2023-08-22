package com.osttra;

import java.util.Scanner;

import com.osttra.service.BookService;
import com.osttra.service.UserService;
import com.osttra.to.User;

public class Controller {
	
	static Scanner sc = new Scanner(System.in);
	private String role;
	
	public Controller(String role) {
		super();
		this.role = role;
	}

	public void mainmenu() {
		
		BookService bookService = new BookService();
		
		int mainMenuInput=1;
		
		do {
			
			System.out.println("*****************************************");
			System.out.println("Enter your choice");
			System.out.println("1. View all books");
			System.out.println("2. Add a book");
			System.out.println("3. Search a book");
			System.out.println("4. Exit");
			
			mainMenuInput = sc.nextInt();
			
			switch( mainMenuInput ) {
			
			case 1:
				System.out.println("Displaying all the books");
				bookService.listAllBooks();
				break;
				
			case 2:

				if(role.equals("admin")) {
					System.out.println("Adding a book...");
					bookService.addBook();
					System.out.println("Book added successfully");
				}
				else {
					System.out.println("Permission denied. Only admins can add books.");
				}

				break;
				
			case 3:
				bookService.findBook();
				break;
			
			case 4:
				System.out.println("Exitting to the outer menu...");
				break;
				
			default:
				System.out.println("Please enter choice between 1-4");
					
			}
	
		}while(mainMenuInput!=4);
		
	}

	public static void main(String[] args) {
		
		int MenuInput=1;
		UserService userService = new UserService();
		
		do {
			
			System.out.println("*****************************************");
			System.out.println("Enter your choice");
			System.out.println("1. Registration");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			
			MenuInput = sc.nextInt();
			
			switch( MenuInput ) {
			
			case 1:
				System.out.println("Registration ongoing...");
				userService.register();
				System.out.println("Registered successfully");
				break;
				
			case 2:
				System.out.println("Login ongoing...");
				
				User user = userService.login();
		
				if( user !=null ) {
					System.out.println("Login successful");
					Controller controller = new Controller(user.getRole());
					controller.mainmenu();
				}else{
					System.out.println("Login failed !!!");
				}
				break;
			
			case 3:
				System.out.println("Exitting...");
				break;
				
			default:
				System.out.println("Please enter choice between 1-3");
				
		}

	}while(MenuInput!=3);

}
}