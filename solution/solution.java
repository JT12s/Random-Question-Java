package solution;

import java.util.*;


public class solution {
    /**
     * 
     * @param presentVolumn int整型二维数组 N*M的矩阵，每个元素是这个地板砖上的礼物体积
     * @return int整型
     */
	public static int min(int x, int y, int z){
        return Math.min(x, Math.min(y,z));
    }
    public static int selectPresent (int[][] presentVolumn) {
        // write code here
        if(presentVolumn.length == 0)return 0;
        int M = presentVolumn[0].length;
        int N = presentVolumn.length;
        
        int[][] p2 = presentVolumn.clone();
        
        
        for(int i =1; i<N;i++){
            p2[i][0] = p2[i][0]+p2[i-1][0];
        }
        for(int i =1; i<M; i++){
            p2[0][i] = p2[0][i]+p2[0][i-1];
        }
        for(int i =1; i<N; i++){
            for(int j = 1;j<M; j++){
                p2[i][j] = min((p2[i][j]+p2[i-1][j]),(p2[i][j]+p2[i][j-1]),(p2[i][j]+p2[i-1][j-1]));
            }
        }

        return p2[N-1][M-1];
    }
    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        double result = 0;
        int totallength = n + m;//查看总长度是否为偶数
        if(totallength%2==1){//奇数
            int index = totallength/2;           
            int count = 0;
            int i1 = 0; int i2 =0;
            while(index+1 > count){
            	
                if(nums1[i1]<=nums2[i2]){ 
                    //加count                  
                    count++;
                    //如果count到达中位数的位置，提取nums[i1]的数字
                    if(count == index+1){
                        result = nums1[i1];
                        break;
                    }
                    //如果没有达到，i1加1
                    i1++;                
                }
                else{
                    count++;
                    if(count == index+1){
                        result = nums2[i2];
                        break;
                    }
                    i2++;
                }
            }
        }
        else{//偶数
            int index = totallength/2 - 1;
            int count = 0;
            int i1 = 0; int i2 =0;
            while(index+1 > count){
            	
                if(nums1[i1]<=nums2[i2]){ 
                    //加count                  
                    count++;
                    //如果count到达中位数的位置，提取nums[i1]的数字
                    if(count == index+1){
                        //查看第二个数在nums1 和 nums2 之中谁更大
                    	if(i1+1<=m-1){
                            if(nums1[i1+1] <= nums2[i2]){
                                result = (nums1[i1] + nums1[i1+1]) / 2;
                            }
                            else{
                                result = (nums1[i1] + nums2[i2]) / 2;
                            }
                        }
                        else{
                        	System.out.print("test");
                            result = (nums1[i1] + nums2[i2]) / 2.0;
                            System.out.println();
                        }
                        break;
                    }
                    //如果没有达到，i1加1
                    i1++;                
                }
                else{
                    count++;
                    if(count == index+1){
                        //查看第二个数在nums1 和 nums2 之中谁更大
                        if(nums2[i2+1] <= nums1[i1]){
                            result = (nums2[i2] + nums2[i2+1]) / 2;
                        }
                        else{
                            result = (nums2[i2] + nums1[i1]) / 2;
                        }
                        break;
                    }
                    i2++;
                }
            }
        }
        return result;
    }
    public class TreeNode {
    	      int val;
    	      TreeNode left;
    	      TreeNode right;
    	      TreeNode(int x) { val = x; }
    	  }
    
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
         if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;

    }
    public static void main(String[] args) {
    	int[][] test = {{1,2,3},{2,3,4},{3,4,5}};
    	//System.out.println(selectPresent(test));
    	int a=5;
    	a+=a*=a%=3;
    	//System.out.println(a);
    	
    	int[] test1 = {1,2};
    	int[] test2 = {3,4};
    	System.out.println(findMedianSortedArrays(test1,test2));
    	
    }
}