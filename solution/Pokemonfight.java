package solution;

public class Pokemonfight {
	public long pokemonfight2(long HP, long ACK, long HP2, long ACK2) {
		long res1, res2, res3;
        if(ACK >= HP2 || 2*ACK >= HP2 && ACK2 < HP) {//无法击败
            return -1;
        }
        else if(ACK2 >= HP) {//一回合击败
            return 1;
        }
        else {
        	//计算需要多少回合打赢皮卡丘
            res1 = HP/ACK2;
            if(HP%ACK2 != 0) {//剩余血量也需一回合打死
                res1 = res1 + 1;
            }
            //计算需要多少回合被打到要吃药
            res2 = (HP2-ACK)/ACK;
            if(HP2%ACK == 0) {//如果无法除尽，需要减一，因为能够刚好被打死
                res2 = res2 - 1;
            }
             
            if(res1 < res2 + 1) {//如果不需要吃药，res3为0
                res3 = 0;
            }
            else {//吃药总回合为相差回合数-1（因为吃药是额外一回合）除以 被打到吃药的回合数
            	//
                res3 = (res1 - res2 - 1)/res2;
                if((res1 - res2 - 1)%res2 != 0) {//如果除不尽，需要额外一回合
                    res3 = res3 + 1;
                }
            }
 
            return res1 + res3;
        }
	}
	
	long count = 0;
	public long pokemonfight (long HP, long ACK, long HP2, long ACK2) {
        // write code here
		long maxhealth = HP2;
		//当攻击力大于血量的一半时，不可能打过
		if(ACK > HP2/2) {
			return -1;
		}
		//决定攻击或吃药
		while(HP>0) {
			//每回合先被攻击一次
			HP2 -= ACK;
			if(HP-ACK2<=0) { //剩余血量只差一次攻击
				count++;
				break;
			}
			if(ACK >= HP2){//吃药
				HP2 = maxhealth;
	        	count++;
	        	
	        }
			else if(ACK < HP2) {//攻击				
				HP -= ACK2;								
				count++;
			}
		}
		
        
        return count;
       
    }
}
