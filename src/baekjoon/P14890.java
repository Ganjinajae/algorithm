package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 경사로
 * @author wldud
 *
 */
public class P14890 {
	
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int L;
	
	public static boolean canGo(int r, int c, int d) { // d==0이면 열검사, d=1이면 행검사
		int[] height = new int[N];
		boolean[] visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			height[i] = (d==0) ? map[r][c+i] : map[r+i][c]; 
		}
		
		for(int i=0; i<N-1; i++) {
			if(height[i] == height[i+1]) {
				continue;
			}
			
			if(Math.abs(height[i]-height[i+1]) > 1) {
				return false;
			}
			
			if(height[i] > height[i+1]) {
				for(int j=i+1; j<=i+L; j++) {
					if(j>=N || height[i+1] != height[j] || visited[j]) {
						return false;
					}
					visited[j] = true;
				}
			}
			else if(height[i+1] > height[i]) {
				for(int j=i; j>i-L; j--) {
					if(j<0 || height[i] != height[j] || visited[j]) {
						return false;
					}
					visited[j] = true;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		
		for(int i=0; i<N; i++) {
			if(canGo(i, 0, 0)) {
				count++;
			}
			
			if(canGo(0, i, 1)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
