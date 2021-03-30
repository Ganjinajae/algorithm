package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 드래곤 커브(해결못함)
 * @author wldud
 *
 */
public class P15685 {

	static int n = 0;
	static int x = 0;
	static int y = 0;
	static int d = 0;
	static int g = 0;
	static int[][] arr = new int[101][101];
	static List<Integer> dir = new ArrayList<>();
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());

			arr[x][y] = 1;
			dir.clear();
			dir.add(d);
			makeDirection();
			makeDragon();
		}
		
		countSquare();
		System.out.println(cnt);
	}
	
	static void makeDirection() {
		
		while(g-- > 0) {
			for(int i=dir.size()-1; i>=0; i--) {
//				System.out.println((dir.get(i)+1)%4);
				dir.add((dir.get(i)+1)%4);
			}
		}
	}
	
	static void makeDragon() {
		for(int i=0; i<dir.size(); i++) {
//			System.out.println(dir.get(i));
			x = x+dx[dir.get(i)];
			y = y+dy[dir.get(i)];
//			System.out.println("(" + x + ", " + y + ")");
			arr[x][y] = 1;
		}
	}
	
	static void countSquare() {
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(arr[i][j] > 0 && arr[i][j+1] > 0 && arr[i+1][j] > 0 && arr[i+1][j+1] > 0) {
					cnt++;
				}
			}
		}
	}
}
