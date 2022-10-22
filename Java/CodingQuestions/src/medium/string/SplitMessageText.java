package medium.string;

import java.util.Arrays;

public class SplitMessageText {

	private static final String PREFIX = "<";
	private static final String SEPERATOR = "/";
	private static final String SUFFIX = ">";
	private static final char SPACE = ' ';


	private static final int MSG_SUFFIX_LEN = 5;

	public static void main(String[] args) {
		String[] msgs = splitMessage("a b c",6);
		Arrays.stream(msgs).forEach(System.out::println);
	}

	private static String[] splitMessage(String string, int maxLenPerMSg) {

		if(maxLenPerMSg < MSG_SUFFIX_LEN) {
			throw new IllegalArgumentException("Max Length per message should atleast be 6");
		}
		int origLength = string.length();
		System.out.println("origLength "+origLength);

		int maxChars = maxLenPerMSg - MSG_SUFFIX_LEN;
		System.out.println("maxChars "+maxChars);

		int numMsgs = origLength/maxChars;
		System.out.println("numMsgs "+numMsgs);

		if(origLength%maxChars !=0) {
			numMsgs+=1;
		}
		String[] msgs = new String[numMsgs];
		char[] arr = string.toCharArray();
		int count=0;
		for(int i=1; i<=origLength; i=i+maxChars) {
			int j=i-1;
			int k =0;
			StringBuilder sb = new StringBuilder();
			while(k<maxChars) {
				if(arr[j]!=SPACE) {
					sb.append(arr[j]);
					j++;
					k++;
					count++;
				} else {
					break;
				}
			}
			sb.append(PREFIX).append(count).append(SEPERATOR).append(numMsgs).append(SUFFIX);
			msgs[i-1] = sb.toString();
			System.out.println(sb.toString());

		}
		return msgs;
	}

}
