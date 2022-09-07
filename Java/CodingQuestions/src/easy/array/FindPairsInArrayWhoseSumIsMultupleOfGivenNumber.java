package easy.array;

import java.util.ArrayList;
import java.util.List;

public class FindPairsInArrayWhoseSumIsMultupleOfGivenNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		//divisible by 60 - [30,20,150,100,40]
		list.add(30);list.add(20);list.add(150);list.add(100);list.add(40);
		int count=2;
		int total=60;
		find(list, total, count);
	}

	private static void find(List<Integer> list, int total, int count) {

		for(int i=0; i<list.size(); i++) {
			int j=i+1;
			while(j<list.size()) {
				if(((list.get(i) +list.get(j))%total)==0) {
					System.out.println(list.get(i)+"+"+list.get(j)+" is directly divisible by "+total);
				}
				j++;
			}
		}
	}

}
