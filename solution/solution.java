package solution;

import java.util.*;


public class solution {
    /**
     * 
     * @param presentVolumn int���Ͷ�ά���� N*M�ľ���ÿ��Ԫ��������ذ�ש�ϵ��������
     * @return int����
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
        int totallength = n + m;//�鿴�ܳ����Ƿ�Ϊż��
        if(totallength%2==1){//����
            int index = totallength/2;           
            int count = 0;
            int i1 = 0; int i2 =0;
            while(index+1 > count){
            	
                if(nums1[i1]<=nums2[i2]){ 
                    //��count                  
                    count++;
                    //���count������λ����λ�ã���ȡnums[i1]������
                    if(count == index+1){
                        result = nums1[i1];
                        break;
                    }
                    //���û�дﵽ��i1��1
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
        else{//ż��
            int index = totallength/2 - 1;
            int count = 0;
            int i1 = 0; int i2 =0;
            while(index+1 > count){
            	
                if(nums1[i1]<=nums2[i2]){ 
                    //��count                  
                    count++;
                    //���count������λ����λ�ã���ȡnums[i1]������
                    if(count == index+1){
                        //�鿴�ڶ�������nums1 �� nums2 ֮��˭����
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
                    //���û�дﵽ��i1��1
                    i1++;                
                }
                else{
                    count++;
                    if(count == index+1){
                        //�鿴�ڶ�������nums1 �� nums2 ֮��˭����
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