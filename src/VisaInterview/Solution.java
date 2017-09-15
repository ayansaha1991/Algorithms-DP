package VisaInterview;
import java.util.Scanner;

public class Solution {

    static String super_reduced_string(String s){
		
    	for (int i=0 ; i < s.length()-1; i++) {
    		
    		if (s.charAt(i) == s.charAt(i+1)) {
    			String temp = s.substring(i, i+2);
    			s = s.replaceFirst(temp, "");
    			
    			if (  super_reduced_string(s).equals(s) ) {
        			return s;
        		} 
    		}
    	}
    	return s;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
