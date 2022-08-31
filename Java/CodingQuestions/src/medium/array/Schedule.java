package medium.array;

import java.util.LinkedList;

public class Schedule {

	public static void main(String[] args) {

		String n = "7";
		String l1 = "0 1 2";
		String l2 = "1 3";
		String l3 = "2 3";
		String l4 = "3 4 5";
		String l5 = "4 6";
		String l6 = "5 6";
		String[] arr = {n,l1,l2,l3,l4,l5,l6};


		find(arr);
		
	}

	private static void find(String[] arr) {

		int count = 0, arrIndex=0;
		int numCourses = Integer.parseInt(arr[0]);
		int[][] pre = new int[arr.length-1][1];
		while(count!=arr.length) {
			if(count == 0) {
				count++;
				continue;
			}
			String line = arr[count];
			String[] temp = line.split(" ");
			int[] arr1 = new int[temp.length];
			for(int i=0; i< temp.length; i++) {
				arr1[i] = Integer.parseInt(temp[i]);
			}
			pre[arrIndex] = arr1;
			count++;
			arrIndex++;
		}
		int[] res = find(numCourses, pre);
		for(int i: res ) {
			System.out.println(i);
		}

	}

	private static int[] find(int numCourses, int[][] prerequisites) {

		if(prerequisites == null){
	        throw new IllegalArgumentException("illegal prerequisites array");
	    }
		
		int len = prerequisites.length;
		 
	    //if there is no prerequisites, return a sequence of courses
	    if(len == 0){
	        int[] res = new int[numCourses];
	        for(int m=0; m<numCourses; m++){
	            res[m]=m;
	        }
	        return res;
	    }
	 
	    //records the number of prerequisites each course (0,...,numCourses-1) requires
	    int[] pCounter = new int[numCourses];
	    for(int i=0; i<len; i++){
	        pCounter[prerequisites[i][0]]++;
	    }
	 
	  //stores courses that have no prerequisites
	    LinkedList<Integer> queue = new LinkedList<Integer>();
	    for(int i=0; i<numCourses; i++){
	        if(pCounter[i]==0){
	            queue.add(i);
	        }
	    }
	 
	    int numNoPre = queue.size();
	 
	    //initialize result
	    int[] result = new int[numCourses];
	    int j=0;
	    while(!queue.isEmpty()){
	        int c = queue.remove();
	        result[j++]=c;
	 
	        for(int i=0; i<len; i++){
	            if(prerequisites[i][1]==c){
	                pCounter[prerequisites[i][0]]--;
	                if(pCounter[prerequisites[i][0]]==0){
	                    queue.add(prerequisites[i][0]);
	                    numNoPre++;
	                }
	            }
	 
	        }
	    }
	 
	    //return result
	    if(numNoPre==numCourses){
	        return result;
	    }else{
	        return new int[0];
	    }
	}




}
