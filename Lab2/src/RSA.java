import java.math.*;
import java.security.SecureRandom;
import java.util.*;


public class RSA {
	
	private final static BigInteger one  = new BigInteger("1");
	//private keys keeps to the sender
	private BigInteger p;
	private BigInteger q;
	
	private BigInteger n;
	private BigInteger e;
	private BigInteger d;
	
	public RSA(){
		p = BigInteger.probablePrime(1024, new Random());
		q = BigInteger.probablePrime(1024, new Random());
		n = p.multiply(q);
		e = BigInteger.probablePrime(1024, new Random());
		d = e.modInverse(p.subtract(one).multiply(q.subtract(one)));
	
	}
	
	public BigInteger encrypt(String input, BigInteger E, BigInteger N){
		
		BigInteger msg = new BigInteger(input.getBytes());
		
		return msg.modPow(E, N);
		
	}
	
	public String decrypt(BigInteger msg){
		
		BigInteger message =  msg.modPow(d, n);
		String decrypted = new String(message.toByteArray());
		
		return decrypted;
		
	}
	
	public BigInteger getN(){
		return n;
	}
	public BigInteger getE(){
		return e;
	}
	
	
}
