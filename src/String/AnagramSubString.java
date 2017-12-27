package String;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;


public class AnagramSubString {
	
	private static final int R = 256;

	private static int custHashCode(String str) {
		
		int hash = 0;
		
		char[] value = str.toCharArray();
		for (int i = 0; i < value.length; i++) {
			hash+= value[i];
		}
		
		return hash%R;
	}

	public static void main(String[] args) {
		
		String str = "abca";
		Set<Integer> cnt = new TreeSet<>();
		
		int N = str.length();
		Map<Integer, Integer> map = new HashMap<>(0);
		
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				String current = str.substring(i, j+1);
				Integer custHashCode = custHashCode(current);
				Integer mapEntry = (Integer) ((map.get(custHashCode) == null) ? 1 : (map.get(custHashCode) + 1));
//				System.out.println(current + " : " + custHashCode(current));
				map.put(custHashCode(current), mapEntry);
			}
		}
		
		int result = 0;
		for (Entry<Integer, Integer> key : map.entrySet()) {
			int freq = key.getValue();
	        result += ((freq) * (freq-1))/2;
		}
		System.out.println(result);
		
		/*System.out.println(custHashCode("abbc"));
		System.out.println(custHashCode("cabb"));*/
		
	}

}
