package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 로봇 청소기(해결)
 * @author wldud
 *
 */
public class P14503 {
	
	static int n = 0;
	static int m = 0;
	static int d = 0;
	static int r = 0;
	static int c = 0;
	static int[][] arr = null;
	static int[] dr = { 0, -1, 0, 1 }; // d방향에 따른 좌표정하기
	static int[] dc = { -1, 0, 1, 0 };
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 바라보는 방향 d 북동남서 0,1,2,3 왼쪽부터 체크한다
		// 뒤쪽 idx   d    왼쪽방향 idx   해당방향 d회전  
		//	3 		 0  ->   0      ->   3        
		//	0		 1  ->   1      ->   0
		//	1		 2  ->   2      ->   1
		//	2		 3  ->   3      ->   2
		
		while(true) {
//			System.out.println("(r, c)" + "(" + r + "," + c + ")");
			arr[r][c] = 3; // 3이면 청소
			
//			System.out.print(arr[r-1][c] + " ");
//			System.out.print(arr[r+1][c] + " ");
//			System.out.print(arr[r][c-1] + " ");
//			System.out.println(arr[r][c+1]);
			if((arr[r-1][c]==1 || arr[r-1][c]==3)
			   && (arr[r+1][c]==1 || arr[r+1][c]==3)
			   && (arr[r][c-1]==1 || arr[r][c-1]==3)
			   && (arr[r][c+1]==1 || arr[r][c+1]==3)
			) 
			{
//				System.out.println(r);
//				System.out.println(c);
				int backIdx = backIndex();
				int backR = r+dr[backIdx];
				int backC = c+dc[backIdx];
//				System.out.println(backIdx);
//				System.out.println(backR);
//				System.out.println(backC);
				if(arr[backR][backC] == 1) {
					break;
				}
				else {
					r = backR;
					c = backC;
					continue;
				}
			}
			
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(arr[nr][nc] == 0) {
				changeDirection();
				r = nr;
				c = nc;
				continue;
			}
			else if(arr[nr][nc] != 0) {
				changeDirection();
			}
		}

		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 3) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
	
	static void changeDirection() {
		if(d == 0) {
			d = 3;
		} 
		else if(d == 1) {
			d = 0;
		}
		else if(d == 2) {
			d = 1;
		}
		else if(d == 3) {
			d = 2;
		}
	}
	
	static int backIndex() {
		int backIdx = 0;
		if(d == 0) backIdx = 3;
		else backIdx = d-1;
		return backIdx;
	}
}

