package solution;

public class Pokemonfight {
	public long pokemonfight2(long HP, long ACK, long HP2, long ACK2) {
		long res1, res2, res3;
        if(ACK >= HP2 || 2*ACK >= HP2 && ACK2 < HP) {//�޷�����
            return -1;
        }
        else if(ACK2 >= HP) {//һ�غϻ���
            return 1;
        }
        else {
        	//������Ҫ���ٻغϴ�ӮƤ����
            res1 = HP/ACK2;
            if(HP%ACK2 != 0) {//ʣ��Ѫ��Ҳ��һ�غϴ���
                res1 = res1 + 1;
            }
            //������Ҫ���ٻغϱ���Ҫ��ҩ
            res2 = (HP2-ACK)/ACK;
            if(HP2%ACK == 0) {//����޷���������Ҫ��һ����Ϊ�ܹ��պñ�����
                res2 = res2 - 1;
            }
             
            if(res1 < res2 + 1) {//�������Ҫ��ҩ��res3Ϊ0
                res3 = 0;
            }
            else {//��ҩ�ܻغ�Ϊ���غ���-1����Ϊ��ҩ�Ƕ���һ�غϣ����� ���򵽳�ҩ�Ļغ���
            	//
                res3 = (res1 - res2 - 1)/res2;
                if((res1 - res2 - 1)%res2 != 0) {//�������������Ҫ����һ�غ�
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
		//������������Ѫ����һ��ʱ�������ܴ��
		if(ACK > HP2/2) {
			return -1;
		}
		//�����������ҩ
		while(HP>0) {
			//ÿ�غ��ȱ�����һ��
			HP2 -= ACK;
			if(HP-ACK2<=0) { //ʣ��Ѫ��ֻ��һ�ι���
				count++;
				break;
			}
			if(ACK >= HP2){//��ҩ
				HP2 = maxhealth;
	        	count++;
	        	
	        }
			else if(ACK < HP2) {//����				
				HP -= ACK2;								
				count++;
			}
		}
		
        
        return count;
       
    }
}
