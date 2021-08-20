package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수들의 합
 * @author wldud
 *
 */
public class P2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] numbers = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		int sum = 0;
		int answer = 0;
		while(true) {
			if(left == n) {
				break;
			}
			if(sum == m) {
				answer++;
				sum -= numbers[left++];
			}
			else if(sum < m && right < n) {
				sum += numbers[right++];
			}
			else {
				sum -= numbers[left++];
			}
		}
		System.out.println(answer);
	}
}
