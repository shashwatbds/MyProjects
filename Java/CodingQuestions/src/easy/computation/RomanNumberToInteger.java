package easy.computation;

import java.util.HashMap;
import java.util.Map;

public class RomanNumberToInteger {

	private static final Map<String, Integer> mapping = new HashMap<>();

    public RomanNumberToInteger() {
        mapping.put("I", 1);
        mapping.put("V", 5);
        mapping.put("X", 10);
        mapping.put("L", 50);
        mapping.put("C", 100);
        mapping.put("D", 500);
        mapping.put("M", 1000);
    }

    public static void main(String[] args) {
        RomanNumberToInteger rti = new RomanNumberToInteger();
        rti.convertRomanToInteger("MMMDLV");//3555
        rti.convertRomanToInteger("V");//5 
        rti.convertRomanToInteger("III");//3
        rti.convertRomanToInteger("MMLV");//2055
        rti.convertRomanToInteger("DLV");//555
        rti.convertRomanToInteger("MDV");//1505

    }

    private void convertRomanToInteger(String roman) {
        long number = 0;
        long totalM,totalD, totalC,totalL,totalX,totalV,totalI = 0;
        totalM = roman.chars().filter(ch -> ch == 'M').count();//1000
        totalD = roman.chars().filter(ch -> ch == 'D').count();//500
        totalC = roman.chars().filter(ch -> ch == 'C').count();//100
        totalL = roman.chars().filter(ch -> ch == 'L').count();//50
        totalX = roman.chars().filter(ch -> ch == 'X').count();//10
        totalV = roman.chars().filter(ch -> ch == 'V').count();//5
        totalI = roman.chars().filter(ch -> ch == 'I').count();//1

        number = totalM*mapping.get("M") + totalD*mapping.get("D") + totalC*mapping.get("C") + totalL*mapping.get("L") + totalX*mapping.get("X") + totalV*mapping.get("V") + totalI*mapping.get("I");
        System.out.println(number);
    }
}
