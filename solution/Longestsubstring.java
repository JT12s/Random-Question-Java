package solution;
/*
链接：https://www.nowcoder.com/questionTerminal/f0114dbcbf8e4180a4787eb159ee744c?orderByHotValue=1&page=1&onlyReference=false
来源：牛客网
*/
import java.util.*;
 //查找字符串最长公共子串
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
    	//动态规划 dynamic program
    	//储存所有可能的substring
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        //result list of strings
        List<String> res = new ArrayList<>();
        //max为最大substring length
        int max = 0;
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                	//如果此格是相等的，则在此加一
                    dp[i][j] = dp[i-1][j-1] + 1;
                    //如果此格大于max max等于此格值
                    if(dp[i][j]>=max){
                        max = dp[i][j];
                        //如果map中没有这个数（没有比他大）
                        if(!map.containsKey(max))
                        	//put这个max进map
                            map.put(max,new ArrayList<>());
                        //加入此格index
                        map.get(max).add(i-1);
                    }
                }
            }
        }
        List<Integer> start = map.get(max);
        for(int num:start){//num - substringlength 为起始index num-1为末尾index	
            res.add(s1.substring(num-max+1,num+1));
        }//sort
        Collections.sort(res);
        return res;
    }
}