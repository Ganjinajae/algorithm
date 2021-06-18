package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Åé´Ï¹ÙÄû(2)
 * @author wldud
 *
 */
public class P15662 {

	static int[][] gear;
	static int[][] tempGear;
	static boolean[] same; // °°À¸¸é 1
	static int T;
	static int K;
	
	public static void right(int idx) {
		int temp = gear[idx][gear[idx].length-1];
		for(int i=gear[idx].length-1; i>0; i--) {
			tempGear[idx][i] = gear[idx][i-1];
		}
		tempGear[idx][0] = temp;
	}
	
	public static void left(int idx) {
		int temp = gear[idx][0];
		for(int i=0; i<gear[idx].length-1; i++) {
			tempGear[idx][i] = gear[idx][i+1];
		}
		tempGear[idx][gear[idx].length-1] = temp;
	}
	
	public static void rotate(int idx, int flag) {
		if(flag == 1) {
			right(idx);
		}
		else {
			left(idx);
		}
	}
	
	public static void spread(int gearNum, int direction) {
		int temp = direction;
		for(int i=gearNum; i>0; i--) {
			if(gear[i-1][2] == gear[i][6]) {
				break;
			}
			temp = temp*(-1);
			rotate(i-1, temp);
		}
		temp = direction;
		for(int i=gearNum; i<T-1; i++) {
			if(gear[i+1][6] == gear[i][2]) {
				break;
			}
			temp = temp*(-1);
			rotate(i+1, temp);
		}
	}
	
	public static void doRotate(int gearNum, int direction) {
		if(direction == 1) {
			right(gearNum);
			spread(gearNum, direction);
		}
		else {
			left(gearNum);
			spread(gearNum, direction);
		}
	}
	
	public static void copy() {
		for(int i=0; i<T; i++) {
			for(int j=0; j<8; j++) {
				gear[i][j] = tempGear[i][j];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		gear = new int[T][8];
		tempGear = new int[T][8];
		
		for(int i=0; i<T; i++) {
			String s = br.readLine();
			for(int j=0; j<8; j++) {
				int t = s.charAt(j)-'0';
				gear[i][j] = t;
				tempGear[i][j] = t;
			}
		}
		K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int gearNum = Integer.parseInt(st.nextToken())-1;
			int direction = Integer.parseInt(st.nextToken());
			doRotate(gearNum, direction);
			copy();
		}
		
		int result = 0;
		for(int i=0; i<T; i++) {
			if(gear[i][0] == 1) {
				result++;
			}
		}
		System.out.println(result);
	}
}
