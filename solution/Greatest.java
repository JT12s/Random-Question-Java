package solution;

import java.util.Scanner;

public class Greatest {
	
	
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        //System.out.println(sc.nextLine());
        //String[] grades = sc.nextLine().split(" ");
        
        int[] gradesint = new int[N];
        for(int i =0; i<N; i++) {
        	gradesint[i] = sc.nextInt();
        }
       // System.out.println();
        for(int i=0; sc.hasNext() && i< M; i++) {        	
        	String c = sc.next();
        	//System.out.println(c);
        	//System.out.println(i);
        	//System.out.println(sc.hasNext());
        	if(c.equals("Q")) {
        		int n1 = sc.nextInt();
        		int n2 = sc.nextInt();
        		q(n1,n2,gradesint);        		        		       		
        	}
        	else if(c.equals("U")) {
        		int n1 = sc.nextInt();
        		int n2 = sc.nextInt();
        		gradesint = u(n1,n2,gradesint);
        		
        	}
        	//System.out.println(sc.hasNext());
        }
        
        //sc.close();
        
    }
	
	public static void q(int n1, int n2, int[] nums) {
		int max = 0;
		for(int i =n1-1; i < n2; i++) {
			if(max < nums[i]) {
				max = nums[i];
			}
		}
		System.out.println(max);
	}
	public static int[] u(int n1, int n2, int[] nums) {
		
		nums[n1-1] = n2;
		return nums;
	}
}
