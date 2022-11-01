package algorithms.recursion;

public class Parlidrome {

	public static void main(String[] args)  {

		try {
			printPalindrome(1242);
			System.out.println("Is a Palindrome");
		}catch(Exception e) {
			System.out.println("Not a Palindrome");
		}
		try {
			printPalindrome(1221);
			System.out.println("Is a Palindrome");
		}catch(Exception e) {
			System.out.println("Not a Palindrome");
		}	
	}

	private static int printPalindrome(int num) throws Exception {

		if (num < 0) {
			num = (-num);
		}
		int revNum = num;
		return palindromeUntil(num, revNum);
	}

	private static int palindromeUntil(int num, int revNum) throws Exception {

		System.out.println(num);
		System.out.println(revNum+"\n");

		if(num==0) {
			return revNum;
		} else {
			revNum = palindromeUntil(num/10, revNum);
		}

		if(num %10 == revNum %10) {// comparing first digit of num with last digit of revNum
			return revNum/10;
		} else {
			throw new Exception();
		}
	}
}
