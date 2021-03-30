package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 이차원 배열과 연산 (blog 참고함)
 * @author wldud
 *
 */
public class P17140 {

	static int r, c, k = 0;
	static int[][] arr = null; //
	static int[] cntArr = null;
	static List<Number> numList = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[4][4];
		for(int i=1; i<=3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int t = 0;
		while(t <= 100) {
			
			if(arr.length > r && arr[0].length > c) {
				if(arr[r][c] == k) {
					System.out.println(t);
					return;
				}
			}
			
			if(arr.length >= arr[0].length) {
				rOperation();
			}
			else {
				cOperation();
			}
			
			t++;
		}

		System.out.println(-1);
	}

	static void rOperation() {
		int max = Integer.MIN_VALUE;
		int[][] temp = new int[101][101];

		for(int i=1; i<arr.length; i++) {
			cntArr = new int[101];
			numList = new ArrayList<>();
			for(int j=1; j<arr[0].length; j++) {
				if(arr[i][j] != 0) {
					cntArr[arr[i][j]]++;
				}
			}

			for(int j=1; j<=100; j++) {
				if(cntArr[j] != 0) {
					numList.add(new Number(j, cntArr[j]));
				}
			}

			Collections.sort(numList, new Comparator<Number>() {
				@Override
				public int compare(Number o1, Number o2) {
					if(o1.cnt == o2.cnt) {
						return Integer.compare(o1.n, o2.n);
					}
					return Integer.compare(o1.cnt, o2.cnt);
				}
			});

			int z = 1;
			for(int j=0; j<numList.size(); j++) {
				temp[i][z] = numList.get(j).n;
				temp[i][z+1] = numList.get(j).cnt;
				z += 2;
				max = Math.max(z, max);
			}
		}
		
		if(max > 101) {
			max = 101;
		}

		arr = new int[arr.length][max];

		for(int i=1; i<arr.length; i++) {
			for(int j=1; j<arr[0].length; j++) {
				arr[i][j] = temp[i][j];
			}
		}
	}

	static void cOperation() {
		int max = Integer.MIN_VALUE;
		int[][] temp = new int[101][101];

		for(int j=1; j<arr[0].length; j++) {
			cntArr = new int[101];
			numList = new ArrayList<>();
			for(int i=1; i<arr.length; i++) {
				if(arr[i][j] != 0) {
					cntArr[arr[i][j]]++;
				}
			}

			for(int i=1; i<=100; i++) {
				if(cntArr[i] != 0) {
					numList.add(new Number(i, cntArr[i]));
				}
			}

			Collections.sort(numList, new Comparator<Number>() {
				@Override
				public int compare(Number o1, Number o2) {
					if(o1.cnt == o2.cnt) {
						return Integer.compare(o1.n, o2.n);
					}
					return Integer.compare(o1.cnt, o2.cnt);
				}
			});

			int z = 1;
			for(int i=0; i<numList.size(); i++) {
				temp[z][j] = numList.get(i).n;
				temp[z+1][j] = numList.get(i).cnt;
				z += 2;
				max = Math.max(z, max);
			}
		}

		if(max > 101) {
			max = 101;
		}
		
		arr = new int[max][arr[0].length];

		for(int i=1; i<arr.length; i++) {
			for(int j=1; j<arr[0].length; j++) {
				arr[i][j] = temp[i][j];
			}
		}
	}
}

class Number {
	int n;
	int cnt;

	Number(int n, int cnt) {
		this.n = n;
		this.cnt = cnt;
	}
}