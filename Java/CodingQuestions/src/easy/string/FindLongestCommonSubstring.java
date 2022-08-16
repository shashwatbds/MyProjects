package easy.string;

public class FindLongestCommonSubstring {

	public static void main(String[] args) {
		System.out.println(findLongestCommonSubstr("ABCDGH", "ACDGHR",6,6));
	}

	private static int findLongestCommonSubstr(String s1, String s2, int m, int n) {
		int dp[][]=new int[n+1][m+1];
        int max=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    max=Math.max(dp[i][j],max);
                }
            }
        }
        return max;
	}

}
