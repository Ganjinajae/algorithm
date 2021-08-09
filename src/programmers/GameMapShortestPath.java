package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 게임 맵 최단거리
 * @author wldud
 *
 */
public class GameMapShortestPath {
	
	int[] dr = {1, -1, 0, 0};
	int[] dc = {0, 0, -1, 1};
	int[][] d;

	public static void main(String[] args) {
		
		GameMapShortestPath test = new GameMapShortestPath();
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		int answer = test.solution(maps);
		System.out.println(answer);
	}
	
	public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        d = new int[n][m];
        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        d[0][0] = 1;
        while(!q.isEmpty()) {
        	Point p = q.poll();
        	int r = p.r;
        	int c = p.c;
        	for(int i=0; i<4; i++) {
        		int nr = r+dr[i];
        		int nc = c+dc[i];
        		
        		if(nr>=0 && nr<n && nc>=0 && nc<m) {
        			if(maps[nr][nc] == 1 && d[nr][nc] == 0) {
        				d[nr][nc] = d[r][c]+1;
        				q.add(new Point(nr, nc));
        			}
        		}
        	}
        }
        
        return d[n-1][m-1] == 0 ? -1 : d[n-1][m-1];
    }
	
	class Point {
		int r;
		int c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
