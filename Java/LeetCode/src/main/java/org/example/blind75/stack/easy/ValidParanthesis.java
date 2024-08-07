package org.example.blind75.stack.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {

    public static void main(String[] args) {
        ValidParanthesis obj = new ValidParanthesis();
        System.out.println(Boolean.TRUE.equals(obj.isValid("()")));
        System.out.println(Boolean.TRUE.equals(obj.isValid("()[]{}")));
        System.out.println(Boolean.FALSE.equals(obj.isValid("(]")));
        System.out.println(Boolean.TRUE.equals(obj.isValid("[]")));
        System.out.println(Boolean.TRUE.equals(obj.isValid("([{}])")));
        System.out.println(Boolean.FALSE.equals(obj.isValid("[(])")));
        System.out.println(Boolean.FALSE.equals(obj.isValid("((")));
    }

    /**
     * Time complexity: O(n)
     * Space Complexity: O(n)
     * */
    private boolean isValid(String s) {

        Map<Character, Character> mappedBrackets = new HashMap<>();
        mappedBrackets.put(')', '(');
        mappedBrackets.put(']', '[');
        mappedBrackets.put('}', '{');

        if (s.isBlank() || s.isEmpty())
            return true;
        else if (s.length()%2 !=0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!mappedBrackets.containsKey(c)) {
                stack.push((c));
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    char topElement = stack.pop();
                    if(topElement != mappedBrackets.get(c)) {
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}
