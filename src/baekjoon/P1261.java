package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 알고스팟
 * @author wldud
 *
 */
public class P1261 {

	static int[][] maze;
	static boolean[][] visited;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	
	static class Point implements Comparable<Point> {
		int r;
		int c;
		int cnt;
		
		Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			return this.cnt-o.cnt;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken()); // 가로
		int N = Integer.parseInt(st.nextToken()); // 세로
		
		maze = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<s.length(); j++) {
				maze[i][j] = s.charAt(j)-'0';
			}
		}
		
		PriorityQueue<Point> q = new PriorityQueue<>();
		q.add(new Point(0, 0, 0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Point position = q.poll();
			int r = position.r;
			int c = position.c;
			int cnt = position.cnt;
			
			if(r==N-1 && c==M-1) {
				System.out.println(position.cnt);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					if(!visited[nr][nc]) {
						visited[nr][nc] = true;
						if(maze[nr][nc] == 1) {
							q.add(new Point(nr, nc, cnt+1));
						}
						else {
							q.add(new Point(nr, nc, cnt));
						}
					}
				}
			}
		}
	}
}


