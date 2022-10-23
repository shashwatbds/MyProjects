package easy.computation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class IntegerToRoamanNumber {

	private static final Map<String, Integer> mapping = new LinkedHashMap<>();

	public IntegerToRoamanNumber() {
		mapping.put("M", 1000);
		mapping.put("D", 500);
		mapping.put("C", 100);
		mapping.put("L", 50);
		mapping.put("X", 10);
		mapping.put("V", 5);
		mapping.put("I", 1);
	}

	public static void main(String[] args) {
		IntegerToRoamanNumber itr = new  IntegerToRoamanNumber();
		itr.IntegerToRoaman(3555);//MMMDLV
		itr.IntegerToRoaman(5);//V
		itr.IntegerToRoaman(3);//III
		itr.IntegerToRoaman(555);//DLV
		itr.IntegerToRoaman(2055);//MMLV
		itr.IntegerToRoaman(1505);//MDV
	}
	private void IntegerToRoaman(int i) {
		StringBuilder number = new StringBuilder("");
		int remainder = i;
		int count = 0;
		for(Entry<String, Integer> entry : mapping.entrySet()) {
			count = remainder/entry.getValue();
			remainder = remainder % entry.getValue();
			for(int j =0; j<count;j++) {
				number.append(entry.getKey());
			}
		}
		System.out.println(number);
	}

}
