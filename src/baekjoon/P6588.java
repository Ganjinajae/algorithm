package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ∞ÒµÂπŸ»Â¿« √ﬂ√¯
 * @author wldud
 *
 */
public class P6588 {

	public static final int MAX = 1000000;
	static boolean[] prime = new boolean[MAX+1];
	static boolean[] check = new boolean[MAX+1];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i=2; i<=MAX; i++) {
			if(!check[i]) {
				check[i] = true;
				prime[i] = true;
				for(int j=i+i; j<=MAX; j+=i) {
					if(check[j]) continue;
					check[j] = true;
				}
			}
		}

		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;

			boolean ok = false;
			
			for(int i=2; i<=n/2; i++) {
				if(prime[i] && prime[n-i]) {
					System.out.println(n + " = " + i + " + " + (n-i));
					ok = true;
					break;
				}
			}
			if(!ok) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}
	}
}

