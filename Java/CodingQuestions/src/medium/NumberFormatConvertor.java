package medium;

import java.util.HashMap;
import java.util.Map;

public class NumberFormatConvertor {

	private static final int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	private static final String[] romanNums = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};


	public static void main(String[] args) {

		System.out.println(integerToRomanConvertor(3));//III
		System.out.println(integerToRomanConvertor(58));//LVIII
		System.out.println(integerToRomanConvertor(1994));//MCMXCIV
		System.out.println(integerToRomanConvertor(2004));//MMIV
		System.out.println(integerToRomanConvertor(904));//CMIV
		System.out.println(integerToRomanConvertor(594));//DXCIV

		System.out.println(romanToIntegerConvertor("III"));//3
		System.out.println(romanToIntegerConvertor("LVIII"));//58
		System.out.println(romanToIntegerConvertor("MCMXCIV"));//1994

	}

	private static String integerToRomanConvertor(int num) {
		StringBuilder sb = new StringBuilder();

		if(num < 0) {
			return "Zero";
		}

		for(int i=0; i<nums.length; i++) {
			while(num >= nums[i]) {
				num = num - nums[i];
				sb.append(romanNums[i]);
			}
		}
		return sb.toString();
	}

	private static int romanToIntegerConvertor(String romanNumber) {
		
		Map<String, Integer> mapping = new HashMap<>();
		mapping.put("I", 1);
        mapping.put("V", 5);
        mapping.put("X", 10);
        mapping.put("L", 50);
        mapping.put("C", 100);
        mapping.put("D", 500);
        mapping.put("M", 1000);//MCMXCIV - 1994
        romanNumber = romanNumber.replace("IV", "IIII");
        romanNumber = romanNumber.replace("IX", "VIIII");
        romanNumber = romanNumber.replace("XL", "XXXX");
        romanNumber = romanNumber.replace("XC", "LXXXX");
        romanNumber = romanNumber.replace("CD", "CCCC");
        romanNumber = romanNumber.replace("CM", "DCCCC");//MDCCCCLXXXXIIII

        long totalM,totalD, totalC,totalL,totalX,totalV,totalI = 0;
        totalM = romanNumber.chars().filter( c -> c == 'M').count();
        totalD = romanNumber.chars().filter(ch -> ch == 'D').count();//500
        totalC = romanNumber.chars().filter(ch -> ch == 'C').count();//100
        totalL = romanNumber.chars().filter(ch -> ch == 'L').count();//50
        totalX = romanNumber.chars().filter(ch -> ch == 'X').count();//10
        totalV = romanNumber.chars().filter(ch -> ch == 'V').count();//5
        totalI = romanNumber.chars().filter(ch -> ch == 'I').count();//1


		return (int) (totalM*mapping.get("M") + totalD*mapping.get("D") + totalC*mapping.get("C") + totalL*mapping.get("L") + totalX*mapping.get("X") + totalV*mapping.get("V") + totalI*mapping.get("I"));
	}

}
