package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 소수의 연속합
 * @author wldud
 *
 */
public class P1644 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		boolean[] e = new boolean[n+1];
		for(int i=2; i*i<=n; i++) {
			if(!e[i]) {
				for(int j=i+i; j<=n; j+=i) {
					e[j] = true;
				}
			}
		}
		
		List<Integer> prime = new ArrayList<>();
		for(int i=2; i<=n; i++) {
			if(!e[i]) {
				prime.add(i);
			}
		}
		
		int answer = 0;
		int left = 0;
		int right = 0;
		int sum = 0;
		int m = prime.size();
		while(left < m) {
			if(sum == n) {
				answer++;
				sum -= prime.get(left++);
			}
			else if(sum < n && right < m) {
				sum += prime.get(right++);
			}
			else {
				sum -= prime.get(left++);
			}
		}
		
		System.out.println(answer);
	}
}
