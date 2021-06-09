package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * GCD гу
 * @author wldud
 *
 */
public class P9613 {
	
	public static int gcd(int a, int b) {
		while(b!=0) {
			int r = a%b;
			a = b;
			b = r;
		}
		
		return a;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			String s = br.readLine();
			String[] tArr = s.split(" ");
			int n = Integer.parseInt(tArr[0]);
			int[] arr = new int[n];
			int idx = 0;
			for(int i=1; i<tArr.length; i++) {
				arr[idx++] = Integer.parseInt(tArr[i]);
			}
			
			long result = 0;
			for(int i=0; i<arr.length-1; i++) {
				for(int j=i+1; j<arr.length; j++) {
					result += gcd(arr[i], arr[j]);
				}
			}
			System.out.println(result);
		}		
	}
}
