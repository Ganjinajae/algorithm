package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 촌수계산(BFS) 학습중..
 * @author wldud
 *
 */
public class P2644 {

	static int n = 0; // 사람의 수
	static int m = 0; // 관계의 개수
	static int[][] node = null;
	static int[] d = null; // start와의 거리
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		node = new int[n+1][n+1];
		d = new int[n+1];
		
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			node[parent][child] = 1;
			node[child][parent] = 1;
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=1; i<=n; i++) {
				if(node[now][i]==0 || d[i]!=0) continue; // 연결되지 않았거나 방문한 경우
				d[i] = d[now]+1;
				q.add(i);
			}
		}
		
		System.out.println(d[end]==0 ? -1 : d[end]);
	}
}
