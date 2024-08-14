package org.example.blind75.stack.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        ValidParenthesis obj = new ValidParenthesis();
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

        if (s.isBlank() || s.isEmpty())
            return true;
        else if (s.length()%2 !=0) {
            return false;
        }

        Map<Character, Character> mappedBrackets = new HashMap<>();//Creating mapping of of the combinations
        mappedBrackets.put(')', '(');
        mappedBrackets.put(']', '[');
        mappedBrackets.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!mappedBrackets.containsKey(c)) {
                stack.push((c));//Add all opening brackets in the stack until you encounter a closing bracket
            } else {
                if(stack.isEmpty()) {//If stack is empty then first bracket can not be a closing bracket, hence returning false.
                    return false;
                } else {
                    char topElement = stack.pop();
                    if(topElement != mappedBrackets.get(c)) {//If we encounter a closing bracket them in the stack we must have its matching opening bracket at the top else its not valid parenthesis.
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;//If there are only opening brackets and no closing brackets in the input string.
    }
}
