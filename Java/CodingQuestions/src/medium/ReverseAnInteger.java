package medium;

public class ReverseAnInteger {

	public static void main(String[] args) {
		System.out.println(reverse(123));//321
		System.out.println(reverse(743));//347
		System.out.println(reverse(8901));//1098
		
	}

	private static int reverse(int i) {
		return Integer.parseInt(new StringBuffer(String.valueOf(i)).reverse().toString());
	}

}
