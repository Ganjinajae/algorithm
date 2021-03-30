package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연구소 정확히 해결못함(가지치기에 대해 좀 알 것)
 * @author wldud
 *
 */
public class P14502 {

	static int n, m;
	static int[][] arr = null;
	static int[][] tempArr = null;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int result = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		tempArr = new int[n][m];

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				tempArr[i][j] = arr[i][j];
			}
		}

		dfs(0, 0);

		System.out.println(result);
	}

	static void dfs(int start, int num) {

		if(num == 3) {

			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					tempArr[i][j] = arr[i][j];
				}
			}

			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(tempArr[i][j] == 2) {
						dfs2(i, j);
					}
				}
			}

			int count = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(tempArr[i][j] == 0) {
						count++;
					}
				}
			}

			result = Math.max(result, count);
			return;
		}

		for(int i=start; i<n*m; i++) {
			int r = i/m;
			int c = i%m;
			if(arr[r][c] == 0) {
				arr[r][c] = 1;
				dfs(i+1, num+1);
				arr[r][c] = 0;
			}
		}
	}

	static void dfs2(int r, int c) {

		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];

			if(nr>=0 && nr<n && nc>=0 && nc<m) {
				if(tempArr[nr][nc] == 0) {
					tempArr[nr][nc] = 2;
					dfs2(nr, nc);
				}
			}
		}
	}
}
