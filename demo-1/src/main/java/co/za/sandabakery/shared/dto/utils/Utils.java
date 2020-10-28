package co.za.sandabakery.shared.dto.utils;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	private final Random RANDOM=new SecureRandom();
	private final String ALAPHABET="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	/*private final int ITERATIONS=1200;
	private final int KEY_LENGTH=256;*/
	
	
	public String generateUserId(int length) {
		
		return generateRandomString(length);
	}
	
	
    public String generateAddressId(int length) {
		
		return generateRandomString(length);
	}
    
    
    public String generateImageId(int length) {
		
 		return generateRandomString(length);
 	}
    
    
	
	private String generateRandomString(int length) {
		
		StringBuilder returnVal=new StringBuilder();
		
		for(int x=0;x<length;x++) {	
			returnVal.append(ALAPHABET.charAt(RANDOM.nextInt(ALAPHABET.length())));
		}
		
		return new String(returnVal);
	}

}

