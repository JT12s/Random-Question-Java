package solution;
import java.util.*;
public class maxarea {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] charlist = s.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i =0; i< s.length();i++){
            if(map.get(charlist[i]) == null){
                map.put(charlist[i],1);
            }
        }
        /*
        for(Character c : map.keySet()) {
        	System.out.println(c);
        }
        */
        //System.out.println(charlist.length);
        for(int j =0; j<charlist.length;j++){
        	//System.out.println(j);
        	if(map.get(charlist[j]) == null) {
        		continue;
        	}
        	else if(map.get(charlist[j]) != null || map.get(charlist[j]) >1){
                System.out.print(charlist[j]);
                map.remove(charlist[j]);
            }
            
        }
              
    }
	/*
	 public int maxArea(int[] height) {
	        int h = height.length;
	        int[][] container = new int[h][h];
	    }
	 */
	 public static long[] MaxArea (int n, int[] Stick) {
	        // write code here
		 Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		 long[] vector = new long[2];
		 for(int i =0; i<n;i++) {
			 if(!map.containsKey(Stick[i])) {
				 map.put(Stick[i], 1);
			 }
			 else {
				 map.put(Stick[i], map.get(Stick[i]) + 1);
			 }
		 }
		 for(Map.Entry<Integer, Integer> entry:map.entrySet()) {	
			 if(entry.getValue() == 3) {//Èý½ÇÐÎ
				 vector[0] += (long)entry.getKey()*entry.getKey();
			 }
			 else if(entry.getValue() >= 4) {
				 int i = entry.getValue();
				 int n1 = entry.getKey();
				 while(i / 4 >= 1) {					 					
					 vector[1] += (long)n1*n1;					 
					 i -= 4;
					 if(i == 3) vector[0] += (long)n1*n1;
				 }				 
			 }
		 }				 		 
		 return vector;
	 }
	            
	        
	    
}
