package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주사위 굴리기(해결)
 * @author wldud
 *
 */
public class P14499 {

	static int N, M = 0;
	static int x, y = 0;
	static int K = 0;
	static int[][] map = null;
	static int[] route = null;
	static int[] dice = new int[7];
	static int[] dr = { 0, 0, 0, -1, 1 }; 
	static int[] dc = { 0, 1, -1, 0, 0 }; 

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		route = new int[K];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			route[i] = Integer.parseInt(st.nextToken());
		}

		// 1. 주사위 배열 위치 변경  2. 복사
		for(int i=0; i<K; i++) {
			int nx = x+dr[route[i]];
			int ny = y+dc[route[i]];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			x = nx;
			y = ny;
			rollDice(route[i]);
			if(map[nx][ny] == 0) {
				map[nx][ny] = dice[1];
			}
			else {
				dice[1] = map[nx][ny];
				map[nx][ny] = 0;
			}
			
			System.out.println(dice[6]);
		}
//		printDice();

	}
	
	static void rollDice(int dir) {
		int[] temp = new int[7];
		for(int i=1; i<=6; i++) {
			temp[i] = dice[i];
		}
		if(dir == 1) {       // 동
			dice[1] = temp[3];
			dice[2] = temp[2];
			dice[3] = temp[6];
			dice[4] = temp[1];
			dice[5] = temp[5];
			dice[6] = temp[4];
		}
		else if(dir == 2) {  // 서
			dice[1] = temp[4];
			dice[2] = temp[2];
			dice[3] = temp[1];
			dice[4] = temp[6];
			dice[5] = temp[5];
			dice[6] = temp[3];
		}
		else if(dir == 3) {  // 북
			dice[1] = temp[2];
			dice[2] = temp[6];
			dice[3] = temp[3];
			dice[4] = temp[4];
			dice[5] = temp[1];
			dice[6] = temp[5];
		}
		else if(dir == 4) {  // 남
			dice[1] = temp[5];
			dice[2] = temp[1];
			dice[3] = temp[3];
			dice[4] = temp[4];
			dice[5] = temp[6];
			dice[6] = temp[2];
		}
		
//		printDice();
//		System.out.println();
	}

	static void printDice() {
		for(int i=0; i<6; i++) {
			System.out.print(dice[i] + " ");
		}
	}
}
