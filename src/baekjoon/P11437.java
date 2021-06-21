package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * LCA
 * @author wldud
 *
 */
public class P11437 {

	static int[] parents;
	static int[] depths;
	static ArrayList<Integer>[] tree;
	
	public static void dfs(int current, int depth, int parent) {
		depths[current] = depth;
		parents[current] = parent;
		
		for(int nextNode : tree[current]) {
			if(nextNode != parent) {
				dfs(nextNode, depth+1, current);
			}
		}
	}
	
	public static int LCA(int a, int b) {
		int aDepth = depths[a];
		int bDepth = depths[b];
		
		while(aDepth > bDepth) {
			a = parents[a];
			aDepth--;
		}
		while(bDepth > aDepth) {
			b = parents[b];
			bDepth--;
		}
		
		while(a != b) {
			a = parents[a];
			b = parents[b];
		}
		
		return a;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
	
		tree = new ArrayList[N+1];		
		for(int i=1; i<=N; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		parents = new int[N+1];
		depths = new int[N+1];
		Arrays.fill(depths, -1); // ?
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		
		dfs(1, 1, 0); // depth¶û parent ÀúÀå
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int result = LCA(a, b);
			
			System.out.println(result);
		}
	}
}
