package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 미세먼지 안녕!(해결)
 * @author wldud
 *
 */
public class P17144 {

	static int R = 0;
	static int C = 0;
	static int T = 0;
	static int[][] arr = null;
	static int[][] tempArr = null;
	static int[] vPos = null; // 공기청정기 해당 행
	static int vr = 0;  // 공기청정기 윗 행
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		vPos = new int[R];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 공기청정기 좌표 저장
		for(int i=0; i<R; i++) {
			if(arr[i][0] == -1) {
				vr = i;
				break;
			}
		}
		
		while(T-- > 0) {
			spreadDust();
			circulateDust();
		}
		
		countAllDust();
		System.out.println(cnt);
	}
	
	static void spreadDust() {
		tempArr = new int[R][C];
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				int origin = arr[i][j];  // 뿌렸는데 다시 돌아가
				if(arr[i][j] > 0) {
					int q = arr[i][j]/5; // 각 칸에 뿌려질 양
					if((i-1) >=0 && arr[i-1][j] != -1) {
						tempArr[i-1][j] += q;
						origin = origin-q;
					}
					if((j-1) >=0 && arr[i][j-1] != -1 ) {
						tempArr[i][j-1] += q;
						origin = origin-q;
					}
					if((i+1) < R && arr[i+1][j] != -1) {
						tempArr[i+1][j] += q;
						origin = origin-q;
					}
					if((j+1) < C && arr[i][j+1] != -1) {
						tempArr[i][j+1] += q;
						origin = origin-q;
					}
					tempArr[i][j] += origin;
				}
			}
		}
		// copy
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j] == -1) continue;
				arr[i][j] = tempArr[i][j];
			}
		}
		
//		System.out.println("===============================");
//		for(int i=0; i<R; i++) {
//			for(int j=0; j<C; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
	
	static void circulateDust() {
		for(int i=vr-1; i>=1; i--) {
			arr[i][0] = arr[i-1][0];			
		}
		for(int j=1; j<C; j++) {
			arr[0][j-1] = arr[0][j];
		}
		for(int i=1; i<=vr; i++) {
			arr[i-1][C-1] = arr[i][C-1];
		}
		for(int j=C-1; j>1; j--) {
			arr[vr][j] = arr[vr][j-1];
		}
		arr[vr][1] = 0; // 밀리는 시작점
		
		for(int i=vr+3; i<R; i++) {
			arr[i-1][0] = arr[i][0];
		}
		for(int j=1; j<C; j++) {
			arr[R-1][j-1] = arr[R-1][j];
		}
		for(int i=R-1; i>vr+1; i--) {
			arr[i][C-1] = arr[i-1][C-1];
		}
		for(int j=C-1; j>1; j--) {
			arr[vr+1][j] = arr[vr+1][j-1];
		}
		arr[vr+1][1] = 0;
		
//		System.out.println("===============================");
//		for(int i=0; i<R; i++) {
//			for(int j=0; j<C; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
	
	static void countAllDust() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j] == -1) {
					continue;
				}
				cnt += arr[i][j];
			}
		}
	}
}
