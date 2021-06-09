package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 소수 찾기
 * @author wldud
 *
 */
public class P1978 {
	
	public static boolean isPrime(int n) {
		if(n<=1) return false;
		for(int i=2; i*i<=n; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String[] arr = br.readLine().split(" ");
		
		int cnt = 0;
		for(int i=0; i<arr.length; i++) {
			if(isPrime(Integer.parseInt(arr[i]))) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
