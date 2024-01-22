package com.dev.ofms.utils;

import java.util.Random;

public class CheckinUtils {

	public static String generateSessionKey(int length, String alphabet){
	    int n = alphabet.length(); // 10
	    String result = new String();
	    Random r = new Random(); // 11
	    for (int i=0; i<length; i++) // 12
	        result = result + alphabet.charAt(r.nextInt(n)); //13
	    return result;
	}
	
}
