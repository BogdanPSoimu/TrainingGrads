
public class Main {

	public static void main(String[] args) {
		RandomStringGenerator myGenerator = new RandomStringGenerator(5, "abcdef"); 
		System.out.println(myGenerator.next());
		
		PasswordMaker pw = new PasswordMaker("Soimu", "Bogdan", 22);
		System.out.println(pw.getPassword());
	}

}
