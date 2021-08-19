package programmers;

/**
 * 가장 큰 정사각형 찾기
 * @author wldud
 *
 */
public class BiggestSquareFind {

	public int solution(int [][]board) {
        int n = board.length;
        int m = board[0].length;
        int d = n > m ? m : n;
        boolean flag = true;
        
        int c = 0;
    	int r = 0;
        while(d>0) {
        	c = 0;
        	r = 0;
        	while(r+d <= n) {
        		c = 0;
        		while(c+d <= m) {
        			flag = true;
        			for(int i=r; i<r+d; i++) {
        				for(int j=c; j<c+d; j++) {
        					if(board[i][j] == 0) {
        						flag = false;
        						break;
        					}
        				}
        			}
        			c++;
        			if(flag) {
        				break;
        			}
        		}
    			if(flag) {
    				break;
    			}
        		r++;
        	}
        	if(flag) {
        		break;
        	}
        	d--;
        }

        return d*d;
    }
	
	public static void main(String[] args) {
		BiggestSquareFind test = new BiggestSquareFind();
		int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
//		int[][] board = {{0, 0, 1, 1}, {1, 1, 1, 1}};
		int answer = test.solution(board);
		System.out.println(answer);
	}
}
