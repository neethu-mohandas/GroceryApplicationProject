package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	 
	Faker faker=new Faker();
	
	public String randomUsername() {
		 return faker.name().username(); //create random username
		 }
	
	public String randomPassword() {
		 return faker.internet().password(); //create random password
		 }
	
	public String randomEmail() {
		return faker.internet().emailAddress(); //create random email
	}
	
	public String randomFullname() {
		 return faker.name().fullName(); //create random fullname
	}
	
}
