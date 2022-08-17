package collections.linkedlist;

import java.util.HashMap;

public class HashMapTest {

	HashMap<Integer,Integer> ourMap;

	public HashMapTest() {
		ourMap = new HashMap<>();
	}

	public void add(int number) {
		ourMap.put(number, ourMap.getOrDefault(number, 0)+1);
	}

	public boolean find(int data) {

		for(Integer key : ourMap.keySet()) {
			int complement = data - key;
			int freq_comp = ourMap.getOrDefault(complement, 0);

			if(data - key == key) {
				if(freq_comp >=2) {
					return true;
				} else {
					if(freq_comp >=1) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {


	}
}
