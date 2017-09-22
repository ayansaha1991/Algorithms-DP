package DP;

/**
 * This class solves Longest common subsequence problem
 * @author ab13541
 *
 */
public class LCS {

	public int lcs(char[] str1, char[] str2, int m, int n) {
		
		if (m == 0 || n == 0) {
			return 0;
		}
		
		if ( str1[m-1] == str2[n-1]) {
			return 1 + lcs(str1, str2, m-1, n-1);
		} else {
			return Math.max(lcs(str1, str2, m-1, n), lcs(str1, str2, m, n-1));
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
		
		String str1 = "ABCDFHfJKFHSDJKFHSDJKDHKFSDHKFJSDFKSDFHSDKFHSDJKFSFJHDFJDHfjhsdjkadasdsdsdasjfhsdjkfhdsjkfhdjkfhsdjkfhsdjkfhjkfhdjskfhjkdhfjdhfjkFJDSHFDJSHFDJKHSDJKFHDSJFS";
		String str2 = "ABCJKSDHFJADJSADHJSAHDJASHDJKAJFHSDJKFHSDJFHSDJKFHSDJFH";
		
		char[] str1Array = str1.toCharArray();
		char[] str2Array = str2.toCharArray();
		
		LCS solveLcs = new LCS();
		//System.out.println(solveLcs.lcs(str1Array, str2Array, str1.length(), str2.length()));
		System.out.println(solveLcs.lcs_dp(str1Array, str2Array, str1Array.length, str2Array.length));
	}
}
