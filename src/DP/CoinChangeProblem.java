package DP;

public class CoinChangeProblem {

	
	
	public static void main(String[] args) {
	
		int[] S = {1, 2, 3};
		long ways = count_dp(S, 3, 10);
		System.out.println(ways);
	}

	private static int count(int[] S, int m, int n) {
		
		if (n == 0) {
			return 1;
		}
		
		if (n < 0) {
			return 0;
		}
		
		if (m <= 0 && n > 0 ) {
			return 0;
		}
						
		return count(S, m-1, n) + count(S, m, n-S[m-1]);
	}
	
	private static int count_dp(int[] S, int m, int n) {
		
		int[] sol = new int[n+1];
		
		sol[0] = 1;
		
		for (int i = 0; i < m; i++) {
			for (int j = S[i]; j <= n; j++) {
				sol[j] = sol[j] + sol[j-S[i]];				
			}
		}		

		return sol[n];
	}

	
}
