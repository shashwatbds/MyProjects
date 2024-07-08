package org.example.easy;

import java.time.Duration;
import java.time.Instant;

public class RomanNumberToInteger {

    public static void main(String[] args) {

        RomanNumberToInteger object = new RomanNumberToInteger();
        System.out.println("III - "+object.printNumber("III"));
        System.out.println("LVIII - "+object.printNumber("LVIII"));
        System.out.println("MCMXCIV - "+object.printNumber("MCMXCIV"));//1000 900 90 04 = 1994
    }

    /**
     * Tip:
     * 1. Evaluate two chars at a time
     * 2. Sometimes two chars are needed to compute a value where first value is less than the next one.
     *          In this case we can calculate the actual value using next - curr
     * */
    private int printNumber(String romanNumber) {
        Instant start = Instant.now();
        int result = 0, curr = 0, next = 0, i = 0 ;
        int len = romanNumber.length();
        while(i<len) {// start from first index
            if(i==len-1){  // reached at last index, this is last iteration and avoid IndexOutOfBoundsException
                result += getInt(romanNumber.charAt(i));
                return result;
            }

            curr = getInt(romanNumber.charAt(i));//Int at Current Index
            next = getInt(romanNumber.charAt(i+1));// Int at next index
            if(curr>=next) {
                result +=curr; //We do not need to worry about next char since that will be independent and hence char at current index can be individually considered.
                i +=1;
            } else {
                result += next - curr;//if curr is less than next then it means this is a case where two chars will cumulatively determine the next int.
                i+=2;//Since we have consumed both chars to calculate int we can skip next two chars.
            }

        }
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("time taken to execute "+timeElapsed);
        return result;
    }

    public static int getInt(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }

    }
}
