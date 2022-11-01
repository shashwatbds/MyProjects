package algorithms.recursion;

public class ReversingAString {

	public static void main(String[] args) {

		reverse("Software");
	}

	private static void reverse(String string) {

		if(string == null | string.length() <=1) {
			System.out.println(string);
		} else {
			System.out.println(string.charAt(string.length()-1));
			reverse(string.substring(0, string.length()-1));
		}
	}

}
