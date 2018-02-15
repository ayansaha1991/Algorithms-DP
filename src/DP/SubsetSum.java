package DP;


public class SubsetSum {

	
	public static void main(String[] args) {
		
		int a[] = {3, 1, 5, 9, 12};
		int N = a.length;
		
		boolean canWe = findPartition(a, N);
	
		System.out.println(canWe);
	}
	

	private static boolean findPartition(int[] a, int n) {

		int sum = 0;

		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		
		if (sum % 2 != 0) {
			return false;
		}
		
		return ifSubsetSum(a, n, sum/2);
		
	}

	private static boolean ifSubsetSum(int[] a, int n, int sum) {

		if (sum == 0) {
			return true;
		}
		
		if (n == 0 && sum != 0) {
			return false;
		}
		
		return ifSubsetSum(a, n-1, sum) || ifSubsetSum(a, n-1, sum-a[n-1]);
	}
}
