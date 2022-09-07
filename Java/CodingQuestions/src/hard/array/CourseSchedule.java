package hard.array;

import java.util.LinkedList;

public class CourseSchedule {

	public static void main(String[] args) {
		
		String[] input = new String[] {"2","1 0"};
		parseInput(input);
		
		String[] input2 = new String[] {"4","1 0","3 1","3 2"};
		parseInput(input2);
		
		String[] input3 = new String[] {"4","1 0","2 0","3 2 1"};
		parseInput(input3);
	}
	
	private static void parseInput(String[] input) {

		int numCourses = Integer.parseInt(input[0]);
		int[][] pre = new int[input.length-1][2];
		for(int i=1; i<input.length; i++) {
			int arrIndex = 0;
			String[] dependencies = input[i].split(" ");
			int[] temp = new int[dependencies.length];
			for(String dependency: dependencies) {
				temp[arrIndex] = Integer.parseInt(dependency);
				arrIndex++;
			}
			pre[i-1] = temp;
		}
		int[] res = findOrder(numCourses, pre);
		printRes(res);
		System.out.println("\n\n");
	}
	
	public static void printRes(int[] res) {
		for(int i: res) {
			System.out.println(i);
		}
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
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
