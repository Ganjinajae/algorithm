package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14500 {
	static int[][] paper;
	static boolean[][] visited;
	static int max = 0;
	static int N; 
	static int M;
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void dfs(int r, int c, int cnt, int sum) {
		if(cnt == 4) {
			if(sum > max) {
				max = sum;
			}
			return;
		}
		visited[r][c] = true;
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M) {
				if(!visited[nr][nc]) {
					dfs(nr, nc, cnt+1, sum+paper[nr][nc]);
				}
			}
		}
		visited[r][c] = false;
	}
	
	public static void exception(int r, int c) {
		
		int min = 987654321;
		int sum = paper[r][c];
		int wing = 4;
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];

			if(wing <= 2) {
				return;
			}
			if(nr>=0 && nr<N && nc>=0 && nc<M) {
				sum += paper[nr][nc];
				min = Math.min(min, paper[nr][nc]);
			}
			else {
				wing--;
			}
		}
		
		if(wing == 4) {
			sum = sum-min;
		}
		
		max = Math.max(max, sum);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		paper = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				dfs(i, j, 0, 0);
				exception(i, j);
			}
		}
		
		System.out.println(max);
	}
}
