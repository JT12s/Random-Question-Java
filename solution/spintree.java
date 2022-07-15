package solution;

import java.util.Stack;

public class spintree {
	public static int[] solve (int n, int m, int[] l, int[] r, int[] k) {
		/*
		 *  a)被vector<int> k指名旋转，父节点旋转 = 不旋转
 			b)被vector<int> k指名旋转，父节点不旋转 = 旋转
 			c)没有被vector<int> k指名旋转，父节点旋转 = 旋转
 			d)没有被vector<int> k指名旋转，父节点不旋转 = 不旋转
		 */
        // write code here
        //new int array to store node by index, 同时 记录旋转的结点的次数
		//ex:k=3 则times[3]+1变成一次
        int[] times = new int[n+1];
        for(int v:k){
            times[v]++;
        }
        
        Stack<Integer> stack = new Stack<>();
        //根为1，push 1 到stack
        stack.push(1);
        while (!stack.isEmpty()){//如何停止loop?:
        	//位置到index需要-1
            int index = stack.pop()-1;
            //如果左边存在（即不为0），push 相应数字 l[index] 到stack
            if(l[index]!=0){
            	//node为l[index]，在times中加入父亲结点旋转次数
                times[l[index]] += times[index+1];
                stack.push(l[index]);
            }
            //如果右边存在（即不为0），push 相应数字 r[index] 到stack
            if(r[index]!=0){
            	//赋值times[右边数值]为r[index]，在times中加入父亲结点旋转次数
                times[r[index]] += times[index+1];
                stack.push(r[index]);
            }
            if(times[index+1]%2!=0){//如果次数为奇数，旋转一次，偶数则不变
                int temp = l[index];
                l[index] = r[index];
                r[index] = temp;
            }
        }
        int[] res = new int[n];
        boolean[] visit = new boolean[n+1];
        stack.push(1);
        int index = 0;
        while (!stack.isEmpty()){
            int root = stack.peek();
            if(!visit[root]&&l[root-1]!=0){
                stack.push(l[root-1]);
                visit[root] = true;
                continue;
            }
            stack.pop();
            res[index++] = root;
            if(r[root-1]!=0){
                stack.push(r[root-1]);
            }
        }
        return res;
    }
}
