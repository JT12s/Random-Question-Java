package solution;

public class IncreasingArray {
	public static long increasingarray (int[] array) {
        // write code here
        long lastone = array[0];
        long count = 0;
        for(int i =1; i<array.length;i++){
            while(array[i]<=lastone){
                array[i] += 1;
                count++;
                //System.out.println("Heere");
                for(int j = i+1; j<array.length;j++){
                    if(array[j]-array[i]< j-i){
                        array[j] += 1;
                    }
                    else{
                        break;
                    }
                }
            }
            lastone=array[i];
        }
        return count;
    }
	

}
