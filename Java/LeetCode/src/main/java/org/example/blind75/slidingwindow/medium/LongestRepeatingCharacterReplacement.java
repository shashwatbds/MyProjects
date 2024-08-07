package org.example.blind75.slidingwindow.medium;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
        System.out.println( 4 == obj.characterReplacement("XYYX", 4));
        System.out.println( 5 == obj.characterReplacement("AAABABB", 1));
        System.out.println( 4 == obj.characterReplacement("ABAB", 2));
        System.out.println( 4 == obj.characterReplacement("AABABBA", 1));
        System.out.println( 3 == obj.characterReplacement("BAAA", 0));
        System.out.println( 2 == obj.characterReplacement("ABAA", 0));
        System.out.println( 4 == obj.characterReplacement("ABBB", 2));
    }

    private int characterReplacement(String s, int k) {

        int[] occurance = new int[26];
        int left = 0;
        int ans = 0;
        int maxOccurance = 0;
        for(int right = 0; right< s.length(); right++) {

            maxOccurance = Math.max(maxOccurance, ++occurance[s.charAt(right)-'A']);
            if(right - left + 1 - maxOccurance > k) {
                occurance[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }


    //Mine
    private int characterReplacementMine(String s, int k) {

        int max = 0;
        for(int i=0; i< s.length(); i++) {
            if(s.substring(i).length() < max) break;
            if(i > 0 && s.charAt(i) == s.charAt(i-1)) continue;
            int j=i+1, count = k;
            while(j<s.length()){
                if(s.charAt(i) == s.charAt(j))
                    j++;
                else if(count != 0) {
                    j++;
                    count--;
                } else {
                    break;
                }
            }
            max = Math.max(max, j-i==1?0:j-i);
        }
        return max;
    }
}
