package easy.string;

public class FindCharsInStringThatIsRepeatedNTimes {

	public static void main(String[] args) {

		find("Fibonaccci", 3);//c
		find("Fibonaccci", 2);//i
	}

	private static void find(final String string, final int count) {
		int max = 0;
		char maxChar = 0;
		for(int i=0; i<string.toCharArray().length; i++) {
			char c = string.charAt(i);
			int j=i+1;
			int charCount = 1;
			while(j<string.toCharArray().length) {
				if(string.charAt(j) == c) {
					charCount+=1;
				}
				j++;
			}
			if(charCount == count) {
				max = charCount;
				maxChar=c;
				break;
			}
		}
		System.out.println(maxChar+" is a total of "+max+" times in the string "+string);
	}

}
