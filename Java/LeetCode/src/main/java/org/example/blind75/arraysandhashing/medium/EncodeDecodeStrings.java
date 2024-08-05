package org.example.blind75.arraysandhashing.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStrings {

    public static void main(String[] args) {

    }

    public String encode(List<String> strs) {

        if(strs.isEmpty())
            return Character.toString((char) 258);

        String seperator = Character.toString((char) 257);
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            sb.append(str);
            sb.append(seperator);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public List<String> decode(String str) {

        if(str.equalsIgnoreCase(Character.toString((char) 258)))
            return new ArrayList<>();

        String seperate = Character.toString((char) 257);
        return Arrays.asList(str.split(seperate));
    }
}
