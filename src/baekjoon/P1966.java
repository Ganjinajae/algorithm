package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 프린터 큐
 * @author wldud
 *
 */
public class P1966 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int t = Integer.parseInt(br.readLine());
		while(t>0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int ans = 0;
			Queue<Integer> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			while(true) {
				int num = q.poll();
				
				if(!isTopPriorityNum(num, q)) {
					q.add(num);
				}
				else {
					ans++;

					if(M == 0) {
						break;
					}
				}
				M--;
				if(M < 0) {
					M = q.size()-1; // index 옮기기
				}
			}
			System.out.println(ans);
			t--;
		}
	}
	
	public static boolean isTopPriorityNum(int num, Queue<Integer> q) {
		boolean result = true;
		
		for(int n : q) {
			if(n > num) {
				result = false;
			}
		}
		
		return result;
	}
}
