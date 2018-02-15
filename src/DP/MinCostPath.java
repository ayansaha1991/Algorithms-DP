package DP;

public class MinCostPath {
	
	
	public static void main(String[] args) {
		
		int cost[][]= {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
		
		System.out.println(findMinCostPath(cost, 2, 2));
	}

	private static Integer findMinCostPath(int[][] cost, int m, int n) {

		if (m < 0 || n < 0) {
			return Integer.MAX_VALUE;
		}
		
		if (m == 0 && n == 0) {
			return cost[m][n];
		}
		
		return cost[m][n] + findMin(findMinCostPath(cost, m-1, n),
				findMinCostPath(cost, m, n-1),
				findMinCostPath(cost, m-1, n-1));
	}

	private static int findMin(Integer a, Integer b, Integer c) {
		return Math.min(Math.min(a, b), c);
	}


}
