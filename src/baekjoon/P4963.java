package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * ¼¶ÀÇ °³¼ö
 * @author wldud
 *
 */
public class P4963 {

	public static int[] dr = {1, -1, 0, 0, 1, 1, -1, -1};
	public static int[] dc = {0, 0, 1, -1, 1, -1, 1, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			if(w==0 && h==0) break;

			int[][] map = new int[h][w];  // r,c °³³äÀ¸·Î
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int ans = 0;
			boolean[][] visited = new boolean[h][w];
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(!visited[i][j] && map[i][j]==1) {
						Queue<Position> queue = new LinkedList<>();
						queue.add(new Position(i, j));
						visited[i][j] = true;
						while(!queue.isEmpty()) {
							Position p = queue.poll();
							int r = p.r;
							int c = p.c;

							for(int k=0; k<8; k++) {
								int nr = r+dr[k];
								int nc = c+dc[k];
								if(nr>=0 && nr<h && nc>=0 && nc<w) {
									if(!visited[nr][nc] && map[nr][nc]==1) {
										visited[nr][nc] = true;
										queue.add(new Position(nr, nc));
									}
								}
							}
						}
						ans++;
					}
				}
			}
			System.out.println(ans);
		}

	}
}

class Position {
	int r;
	int c;
	Position(int r, int c) {
		this.r = r;
		this.c = c;
	}

}