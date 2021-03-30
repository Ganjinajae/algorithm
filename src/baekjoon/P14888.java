package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연산자 끼워넣기(해결)
 * @author wldud
 *
 */
public class P14888 {

	static int n = 0;
	static int[] arr = null;
	static int[] operator = null;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		operator = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1, arr[0]); // 갯수

		System.out.println(max);
		System.out.println(min);
		
	}
	
	static void dfs(int idx, int result) {
		if(idx == n) {
			if(result > max) {
				max = result;
			}
			if(result < min) {
				min = result;
			}
		}
		
		if(operator[0] > 0) {
			operator[0]--;
			dfs(idx+1, result+arr[idx]);
			operator[0]++;
		}
		if(operator[1] > 0) {
			operator[1]--;
			dfs(idx+1, result-arr[idx]);
			operator[1]++;
		}
		if(operator[2] > 0) {
			operator[2]--;
			dfs(idx+1, result*arr[idx]);
			operator[2]++;
		}
		if(operator[3] > 0) {
			operator[3]--;
			if(result < 0) {
				int tempResult = result*(-1);
				tempResult = tempResult/arr[idx];
				tempResult = tempResult*(-1);
				dfs(idx+1, tempResult);
			}
			else {
				dfs(idx+1, result/arr[idx]);
			}
			operator[3]++;
		}
	}
}
