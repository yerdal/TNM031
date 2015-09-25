import java.math.BigInteger;
//import java.math.*;
import java.util.Random;
import java.util.Scanner;


public class MainClass {
	public static void main(String[] args) throws Exception {
		
		RSA key = new RSA();
		String input = "";
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter message: ");
		input = in.nextLine();
		System.out.println("Entered message " + input);
		
		BigInteger encryptInput = key.encrypt(input, key.getE(), key.getN());
		System.out.println("Encrypted " + input + " \nto " + encryptInput);
		
		String decryptedInput = key.decrypt(encryptInput);
		System.out.println("Decrypted " + encryptInput + " \nto " + decryptedInput);
	}
}
