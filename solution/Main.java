package solution;

public class Main {
	
	public static void main(String[] args) {
//		int[] l = {4,3,0,0,0};
//		int[] r = {2,0,0,5,0};
//		int[] k = {3,1,5};
//		for(int i : spintree.solve(5,3,l,r,k)) {
//			System.out.print(i);
//		}
		
		
		int[] test = {1,1,1,1,2,2,2,2,2,2,2};
		//System.out.println(Palindrome.isPalindrome(10));
		long[] result = maxarea.MaxArea(11,test);
		for (long l :result) {
			System.out.println(l);
		}
		
	}
}
