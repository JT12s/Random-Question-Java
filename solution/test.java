package solution;

import java.util.ArrayList;
import java.util.List;

public class test {
	
	public static int countSubstrings(String s) {
		if(s==null) return 0;
		if(s.length() == 1) return 1;
		int count = 0;
		List<String> strlist = new ArrayList<String>();
		for(int i = 0; i < s.length(); i++) {
			strlist.add(Character.toString(s.charAt(i)));
			for(int j = i+1; j<s.length();j++){
				//System.out.println(j);
				//System.out.println(s.substring(i,j+1));
				strlist.add(s.substring(i,j+1));
				
			}
		}
		
		for(String str : strlist) {
			//System.out.println(str);
			if(isPalindrome(str)) {
				count++;
			}
		}		
		return count;
	}
	
	public static boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() -1;
		while(i<j) {
			if(s.charAt(i) != s.charAt(j)) {
				
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(countSubstrings(""));
		System.out.println(countSubstrings("a"));
		System.out.println(countSubstrings("abc"));
		System.out.println(countSubstrings("aaa"));
		//System.out.println(countSubstrings("aba"));
	}

}
