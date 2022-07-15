package solution;

public class Wwork {
	
	public int build(int x, int y, int z) {
		int ans = x;
		int[] nums = new int[] {x,y,z,ans};
		if(y==z) {
			return ans;
		}
		int mid = (int)Math.floor((y+z)/2);
		ans = build(x*2,y,mid);
		ans = build(x*2 + 1, mid+1,z);
		return ans;
	}
	/*
	public int[] wwork (int T, int[] a) {
        // write code here
		int x = 1,y = 1;
		int ans = 0;
        for(int i =0; i< a.length;i++) {
        	ans = x;
        	if(y==a[i]) {
        		break;
        	}
        	int mid = (int)Math.floor((y+z)/2);
        	
        }
    }
    */
}
