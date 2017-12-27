package String;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
	

	
	public static void main(String[] args) {
		
		/*String str1 = "abca";
		String str2 = "cbab";
		
		if (str1.length() != str2.length()) {
			System.out.println("No Anagram");
		}
		
		int N = str1.length();
		Map<Character, Integer> map = new HashMap<>(0);
		
		
		for (int i = 0; i < N; i++) {
			char str1_c = str1.charAt(i);
			Integer cnt1 = (map.get(str1_c) == null) ? 1 : (map.get(str1_c) + 1) ;
			map.put(str1_c, cnt1);
		}
		
		for (int i = 0; i < N; i++) {
			char str2_c = str2.charAt(i);
			Integer cnt2 = (map.get(str2_c) == null) ? 0 : (map.get(str2_c) - 1) ;
			map.put(str2_c, cnt2);
		}
		
		System.out.println(map.size());*/
		
		Map<String, Integer> map1 = new HashMap<>();
		map1.put("a", 1);
		Map<String, Integer> map2 = new HashMap<>();
		map2.put("a", 1);
		
		System.out.println(map1.equals(map2) );
	}

}
