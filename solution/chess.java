package solution;

public class chess {
	public static String playchess (String[] chessboard) {
        // write code here
		
		int rows = chessboard.length;
		int cols = chessboard[0].length();
		char[][] board = new char[rows][cols];
		//draw chess board 
		for(int i = 0; i<rows; i++) {
			board[i] = chessboard[i].toCharArray();
		}
		//find j position
		int j_row = 0;
		int j_col = 0;
		for(int i =0; i <rows; i++) {
			for(int j = 0; j< cols; j++) {
				if(board[i][j] == 'j') {
					j_row = i;
					j_col = j;
					break;
				}
			}
		}
		
		//是否有将或兵在上下左右
		if((j_row>0 && (board[j_row-1][j_col] =='B' || board[j_row -1][j_col] == 'J')) 
				|| (j_row<rows-1 && (board[j_row+1][j_col] =='B' || board[j_row +1][j_col] == 'J'))
				|| (j_col>0 && (board[j_row][j_col-1] =='B' || board[j_row][j_col-1] == 'J'))
				|| (j_col<cols-1 && (board[j_row][j_col+1] =='B' || board[j_row][j_col+1] == 'J'))){
			return "Happy";
		}
		
		//check 车
		//上
		if(j_row > 0) {
			int i = j_row -1;
			for(;i>=0;i--) {
				if(board[i][j_col] == 'C') {
					return "Happy";
				}
				else if(board[i][j_col] == '.') continue;
				else break;
			}
		}
		//下
		if(j_row<rows-1) {
			int i =j_row + 1;
			for(; i<rows;i++) {
				if(board[i][j_col] == 'C') return "Happy";
				else if(board[i][j_col] == '.') continue;
				else break;
			}
		}
		//左
		if(j_col > 0) {
			int i = j_col - 1;
			for(; i>=0;i--) {
				if(board[j_row][i] == 'C') return "Happy";
				else if(board[j_row][i] == '.') continue;
				else break;
			}
		}
		//右
		if(j_col < cols-1) {
			int i = j_col + 1;
			
			for(; i<cols;i++) {
				
				if(board[j_row][i] == 'C') return "Happy";
				else if(board[j_row][i] == '.') continue;
				else break;
			}
		}
		
		//check 炮
		boolean hasanother = false;
		//上
		if(j_row > 0) {
			int i = j_row -1;
			for(;i>=0;i--) {
				
				if(board[i][j_col] == '.') continue;
				else if(board[i][j_col] != '.' && !hasanother)
					hasanother = true;
				else if(board[i][j_col] != 'P' && hasanother) {
					break;
				}				
				else return "Happy";
			}
		}
		//下
		hasanother = false;
		if(j_row < rows -1) {
			int i = j_row+1;
			for(;i<=rows-1;i++) {
				
				if(board[i][j_col] == '.') continue;
				else if(board[i][j_col] != '.' && !hasanother)
					hasanother = true;
				else if(board[i][j_col] != 'P' && hasanother) {
					break;
				}				
				else return "Happy";
			}
		}
		//左
		hasanother = false;
		if(j_col > 0) {
			int i = j_col-1;
			
			for(;i>=0;i--) {
				
				if(board[j_row][i] == '.') continue;
				else if(board[j_row][i] != '.' && !hasanother) {
					
					hasanother = true;
				}
				else if(board[j_row][i] != 'P' && hasanother) {
					break;
				}				
				else return "Happy";
			}
		}
		//右
		hasanother = false;
		if(j_col < cols -1) {
			int i = j_col+1;
			for(;i<=cols-1;i++) {
				
				if(board[j_row][i] == '.') continue;
				else if(board[j_row][i] != '.' && !hasanother)
					hasanother = true;
				else if(board[j_row][i] != 'P' && hasanother) {
					break;
				}				
				else return "Happy";
			}
		}
		return "Sad";
    }
	
	public static void main(String[] args) {
		String[] test = {"C....j", "......", "......", "......", "......"," ......" };
		System.out.println(playchess(test));
	}
}
