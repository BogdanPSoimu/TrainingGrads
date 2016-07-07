
public class PasswordMaker {
	private static final int MAGIC_NUMBER = 8;
	private static final String MAGIC_STRING = new RandomStringGenerator(22,"abcdefghijklmnopqrstuvwxyz").next();
	private String firstName; 
	private String lastName; 
	private int age;
	
	public PasswordMaker(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String getPassword() {
		String first = firstName.substring(firstName.length() - age%3);
		String randomAlph = new RandomStringGenerator(10, MAGIC_STRING).next();
		String second = new RandomStringGenerator(MAGIC_NUMBER, randomAlph).next();
		String third = "" + (age + lastName.length());
		
		String password = first.concat(second);
		password = password.concat(third);
		
		return password;
	}
}
