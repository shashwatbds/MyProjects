package medium.string;

//Find smallest string containing all character of other string
public class SearchSubstirngInString {

	public static void main(String[] args) {

		System.out.println(find("timetopractoce","toc"));
		System.out.println(find("zoomlazapzo","oza"));
	}

	private static boolean find(String string, String string2) {
		int l1 = string.length(), l2 = string2.length();
		for(int i = 0; i<l1-l2; i++) {
			if(string.substring(i, i+l2).equals(string2)) {
				return true;
			}
		}
		return false;
	}

}
