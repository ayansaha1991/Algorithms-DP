package String;

public class Palidrom {
	
	public boolean isPalindrom(String str) {
		
		if (str == null || str.length() == 0) {
			return false;
		}
		
		int l = 0;
		int h = str.length() - 1;
		
		while (l < h) {
			if (str.charAt(l++) != str.charAt(h--)) { 
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isRotatedPalindrom(String str) {
		
		for (int i = 0; i < str.length(); i++) {
			
			String str1 = str.substring(i+1);
			String str2 = str.substring(0, i+1);
			
			if (isPalindrom(str1+str2)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		Palidrom palidrom = new Palidrom();
//		System.out.println(palidrom.isPalindrom("aba"));
		System.out.println(palidrom.isRotatedPalindrom("aaaad"));
	}

}
