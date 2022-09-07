package easy.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] arr = new String[] {"eat","tea","tan","ate","nat","bat"};
		findAnagrams(arr);
	}

	private static void findAnagrams(String[] arr) {
		List<List<String>> anagrams = new ArrayList<>();
		for(int i=0;i<arr.length; i++) {
			int j=i+1;
			List<String> anagramPair = new ArrayList<>();
			anagramPair.add(arr[i]);
			while(j<arr.length) {
				if(arr[i].length()==arr[j].length()) {
					char[] iChar = arr[i].toCharArray();
					char[] jChar = arr[j].toCharArray();
					Arrays.sort(iChar);
					Arrays.sort(jChar);
					if(String.valueOf(iChar).equalsIgnoreCase(String.valueOf(jChar))) {
						anagramPair.add(String.valueOf(jChar));
						anagrams.add(anagramPair);
					}
				}
				j++;
			}
		}
		for(List<String> pair: anagrams) {
			System.out.println("\n");
			for(String str: pair) {
				System.out.println(str);
			}
		}
	}

}
