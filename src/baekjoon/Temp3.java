package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Temp3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());

		int[][] square = new int[length+1][length+1];
		int[] size = new int[length+1];
		int total = 0;

		for(int i=0; i<length; i++) {
			String[] line = br.readLine().split("");
			for(int j=0; j<length; j++) {
				square[i][j] = Integer.parseInt(line[j]);
				if(square[i][j] == 1) {
					size[1]++;
					total++;
				}
			}
		}

		for(int k=2; k<=length; k++) {
			for(int i=0; i<length; i++) {
				for(int j=0; j<length; j++) {
					if((i+k <= length) && (j+k <= length)) {
						if(isPossible(i, j, k, square)) {
							size[k]++;
							total++;
						}
					}
				}
			}
		}

		System.out.println("total: " + total);
		for(int i=1; i<=length; i++) {
			if(size[i]!=0) {
				System.out.println("size[" + i + "]: " + size[i]);
			}
		}
	}

	public static boolean isPossible(int r, int c, int n, int[][] square) {

		for(int i=r; i<r+n; i++) {
			for(int j=c; j<c+n; j++) {
				if(square[i][j] == 0) {
					return false;
				}
			}
		}

		return true;
	}
}
