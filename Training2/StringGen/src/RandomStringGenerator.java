import java.util.Random;

public class RandomStringGenerator {
	private int length;
	private char[] alphabet;
	
	Random generator = new Random();
	
	public RandomStringGenerator(int length, String alphabet) {
		super();
		this.length = length;
		this.alphabet = alphabet.toCharArray();
	}
	
	public String next() {
		char[] randomString = new char[length];
		for(int i = 0; i < length; i++)
			randomString[i] = alphabet[generator.nextInt(alphabet.length)];
		
		String finalString=new String(randomString);
		return finalString;
	}
}
