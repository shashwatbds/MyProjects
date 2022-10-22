package medium.string;

public class FindLongestSubstringWithRepeatingCharacter {

	public static void main(String[] args) {

		System.out.println(find("abcabcbb"));//3 - abc
		System.out.println(find("bbbb"));//1 - b
		System.out.println(find("pwwkew"));//3 - kew

	}

	private static int find(String string) {
		int maxLen = 1;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<string.length(); i++) {
			int len =1;
			int j=i+1;
			sb = new StringBuilder();
			sb.append(string.charAt(i));
			while(j<string.length()) {
				if(sb.indexOf(String.valueOf(string.charAt(j))) == -1) {
					sb.append(string.charAt(j));
					len++;
				} else {
					break;
				}
				j++;
			}
			if(len>maxLen) {
				maxLen = len;
			}
		}
		return maxLen;
	}

}
