package VisaInterview;

public class Solution {

	static String[] twins(String[] a, String[] b) {
		
		if (a == null || b == null) {
			return new String[]{"No"};
		}
		
		String[] res;
		
		if (a.length > b.length) {
			res = new String[a.length];
		}else {
			res = new String[b.length];
		}
		
		for (int i=0 ; i < res.length ; i++) { 
			res[i] = "No";
		}
		
		for (int i=0 ; i < res.length ; i++) {
			
			String tempA = a[i];
			String tempB = b[i];
			
			char[] charArrayA = tempA.toCharArray();
			char[] charArrayB = tempB.toCharArray();
			
			for (int j=0 ; j < charArrayA.length-2 ; j++) {
				
				char temp = charArrayA[j];
				charArrayA[i] = charArrayA[i+2];
				charArrayA[i+2] = temp; 
				
				if (charArrayA == charArrayB) {
					res[i] = "Yes";
				} 
			}

			for (int j=1 ; j < charArrayA.length-3 ; j++) {
				
				char temp = charArrayA[j];
				charArrayA[i] = charArrayA[i+2];
				charArrayA[i+2] = temp;
				
				if (charArrayA == charArrayB) {
					res[i] = "Yes";
				}
			}

			
		}
		
		return res;

    }
}
