package String;

// Java Solution
public class LongestPalinSubstring 
{
	

	public static void main(String[] args) {

		String str = "aaaaaaaaaB";
		System.out.println("Length is: " + 
								longestPalSubstr(str));
	}

	private static String longestPalSubstr(String str) {

		if ( str == null)
			return "";
		
		int N = str.length();
		boolean dp[][] = new boolean[N][N];
		
		int maxLenth = 1;
		int start = 0;
		
		//All single char sub str is palindrom
		for (int i = 0; i < N; i++) {
			dp[i][i] = true;
		}
		
		//2 char sub strs are palindrom if str.charAt(i) == str.charAt(i+1)
		for (int i = 0; i < N-1; i++) {
			if (str.charAt(i) == str.charAt(i+1)) {
				dp[i][i+1] = true;
				maxLenth = 2;
				start = i;
			}
		}
		
		//start from 3 letter substrings
		for (int K = 3; K <= N; K++) {
			
			for (int i = 0; i < N-K+1; i++) {
				
				int j = i+K-1;
				
				if (dp[i+1][j-1] && (str.charAt(i) == str.charAt(j))) {
					dp[i][j] = true;
					
					if (K > maxLenth) {
						maxLenth = K;
						start = i;
					}
				}
				
			}
		}
		System.out.println(maxLenth);
		return str.substring(start, maxLenth);
	}
}

