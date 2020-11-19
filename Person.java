/* *
 * Name: Andrew Sunde
 * 
 * Person class implements Serializable interface
 * Contains 4 string variables.
 * 
 */


import java.io.Serializable;

class Person implements Serializable { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String birthday;
	String phone;
	String email;

	public Person(String name, String birthday, String phone, String email) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person's name: " + name + ", birthday: " + birthday + ", phone number: " + phone + ", email address: " + email + "";
	}
	}