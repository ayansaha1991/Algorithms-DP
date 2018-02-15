import java.util.ArrayList;
import java.util.List;

// JAVA Code for Search in a row wise and
// column wise sorted matrix

class Solution {

	static class Interval {
		int buy;
		int sell;
	}
	
	static void getMaxProfitEasys(int[] price, int n) {

		if (n == 1) {
			return;
		}
		
		int count = 0;
		int i = 0;
		
		List<Interval> list = new ArrayList<>();
		
		while (i < n-1) {
			
			while (i < n-1 && price[i+1] <= price[i]) {
				i++;
			}
			
			Interval e = new Interval();
			e.buy = i++;
			
			while (i < n-1 && price[i] > price[i-1]) {
				i++;
			}
			
			e.sell = i++;
			list.add(e);
			
			count++;
			
		}
		
		
		for (Interval in : list) {
			System.out.println(in.buy + " " + in.sell);
		}
		
	}
	
	
	static int getMaxProfit(int price[], int s, int e) {
		if (s >= e)
			return 0;

		int maxProfit = 0;

		for (int i = s; i < e; ++i) {
			for (int j = i + 1; j <= e; ++j) {
				int left = price[j] - price[i];
				int right = getMaxProfit(price, j + 1, e);
				int profit = left + right;
				if (profit > maxProfit) {
					maxProfit = profit;
				}
			}
		}

		return maxProfit;
	}

	static int getMaxProfit(int price[], int n) {
		return getMaxProfit(price, 0, n - 1);
	}

	static int getMaxProfitDp(int price[], int n) {

		int[][] dp = new int[n][n];

		for (int size = 1; size <= n; ++size) {
			for (int i = 0; i <= n - size; ++i) {
				int j = i + size - 1;
				if (i == j) {
					dp[i][j] = 0;
				} else if (i + 1 == j) {
					dp[i][j] = price[j] - price[i];
				} else {
					dp[i][j] = price[j] - price[i];
					for (int k = i + 1; k < j; ++k) {
						dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k + 1][j]);
					}
				}
			}
		}

		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		int profit[] = { 100, 20, 30, 10, 50 };
		int n = profit.length;
		
		getMaxProfitEasys(profit, n);
		
		System.out.println(getMaxProfit(profit, n));
		System.out.println(getMaxProfitDp(profit, n));
	}

}
