package DP;

public class UglyNumber {
	
	public static void main(String[] args) {
		
		System.out.println(findNthUgly(150));
	}

	private static int findNthUgly(int n) {

		int next_2s_multiple = 2;
		int next_3s_multiple = 3;
		int next_5s_multiple = 5;
		
		int[] ugly = new int[n];
		ugly[0] = 1;
		
		int i2 = 0, i3 = 0, i5 = 0;
		
		for (int i = 1; i < n; i++) {

			int min = Math.min(next_2s_multiple, Math.min(next_3s_multiple, next_5s_multiple));
			ugly[i] = min;
			
			if (min == next_2s_multiple) {
				i2++;
				next_2s_multiple = ugly[i2]*2;
			}

			if (min == next_3s_multiple) {
				i3++;
				next_3s_multiple = ugly[i3]*3;
			}
		
			if (min == next_5s_multiple) {
				i5++;
				next_5s_multiple = ugly[i5]*5;
			}
		
		}
		
		return ugly[n-1];
		
	}

}
