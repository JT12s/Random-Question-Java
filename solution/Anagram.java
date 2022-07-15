package solution;

import java.util.HashMap;
import java.util.Map;
//变形词
//两词构造是否相同
public class Anagram {
	public static  boolean isAnagram(String s1,String s2){
		if(s1==null||s2==null||s1.length() != s2.length())
			return false;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i<c1.length; i++) {
			if(map.get(c1[i]) == null) {
				map.put(c1[i], 1);
			}
			else {
				map.put(c1[i], map.get(c1[i])+1);
			}
			
		}
		for(int i = 0; i<c2.length;i++) {
			if(map.get(c2[i]) == null || map.get(c2[i])==0) {
				System.out.println("test");
				return false;
			}else {
				map.put(c2[i], map.get(c2[i]) -1);
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isAnagram("cbas","bcsa"));
	}
}
