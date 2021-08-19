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
        int max = 0;
        
        if(n<=1 || m<=1) return 1;
        
        for(int i=1; i<n; i++) {
        	for(int j=1; j<m; j++) {
        		if(board[i][j] >= 1) {
        			int up = board[i-1][j];
        			int left = board[i][j-1];
        			int upperLeft = board[i-1][j-1];
        			int min = Math.min(up, left);
        			min = Math.min(min, upperLeft);
        			
        			board[i][j] = min+1;
        			max = Math.max(max, board[i][j]); 
        		}
        	}
        }
        
        return max*max;
    }
	
	public static void main(String[] args) {
		BiggestSquareFind test = new BiggestSquareFind();
		int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
//		int[][] board = {{0, 0, 1, 1}, {1, 1, 1, 1}};
		int answer = test.solution(board);
		System.out.println(answer);
	}
}
