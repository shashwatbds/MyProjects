package medium.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindSubstringContainingChars {

	public static void main(String[] args) {

		System.out.println(find("pfijyxzoii","xyz"));
		System.out.println(find("pfiyjxzoii","xyz"));
	}

	//sliding window length is fixed
	private static boolean find(String str, String substr) {
		
		if(str.isBlank() || substr.isBlank() || substr.length()>str.length() ) return false;
		int lStr = str.length(); int sStr = substr.length();
		for(int i =0; i<(lStr-sStr); i++) {
			int low = i;
			int high = i+sStr;
			boolean equals = true;
			for(char c: substr.toCharArray()) {
				if(!str.substring(low, high).contains(c+"")) {
					equals=false;
				}
			}
			if(equals) return true;
			
		}
		return false;
	}
	
	private static boolean exists(String substring, String substr) {
		boolean exists = true;
		for(char c: substr.toCharArray()) {
			if(substring.indexOf(c) < 0) {
				exists = false;
			}
		}
		return exists;
	}

	private static boolean contains(String s1, String s2) {
		return false;
		
	}

}
