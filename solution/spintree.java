package solution;

import java.util.Stack;

public class spintree {
	public static int[] solve (int n, int m, int[] l, int[] r, int[] k) {
		/*
		 *  a)��vector<int> kָ����ת�����ڵ���ת = ����ת
 			b)��vector<int> kָ����ת�����ڵ㲻��ת = ��ת
 			c)û�б�vector<int> kָ����ת�����ڵ���ת = ��ת
 			d)û�б�vector<int> kָ����ת�����ڵ㲻��ת = ����ת
		 */
        // write code here
        //new int array to store node by index, ͬʱ ��¼��ת�Ľ��Ĵ���
		//ex:k=3 ��times[3]+1���һ��
        int[] times = new int[n+1];
        for(int v:k){
            times[v]++;
        }
        
        Stack<Integer> stack = new Stack<>();
        //��Ϊ1��push 1 ��stack
        stack.push(1);
        while (!stack.isEmpty()){//���ֹͣloop?:
        	//λ�õ�index��Ҫ-1
            int index = stack.pop()-1;
            //�����ߴ��ڣ�����Ϊ0����push ��Ӧ���� l[index] ��stack
            if(l[index]!=0){
            	//nodeΪl[index]����times�м��븸�׽����ת����
                times[l[index]] += times[index+1];
                stack.push(l[index]);
            }
            //����ұߴ��ڣ�����Ϊ0����push ��Ӧ���� r[index] ��stack
            if(r[index]!=0){
            	//��ֵtimes[�ұ���ֵ]Ϊr[index]����times�м��븸�׽����ת����
                times[r[index]] += times[index+1];
                stack.push(r[index]);
            }
            if(times[index+1]%2!=0){//�������Ϊ��������תһ�Σ�ż���򲻱�
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
