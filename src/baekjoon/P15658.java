package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ¿¬»êÀÚ ³¢¿ö³Ö±â(2)
 * @author wldud
 *
 */
public class P15658 {

	static int[] num;
	static int[] operator;
	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void dfs(int idx, int result) {
		if(idx == N) {
			if(result > max) {
				max = result;
			}
			if(result < min) {
				min = result;
			}
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(operator[i] != 0) {
				operator[i]--;
				if(i==0) { // + 
					dfs(idx+1, result+num[idx]);
				}
				else if(i==1) { // -
					dfs(idx+1, result-num[idx]);
				}
				else if(i==2) { // °ö¼À
					dfs(idx+1, result*num[idx]);
				}
				else { // ³ª´°¼À
					if(result < 0) {
						int temp = Math.abs(result)/num[idx];
						dfs(idx+1, temp*(-1));
					}
					else {
						dfs(idx+1, result/num[idx]);
					}
				}
				operator[i]++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		operator = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1, num[0]);
		
		System.out.println(max);
		System.out.println(min);
	}
}
