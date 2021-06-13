package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ºø¹°
 * @author wldud
 *
 */
public class P14719 {

	static int[] block;
	static int maxIdx;
	static int maxValue;
	
	public static int left() {
		int h = 0;
		int result = 0;
		for(int i=0; i<maxIdx; i++) {
			if(block[i] > h) {
				h = block[i];
			}
			result += h-block[i];
		}
		return result;
	}
	
	public static int right() {
		int h = 0;
		int result = 0;
		for(int i=block.length-1; i>maxIdx; i--) {
			if(block[i] > h) {
				h = block[i];
			}
			result += h-block[i];
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
	
		block = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++) {
			block[i] = Integer.parseInt(st.nextToken());
			if(block[i] > maxValue) {
				maxValue = block[i];
				maxIdx = i;
			}
		}
		
		int result = left() + right();
		
		System.out.println(result);
	}
}
