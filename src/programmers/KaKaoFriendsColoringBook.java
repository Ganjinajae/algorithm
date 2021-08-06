package programmers;

import java.util.Arrays;

public class KaKaoFriendsColoringBook {

	int[] dr = {0, 0, 1, -1};
	int[] dc = {1, -1, 0, 0};
	boolean[][] visited;
	int[][] sPicture;
	int temp;
	int sm;
	int sn;

	public static void main(String[] args) {

		KaKaoFriendsColoringBook test = new KaKaoFriendsColoringBook();
		int m = 6;
		int n = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int[] answer = test.solution(m, n, picture);
		System.out.println(Arrays.toString(answer));
	}

	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		int[] answer = new int[2];
		visited = new boolean[m][n];
		sPicture = picture;
		sm = m;
		sn = n;

		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j] && picture[i][j] != 0) {
					dfs(i, j, picture[i][j]);
					numberOfArea++;
					if(temp > maxSizeOfOneArea) {
						maxSizeOfOneArea = temp;
					}
					temp = 0;
				}
			}
		}

		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	public void dfs(int r, int c, int v) {

		temp++;
		visited[r][c] = true;

		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];

			if(nr>=0 && nr<sm && nc>=0 && nc<sn) {
				if(!visited[nr][nc] && sPicture[nr][nc] == v) {
					dfs(nr, nc, v);
				}
			}
		}
	}
}
