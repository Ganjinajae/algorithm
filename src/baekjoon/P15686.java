package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 치킨 배달(해결못함)
 * @author wldud
 *
 */
public class P15686 {

	static int[][] arr = null;
	static List<Point> chicken = new ArrayList<>();
	static List<Point> house = new ArrayList<>();
	static boolean[] visited = new boolean[13];
	static int n = 0;
	static int m = 0;
	static int num = 0;
	static int result = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) {
					chicken.add(new Point(i, j));
				}
				else if(arr[i][j] == 1) {
					house.add(new Point(i, j));
				}
			}
		}

		result = Integer.MAX_VALUE;
		dfs(0, 0);
		
		System.out.println(result);

	}
	
	static int distance(Point a, Point b) {
		return Math.abs(a.r - b.r) + Math.abs(a.c - b.c);
	}

	static void dfs(int idx, int selected) {

		if(selected == m) {
			int tempResult = 0;
			for(int i=0; i<house.size(); i++) {
				int dist = Integer.MAX_VALUE;
				for(int j=0; j<chicken.size(); j++) {
					if(visited[j]) {
						dist = Math.min(dist, distance(house.get(i), chicken.get(j)));
					}
				}
				tempResult += dist;
			}
			result = Math.min(result, tempResult);
		}
		
		if(idx == chicken.size()) {
			return;
		}
		
		visited[idx] = true;
		dfs(idx+1, selected+1);
		visited[idx] = false;
		dfs(idx+1, selected);
		
	}
}

class Point {
	int r;
	int c;
	
	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
