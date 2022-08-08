package easy.string;

public class ReverseAString {

	public static void main(String[] args) {
		System.out.println("Reverse of String "+"GeeksForGeeks "+"is "+reverseAStringSimple("GeeksForGeeks"));
		System.out.println("Reverse of String "+"GeeksForGeeks "+"is "+reverseAStringStringBuilder("GeeksForGeeks"));

	}

	private static String reverseAStringSimple(String string) {
		StringBuilder arr = new StringBuilder();
		int len= string.toCharArray().length;
		for(int i=0; i<len;i++) {
			arr.append(string.charAt(len-1-i));
		}
		return arr.toString();
	}

	private static String reverseAStringStringBuilder(String string) {
		return new StringBuilder(string).reverse().toString();
	}

}
