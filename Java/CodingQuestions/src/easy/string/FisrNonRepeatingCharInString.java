package easy.string;

import java.util.ArrayList;
import java.util.List;

public class FisrNonRepeatingCharInString {

	public static void main(String[] args) {
		find("fibonaccif");
		find("peapoeak");

	}

	private static void find(String string) {
		List<Character> list = new ArrayList<Character>(string.length());
		for(int i =0; i<string.length();i++) {
			boolean found = true;
			int j = i+1;
			while(j<string.length()) {
				if(string.charAt(i) == string.charAt(j)) {
					found = false;
					list.add(string.charAt(i));
					break;
				}
				j++;
			}
			if(found && !list.contains(string.charAt(i))) {
				System.out.println(string.charAt(i));
				break;
			}

		}
	}

}
