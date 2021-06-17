package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 외판원 순회2
 * @author wldud
 *
 */
public class P10971 {

	static int[][] map;
	static List<String> arr = new ArrayList<>();
	static int N;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	static void dfs(int cnt, String result) {
		if(cnt == N) {
			arr.add(result);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(cnt+1, result+i);
				visited[i] = false;
			}
		}
	}
	
	static void cost(String s) {
		int sum = 0;
		int start = 0;
		int end = 0;
		for(int i=0; i<s.length()-1; i++) {
			start = s.charAt(i)-'0';
			end = s.charAt(i+1)-'0';
			if(map[start][end] == 0) return;
			sum += map[start][end];
		}
		start = s.charAt(s.length()-1)-'0';
		end = s.charAt(0)-'0';
		if(map[start][end] == 0) return;
		sum += map[start][end];
		if(sum < min) {
			min = sum;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, "");
		
		for(int i=0; i<arr.size(); i++) {
			cost(arr.get(i));
		}
		System.out.println(min);
	}
}
