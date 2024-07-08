package org.example.easy;


import java.time.Duration;
import java.time.Instant;

public class PalimromeCheck {

    public static void main(String[] args) {
        PalimromeCheck palimromeCheck = new PalimromeCheck();
        System.out.println("121 - " + palimromeCheck.isPalindrome(121));
        System.out.println("1210 - " + palimromeCheck.isPalindrome(1210));
        System.out.println("-121 - " + palimromeCheck.isPalindrome(-121));
        System.out.println("10 - " + palimromeCheck.isPalindrome(10));
        System.out.println("1001 - " + palimromeCheck.isPalindrome(1001));

        System.out.println("\n\nEfficient Way to follow now - \n\n");

        System.out.println("121 - " + palimromeCheck.isPalindromeEfficient(121));
        System.out.println("1210 - " + palimromeCheck.isPalindromeEfficient(1210));
        System.out.println("-121 - " + palimromeCheck.isPalindromeEfficient(-121));
        System.out.println("10 - " + palimromeCheck.isPalindromeEfficient(10));
        System.out.println("1001 - " + palimromeCheck.isPalindromeEfficient(1001));
    }

    private boolean isPalindrome(int x) {
        Instant start = Instant.now();
        int z = x;
        int reversed = 0;
        while(x>0) {
            int lastDigit = x%10;//1,0,0,1
            reversed = reversed*10+lastDigit;//1,10,100,1001
            x/=10;//100,10,1,0
        }
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("time taken to execute "+timeElapsed);
        return reversed==z;
    }

    private boolean isPalindromeEfficient(int x) {
        Instant start = Instant.now();
        if(x<0 //negetive number can't be a palindrome
                || (x!=0 && x%10==0)) { //if last digit of the number is 0 then then number isn't a palindrome since number can not begin with zero.
            return false;
        }

        int original = x;
        int reversed = 0;
        while(x>reversed) {
            int lastDigit = x%10;
            reversed = reversed*10+lastDigit;
            x/=10;
        }
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("time taken to execute "+timeElapsed);
        return (reversed==x) //if number has even number of digits
                || (x==reversed/10); //if number has odd number of digits
    }
}
