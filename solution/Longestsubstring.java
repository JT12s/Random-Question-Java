package solution;
/*
���ӣ�https://www.nowcoder.com/questionTerminal/f0114dbcbf8e4180a4787eb159ee744c?orderByHotValue=1&page=1&onlyReference=false
��Դ��ţ����
*/
import java.util.*;
 //�����ַ���������Ӵ�
public class Longestsubstring{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next(),s2 = sc.next();
        List<String> res = getAns(s1,s2);
        for(String str:res)
            System.out.println(str);
        sc.close();
    }
 
    public static List<String> getAns(String s1,String s2){
    	//��̬�滮 dynamic program
    	//�������п��ܵ�substring
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        //result list of strings
        List<String> res = new ArrayList<>();
        //maxΪ���substring length
        int max = 0;
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                	//����˸�����ȵģ����ڴ˼�һ
                    dp[i][j] = dp[i-1][j-1] + 1;
                    //����˸����max max���ڴ˸�ֵ
                    if(dp[i][j]>=max){
                        max = dp[i][j];
                        //���map��û���������û�б�����
                        if(!map.containsKey(max))
                        	//put���max��map
                            map.put(max,new ArrayList<>());
                        //����˸�index
                        map.get(max).add(i-1);
                    }
                }
            }
        }
        List<Integer> start = map.get(max);
        for(int num:start){//num - substringlength Ϊ��ʼindex num-1Ϊĩβindex	
            res.add(s1.substring(num-max+1,num+1));
        }//sort
        Collections.sort(res);
        return res;
    }
}