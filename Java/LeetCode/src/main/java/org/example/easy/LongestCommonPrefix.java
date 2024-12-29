package org.example.easy;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();
        System.out.println("fl".equals(obj.longestCommonPrefix(new String[]{"flower","flow","flight"})));
        System.out.println("".equals(obj.longestCommonPrefix(new String[]{"dog","racecar","car"})));

    }

    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {

            while(!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
}
