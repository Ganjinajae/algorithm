package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * µî±·±æ
 * @author wldud
 *
 */
public class RoadToSchool {

	public static void main(String[] args) {
		RoadToSchool test = new RoadToSchool();
		int m = 3;
		int n = 4;
		int[][] puddles = {{2, 2}};
		int answer = test.solution(m, n, puddles);
		System.out.println(answer);
	}
	
	public int solution(int m, int n, int[][] puddles) {
        int[][] d = new int[m+1][n+1];
        
        for(int i=0; i<puddles.length; i++) {
        	d[puddles[i][0]][puddles[i][1]] = -1;
        }
        
        d[0][1] = 1;
        for(int i=1; i<=m; i++) {
        	for(int j=1; j<=n; j++) {
        		if(d[i][j] == -1) {
        			d[i][j] = 0;
        		}
        		else {
        			d[i][j] = (d[i-1][j] + d[i][j-1])%1000000007;
        		}
        	}
        }
        
        
        return d[m][n];
    }
}
