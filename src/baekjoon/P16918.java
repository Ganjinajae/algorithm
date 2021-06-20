package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * º½¹ö¸Ç
 * @author wldud
 *
 */
public class P16918 {
	
	static char[][] map;
	static int[][] timeLimit;
	static int R;
	static int C;
	static int N;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void spread(int r, int c) {
		map[r][c] = '.';
		for(int k=0; k<4; k++) {
			int nr = r+dr[k];
			int nc = c+dc[k];
			if(nr>=0 && nc>=0 && nr<R && nc <C) {
				map[nr][nc] = '.';
			}
		}
	}
	
	public static void bomb() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(timeLimit[i][j] == 3) {
					spread(i, j);
				}
			}
		}
	}
	
	public static void plusTime() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 'O') {
					timeLimit[i][j] += 1;
				}
			}
		}
	}
	
	public static void plantBomb() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				map[i][j] = 'O';
			}
		}
	}
	
	public static void clearTime() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == '.') {
					timeLimit[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		timeLimit = new int[R][C];
		
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = s.charAt(j); 
			}
		}
		
		int time = 0;
		while(true) {
			if(time == N) {
				break;
			}
			time++;
			if(time==1) {
				plusTime();
				continue;
			}
			plusTime();
			plantBomb();
			bomb();
			clearTime();
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
