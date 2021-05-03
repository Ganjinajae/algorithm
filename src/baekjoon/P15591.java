package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * MooTube (Silver) (½ÇÆÐ)
 * @author wldud
 *
 */
public class P15591 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		List<int[]>[] adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			adj[i] = new ArrayList<>();

		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			adj[p].add(new int[]{q, r});
			adj[q].add(new int[]{p, r});
		}

		int[] answer = new int[Q];
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			boolean[] visited = new boolean[N+1]; 
			visited[v] = true;
			Queue<Integer> q = new LinkedList<>();
			q.add(v);
			int result = 0;
			while(!q.isEmpty()) {
				int node = q.poll();
				for(int[] a : adj[node]) {
					if(!visited[a[0]] && a[1] >=k) {
						visited[a[0]] = true;
						q.add(a[0]);
						result++;
					}
				}
			}
			answer[i] = result;
		}

		for(int i : answer) {
			System.out.println(i);
		}
	}
}
