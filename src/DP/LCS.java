package DP;

/**
 * This class solves Longest common subsequence problem
 * @author ab13541
 *
 */
public class LCS {

	public int lcs(char[] firstStr, char[] secondStr, int firstStrLen, int secondStrLen) {
		
		if (firstStrLen == 0 || secondStrLen == 0) {
			return 0;
		}
		
		if (firstStr[firstStrLen - 1] == secondStr[secondStrLen - 1]) {
			return 1 + lcs(firstStr, secondStr, firstStrLen - 1,
					secondStrLen - 1);
		} else {
			return Math.max(
					lcs(firstStr, secondStr, firstStrLen - 1, secondStrLen),
					lcs(firstStr, secondStr, firstStrLen, secondStrLen - 1));
		}
		
	}
	
	public int lcs_dp(char[] str1, char[] str2, int m, int n) {
		
		int lcs[][] = new int[m+1][n+1];
		
		for( int i=0; i<=m ; i++) {
			for( int j=0; j<=n ; j++) {
				
				if (i == 0 || j == 0) {
					lcs[i][j] = 0;
				} else if (str1[i-1] == str2[j-1]) {
					lcs[i][j] = 1 + lcs[i-1][j-1];
				} else {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1] );
				}
			}
		}
		
		return lcs[m][n];
	}
	
	public static void main(String[] args) {
		
		String str1 = "ABCDFHfJJJJJJJJJJJJ";
		String str2 = "ABCJKSDHJJJJJJJJJJJJJ";
		
		char[] str1Array = str1.toCharArray();
		char[] str2Array = str2.toCharArray();
		
		LCS solveLcs = new LCS();
//		System.out.println(solveLcs.lcs(str1Array, str2Array, str1.length(), str2.length()));
		System.out.println(solveLcs.lcs_dp(str1Array, str2Array, str1Array.length, str2Array.length));
	}
}
