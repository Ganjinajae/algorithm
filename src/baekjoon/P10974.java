package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 모든 순열
 * @author wldud
 *
 */
public class P10974 {
	
	static List<String> list = new ArrayList<>();
	static boolean[] visited;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		dfs(1, 0, "");
		
		for(int i=0; i<list.size(); i++) {
			String[] s = list.get(i).split("");
			System.out.println(String.join(" ", s));
		}
	}
	
	static void dfs(int idx, int cnt, String s) {
		if(cnt == N) {
			list.add(s);
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i, cnt+1, s+i);
				visited[i] = false;
			}
		}
	}
}
