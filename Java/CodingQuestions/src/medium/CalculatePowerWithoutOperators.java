package medium;

public class CalculatePowerWithoutOperators {

	public static int power(int b, int e) {
	
		if(e==0) {
			return 1;
		} else if(e==1) {
			return b;
		}
		else {
		
			int result = b;
			int temp = b;
			int i,j;
			for(i=1; i< e; i++) {
				for(j=1;j<b;j++) {//adding result to the result b-1 times, for b = 3, in first iteration 3 will be added to 3 2 times, i.e 3+3+3. 
					result +=temp;
					System.out.println("i = "+i+" j= "+j+" result= "+result);
				}
				temp=result;
			}
			return result;
		}
	}
	
	public static void main(String[] args) {
		power(2, 5);
		System.out.println("\n\n");
		power(3, 5);

	}

}
