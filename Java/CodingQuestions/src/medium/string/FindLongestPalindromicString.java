package medium.string;

import java.util.Stack;

public class FindLongestPalindromicString {

	public static void main(String[] args) {

		System.out.println(find("babad"));//3 - bab or aba
		System.out.println(find("cbbd"));//2 - bb
	}

	private static String find(String string) {
		
		int maxLen = 0;
		String maxPalindrome = "";
		
		for(int i=0; i<string.length();i++) {
			int j=i+1;
			while(j<string.length()) {
				String subStr = string.substring(i, j);
				if(checkIfPalindrome(subStr)) {
					if(maxLen < subStr.length()) {
						maxLen = subStr.length();
						maxPalindrome = subStr;
					}
				}
				j++;
			}
		}
		return maxPalindrome;
	}

	private static boolean checkIfPalindrome(String string) {
		boolean isPalidrome = false;
		
		StringBuilder reverseString = new StringBuilder(string);
		if(string.equals(reverseString.reverse().toString())){
			isPalidrome=true;
		}
		return isPalidrome;
	}

}
