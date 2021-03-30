package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2225 {
	public static final int MOD = 1000000000;	
	static int N, K;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[N+1][K+1];
        
        for(int i=1; i<=K; i++) {
        	dp[1][i] = i;
        }
        for(int i=1; i<=N; i++) {
        	dp[i][1] = 1;
        }
        
        for(int i=2; i<=N; i++) {
        	for(int j=1; j<=K; j++) {
        		dp[i][j] = (dp[i-1][j] + dp[i][j-1])%MOD;
        	}
        }
        
        System.out.println(dp[N][K]);
    }
}
