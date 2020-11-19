/* *
 * Name: Andrew Sunde
 * 
 * Program takes user inputed info and puts it into a binary file. 
 * The user then can request to display the information
 * to the console and also delete information in the file.
 * 
 * 
 * 
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Test {

	public static void main(String[] args) throws IOException, IOException, ClassNotFoundException {
		
		
	    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Person.bin")); // Create Person.bin outputstream
	    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Person.bin"));     // initialize inputstream
	
		int input;
		String name;
		String birthday;
		String phone;
		String email;
		
		ArrayList<Object> perArray = new ArrayList<>();
		Scanner kb = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n" +"Enter 1 if you would like to Add information into a file.");
			System.out.println("Enter 2 if you would like to retrieve information from a file and display them.");
			System.out.println("Enter 3 to exit. \n");
			
			try          							// Error handling input to loop when invalid instead of exit.
			{
				System.out.print("Please enter your selection: ");
				input = kb.nextInt();
			}
			catch(InputMismatchException exception) {
				System.out.println("This is not a valid input. Please select again.");
				kb.next();
				continue;
			}
			switch (input) { 
			
			case 1:
				try {
					System.out.println("\nEnter a name to add.");	
					name = kb.next();
					System.out.println("\nEnter this person's birthday.");	
					birthday = kb.next();
					System.out.println("\nEnter this person's phone number.");	
					phone = kb.next();
					System.out.println("\nEnter this person's email address.");	
					email = kb.next();
				}
				catch(InputMismatchException exception) {  // error handling
					System.out.println("Invalid Data");
					kb.next();
					break; }
				try {

				}
				catch(InputMismatchException exception) {  // error handling
					System.out.println("Invalid Data");
					kb.next();
					break; }
				
								 
				Person person = new Person(name,birthday,phone,email);   // Create the Person object
				
				try {
					objectOutputStream.writeObject(person);             // Write the Person object into a bin file.
				} catch (IOException e) {
					System.out.println(e.getMessage());
				} 
				System.out.print("\n"+"Information has been added to the file \n");
				
				Person pers = (Person) objectInputStream.readObject();   // Read the Object from the bin file into object.
				perArray.add(pers);                                      // Add the read object into an arraylist
				
				break;
			case 2:
				
				for (int x = 0; x < perArray.size(); x++) {	     // Print the objects from the bin file
					System.out.println(perArray.get(x)+ " ");    
				} 

			    break;
			case 3:
				
				kb.close();
				objectInputStream.close();
				objectOutputStream.close();
				System.exit(0);
				
			default :
				System.out.println("this is not a valid option. Please select again.\n");
				break;
			  }
			}

	}
	

	

}
