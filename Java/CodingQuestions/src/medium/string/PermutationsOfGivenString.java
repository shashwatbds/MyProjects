package medium.string;

public class PermutationsOfGivenString {

	public static void main(String[] args) {
//		findPermutationCount("ABC", "");
		findPermutationCount("ABSG", "");
	}

	private static void findPermutationCount(String string, String ans) {
		System.out.println("String "+string+" ans "+ans );
		if(string.length()==0) {
			System.out.println(ans+" ");
		}
		for(int i=0; i<string.length(); i++) {
			System.out.println("String "+string+" i "+i );
			char c = string.charAt(i);
			String ros = string.substring(0,i)+string.substring(i+1);
			findPermutationCount(ros, ans+c);
		}
			
	}
}
