package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 스타트와 링크(해결)
 * comment: List로 해결하는 방법 말고도 visited를 써서 해결할 수 있음
 * @author wldud
 *
 */
public class P14889 {

	static int N = 0;
	static int[][] ability = null;
	static List<Integer> start = null;
	static List<Integer> link = null;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		ability = new int[N][N];
		start = new ArrayList<>();
		link = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(min);
	}
	
	static void dfs(int idx, int n) {
		if(n == N/2) {
			link = new ArrayList<>();
			for(int i=0; i<N; i++) {
				link.add(i);
			}
			for(int i=0; i<start.size(); i++) {
				link.remove(Integer.valueOf(start.get(i)));
			}
			
			int startAbility = calAbility(start);
			int linkAbility = calAbility(link);
			
			int diff = startAbility - linkAbility;
			if(diff < 0) diff = diff*(-1);
			if(diff < min) {
				min = diff;
			}
			
			return;
		}
		
		for(int i=idx; i<N; i++) {
			start.add(i);
			dfs(i+1, n+1);
			start.remove(Integer.valueOf(i));
		}
	}
	
	static int calAbility(List<Integer> team) {
		int power = 0;
		for(int i=0; i<team.size(); i++) {
			for(int j=0; j<team.size(); j++) {
				int r = team.get(i);
				int c = team.get(j);
				power += ability[r][c];
			}
		}
		
		return power;
	}
}
