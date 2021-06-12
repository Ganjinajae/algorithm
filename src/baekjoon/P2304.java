package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 창고 다각형
 * @author wldud
 *
 */
public class P2304 {
	
	static int maxHeight = 0;
	static int maxHeightIdx = -1;
	static int maxIdx = -1;
	static int minIdx = 987654321;
	static int[] pillar;

	public static int right() {
		int h = 0;
		int result = 0;
		for(int i=maxIdx; i>maxHeightIdx; i--) {
			 h = Math.max(h, pillar[i]);
			 result += h;
		}
		
		return result;
	}

	public static int left() {
		int h = 0;
		int result = 0;
		for(int i=minIdx; i<maxHeightIdx; i++) {
			 h = Math.max(h, pillar[i]);
			 result += h;
		}
		
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		pillar = new int[1001];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			pillar[x] = y;
			minIdx = Math.min(x, minIdx);
			maxIdx = Math.max(x, maxIdx);
			if(y > maxHeight) {
				maxHeight = y;
				maxHeightIdx = x;
			}
		}

		int result = pillar[maxHeightIdx] + left() + right();

		System.out.println(result);
	}
}
