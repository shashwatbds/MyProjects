package medium.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CheckBalancedParenthesis {

	private static Map<Character, Character> paranthesisMapping = new HashMap<>();
	
	static {
		paranthesisMapping.put('[', ']');
		paranthesisMapping.put('{', '}');
		paranthesisMapping.put('(', ')');
	}
	
	public static void main(String[] args) {

		System.out.println(check("[()]{}{[()()]()}"));
		System.out.println(check("[(])"));
	}

	private static boolean check(String string) {

		Stack<Character> stack = new Stack<>();
		for(int i=0; i<string.length();i++) {
			if(string.charAt(i) == '[' || string.charAt(i) == '{' || string.charAt(i) == '(') {
				stack.push(string.charAt(i));
			} else if(string.charAt(i) == ']' || string.charAt(i) == '}' || string.charAt(i) == ')') {
				Character c = stack.pop();
				if(string.charAt(i) != paranthesisMapping.get(c)) {
					return false;
				}
			}
		}
		return true;
	}

}
