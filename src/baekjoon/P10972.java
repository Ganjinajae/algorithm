package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 다음 순열
 * @author wldud
 *
 */
public class P10972 {

	public static int N;
	public static boolean[] visited;
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] num = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			int t = Integer.parseInt(st.nextToken());
			num[i] = t;
		}
		
		int isLast = num.length-1;
		while(isLast>0 && num[isLast-1]>=num[isLast]) {
			isLast--;
		}
		
		if(isLast<=1) {
			System.out.println(-1);
			return;
		}
		
		
		int idx = 0;
		for(int i=1; i<=N; i++) {
			if(num[i] > num[i-1]) {
				idx = i;
			}
		}
		
		int idx2 = 0;
		for(int i=idx; i<=N; i++) {
			if(num[i] > num[idx-1]) {
				idx2 = i;
			}
		}
		
		swap(num, idx-1, idx2);
		
		idx2 = num.length;
		while(idx < idx2) {
			swap(num, idx, idx2);
			idx++;
			idx2--;
		}
		
		for(int i=1; i<=N; i++) {
			System.out.print(num[i] + " ");
		}
	}
}
