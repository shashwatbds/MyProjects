package easy.string;

import java.util.HashMap;
import java.util.Map;

public class ParenthesisChecker {

	static Map<Character, Character> mapping = new HashMap<>();

	static {
		mapping.put(']','[');
		mapping.put(')','(');
		mapping.put('}','{');
	}
	public static void main(String[] args) {
		System.out.println(checkPerfectParanthesis("{([])}"));
		System.out.println(checkPerfectParanthesis("[()]{}{[()()]()}"));
		System.out.println(checkPerfectParanthesis("[()"));
		System.out.println(checkPerfectParanthesis("[()]{}"));
		System.out.println(checkPerfectParanthesis("()"));
	}

	private static boolean checkPerfectParanthesis(String string) {
		if(string.length()%2!=0) {
			return false;
		}
		boolean end = false;
		Stack stack = new Stack(string.length());
		for(char c: string.toCharArray()) {
			if(c == '[' || c =='(' || c == '{') {
				stack.push(c);
				if(end)
					return false;
			} else if(c == ']' || c =='}' || c == ')') {
				end=true;
				char ret = stack.pop();
				if(mapping.get(c) != ret) {
					return false;
				}
			} else
				return false;
		}
		return true;
	}
}
