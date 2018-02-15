package String;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramSubString {
    
    static int custHashCode(String str) {
		
		int hash = 0;
		
		char[] value = str.toCharArray();
		for (int i = 0; i < value.length; i++) {
			hash+= value[i];
		}
		
		return hash%256;
	}

    static int sherlockAndAnagrams(String s){
      
        int N = s.length();
		Map<Integer, Integer> map = new HashMap<>(0);
		
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				String current = s.substring(i, j+1);
				Integer custHashCode = custHashCode(current);
				Integer mapEntry = (Integer) ((map.get(custHashCode) == null) ? 1 : (map.get(custHashCode) + 1));
				map.put(custHashCode(current), mapEntry);
			}
		}
		
		int result = 0;
		for (Integer key : map.keySet()) {
			int freq = map.get(key);
	        result += ((freq) * (freq-1))/2;
		}
		System.out.println(result);
        
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }
    }
}
