package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 게리맨더링2 (해결)
 * @author wldud
 *
 */
public class P17779 {

	static int N = 0;
	static int[][] jaehyun = null;
	static int[][] area = null;
	static int[] calArea = null;
	static int d1 = 1;
	static int d2 = 1;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		jaehyun = new int[N+1][N+1];
		area = new int[N+1][N+1]; // 구역 1~5
		calArea = new int[6];  // 각 구역 인구 합친 값 

		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				jaehyun[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//		divideArea(2, 4, 2, 2);
		//		calculateArea();

		for(int d1=1; d1<=N; d1++) {
			for(int d2=1; d2<=N; d2++) {
				for(int i=1; i<=N; i++) {
					for(int j=1; j<=N; j++) {
						if(i+d1+d2<=N && j-d1>=1 && j+d2<=N) {
							divideArea(i, j, d1, d2);
							calculateArea();
						}
					}
				}
			}
		}
		
		System.out.println(result);
	}

	static void divideArea(int r, int c, int d1, int d2) {
		area = new int[N+1][N+1]; // 구역 1~5
		int d = 0;

		// 경계 채우기(5)
		while(d<=d1) {
			int nr = r+d;
			int nc = c-d;
			d++;
			area[nr][nc] = 5;
		}

		d = 0;
		while(d<=d2) {
			int nr = r+d;
			int nc = c+d;
			d++;
			area[nr][nc] = 5;
		}

		d = 0;
		while(d<=d2) {
			int nr = r+d1+d;
			int nc = c-d1+d;
			d++;
			area[nr][nc] = 5;
		}

		d = 0;
		while(d<=d1) {
			int nr = r+d2+d;
			int nc = c+d2-d;
			d++;
			area[nr][nc] = 5;
		}

//		System.out.println("============================");
//		for(int i=1; i<=N; i++) {
//			for(int j=1; j<=N; j++) {
//				System.out.print(area[i][j] + " ");
//			}
//			System.out.println();
//		}

		// 5사이에 채우기
		int flag = 0; // to를 저장하기 위한
		for(int i=1; i<=N; i++) {
			int from = 0;
			int to = 0;
			flag = 0;
			for(int j=1; j<=N; j++) {
				if(area[i][j] == 5 && flag == 1) {
					to = j;
				}
				else if(area[i][j]==5) {
					from = to = j;
					flag = 1;
				}
//				System.out.println("from" + from + "to" + to);
			}
			for(int j=from; j<=to; j++) {
				area[i][j] = 5;
			}
		}

		// 1번 선거구
		for(int i=1; i<r+d1; i++) {
			for(int j=1; j<=c; j++) {
				if(area[i][j] == 5) continue;
				area[i][j] = 1;
			}
		}

		// 2번 선거구
		for(int i=1; i<=r+d2; i++) {
			for(int j=c+1; j<=N; j++) {
				if(area[i][j] == 5) continue;
				area[i][j] = 2;
			}
		}

		// 3번 선거구
		for(int i=r+d1; i<=N; i++) {
			for(int j=1; j<c-d1+d2; j++) {
				if(area[i][j] == 5) continue;
				area[i][j] = 3;
			}
		}

		// 4번 선거구
		for(int i=r+d2+1; i<=N; i++) {
			for(int j=c-d1+d2; j<=N; j++) {
				if(area[i][j] == 5) continue;
				area[i][j] = 4;
			}
		}

//		System.out.println("============================");
//		for(int i=1; i<=N; i++) {
//			for(int j=1; j<=N; j++) {
//				System.out.print(area[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

	static void calculateArea() {
		calArea = new int[6];  // 각 구역 인구 합친 값 
//		for(int i=1; i<=5; i++) {
//			System.out.print(i + "=>" + calArea[i] + " ");
//		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(area[i][j] == 1) {
					calArea[1] += jaehyun[i][j];
				}
				if(area[i][j] == 2) {
					calArea[2] += jaehyun[i][j];
				}
				if(area[i][j] == 3) {
					calArea[3] += jaehyun[i][j];
				}
				if(area[i][j] == 4) {
					calArea[4] += jaehyun[i][j];
				}
				if(area[i][j] == 5) {
					calArea[5] += jaehyun[i][j];
				}
			}
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=1; i<=5; i++) {
			if(calArea[i] < min) min = calArea[i];
			if(calArea[i] > max) max = calArea[i];
//			System.out.print(i + "=>" + calArea[i] + " ");
		}
//		System.out.println();

		if((max-min) < result) {
			result = max-min;
		}

//		System.out.println(result);
	}
}

