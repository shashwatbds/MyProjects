package easy.string;

public class ReverseAStringUsingStack {

	public static void main(String[] args) {
		StackUsingStringArrays stack = new StackUsingStringArrays();
		String s = "GeeksForGeeks";
		for(char c : s.toCharArray()) {
			stack.push(c);
		}
		char[] rev = new char[s.length()];
		for(int i=0; i< s.length(); i++) {
			rev[i] = stack.pop();
//			System.out.println(rev[i]);
		}
		
	}
}
