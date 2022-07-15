package solution;

public class Palindrome {
	//数字是否为变形数
	public static boolean isPalindrome(int x) {
		/*转化为string
		String str = Integer.toString(x);
        int left = 0;
        int right = str.length() - 1;
        while(left<right){
        	//System.out.println(str.charAt(left));
            if(str.charAt(left) != (str.charAt(right))){
            	return false;
            }
            left++;
            right--;
        }
        return true;
        */
		if(x<0) return false;
		int num = x;
		int len = 1;
		while(num >=10) {
			num /= 10;
			len++;
		}
		
		int cplen = len;
		int[] numarray = new int[len];
		for(int i = len-1; i >=0; i--) {
			numarray[i] = x % 10;
			x = x / 10;
			System.out.println(numarray[i]);
		}
		
		int left= 0;
		int right = cplen -1;
		while (left < right) {
			//System.out.println(numarray[left]);
			if(numarray[left] != numarray[right]) return false;
			left++;
			right--;
		}
		return true;
		
		/*
		if (x < 0) {
            return false;
        }
        int temp = x;
        int reverse = 0;
        while(temp != 0 ){
            reverse = reverse* 10+ temp % 10;
            temp = temp/10;
        }
        return reverse == x;
        */
	}
}
