package org.example.blind75.twopointers.easy;

/**
 * After converting all chars to lower case, removing all alphanumeric characters
 * */
public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome obj = new ValidPalindrome();
//        System.out.println(obj.isPalindromeBruteForce("Was it a car or a cat I saw?"));
//        System.out.println(obj.isPalindromeBruteForce("tab a cat"));
//        System.out.println(obj.isPalindromeBruteForce("A man, a plan, a canal: Panama"));
//        System.out.println(obj.isPalindromeBruteForce("race a car"));
//        System.out.println(obj.isPalindromeBruteForce(" "));

        System.out.println("\n\nEfficient Solution");

        System.out.println(obj.isPalindrome("Was it a car or a cat I saw?"));
        System.out.println(obj.isPalindrome("tab a cat"));
        System.out.println(obj.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(obj.isPalindrome("race a car"));
        System.out.println(obj.isPalindrome(" "));
    }

    /**
     * 1. First iteration, remove the special characters from string
     * 2. Reverse string
     * 3. Compare both strings if they are equal
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public boolean isPalindromeBruteForce(String s) {


        return false;
    }

    /**
     * Two pointer solution -
     * 1. left pointer and right pointer: left pointer will start from index 0  and right pointer will start from index len-1.
     * 2. If with left or right pointer we encounter a non-alphanumeric character then move pointer one extra space.
     * Time Complexity: O(n)
     * Space Complexity: 1
     * */
    public boolean isPalindrome(String s) {

        int left = 0, right = s.length()-1;
        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
