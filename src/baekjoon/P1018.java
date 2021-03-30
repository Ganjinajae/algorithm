package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ü���� �ٽ� ĥ�ϱ�(�ذ�)
 * @author wldud
 *
 */
public class P1018 {

	static int N, M = 0;
	static char[][] board = null;
	static char[][] cutBoard = null; // �߷��� ��
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];

		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				board[i][j] = s.charAt(j);
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i+8<=N && j+8<=M) {
					cuttingBoard(i, j);  // �������� �ָ� �ű⼭ �ϴ� �ɷ�
					cntPainting(i, j);
				}
			}
		}

		System.out.println(result);
	}

	static void cuttingBoard(int r, int c) {
		cutBoard = new char[N][M];
		for(int i=r; i<r+8; i++) {
			for(int j=c; j<c+8; j++) {
				cutBoard[i][j] = board[i][j];
			}
		}

		//		for(int i=r; i<r+8; i++) {
		//			for(int j=c; j<c+8; j++) {
		//				System.out.print(cutBoard[i][j]);
		//			}
		//			System.out.println();
		//		}
	}

	static void cntPainting(int r, int c) {
		int cnt = 0;
		if(cutBoard[r][c] == 'B') {
			// ù ��°�� black�� ���
			// 1. �������� �ִ´�� ���� ���
			for(int i=r; i<r+8; i+=2) {
				for(int j=c; j<c+8; j+=2) {
					if(cutBoard[i][j] != 'B') {
						cnt++; 
					}
				}
				for(int j=c+1; j<c+8; j+=2) {
					if(cutBoard[i][j] != 'W') {
						cnt++; 
					}
				}
			}
			for(int i=r+1; i<r+8; i+=2) {
				for(int j=c; j<c+8; j+=2) {
					if(cutBoard[i][j] != 'W') {
						cnt++;
					}
				}
				for(int j=c+1; j<c+8; j+=2) {
					if(cutBoard[i][j] != 'B') {
						cnt++;
					}
				}
			}

			if(cnt < result) {
				result = cnt;
			}
			
			changeColor(r, c);
		}
		else {
			// ù ��°�� white�� ���
			for(int i=r; i<r+8; i+=2) {
				for(int j=c; j<c+8; j+=2) {
					if(cutBoard[i][j] != 'W') {
						cnt++;
					}
				}
				for(int j=c+1; j<c+8; j+=2) {
					if(cutBoard[i][j] != 'B') {
						cnt++;
					}
				}
			}
			for(int i=r+1; i<r+8; i+=2) {
				for(int j=c; j<c+8; j+=2) {
					if(cutBoard[i][j] != 'B') {
						cnt++;
					}
				}
				for(int j=c+1; j<c+8; j+=2) {
					if(cutBoard[i][j] != 'W') {
						cnt++;
					}
				}
			}
			
			if(cnt < result) {
				result = cnt;
			}
			changeColor(r, c);
		}

		if(cnt < result) {
			result = cnt;
		}
	}
	
	static void changeColor(int r, int c) {
		int cnt = 0;

		// 2. ������ ���� �ٲ� ���
		if(cutBoard[r][c] == 'B') { // ������ ��->��
			cutBoard[r][c] = 'W';
			cnt++;
			for(int i=r; i<r+8; i+=2) {
				for(int j=c; j<c+8; j+=2) {
					if(cutBoard[i][j] != 'W') {
						cnt++;
					}
				}
				for(int j=c+1; j<c+8; j+=2) {
					if(cutBoard[i][j] != 'B') {
						cnt++;
					}
				}
			}
			for(int i=r+1; i<r+8; i+=2) {
				for(int j=c; j<c+8; j+=2) {
					if(cutBoard[i][j] != 'B') {
						cnt++;
					}
				}
				for(int j=c+1; j<c+8; j+=2) {
					if(cutBoard[i][j] != 'W') {
						cnt++;
					}
				}
			}

			if(cnt < result) {
				result = cnt;
			}
		}
		else { // ������ ��->��
			cutBoard[r][c] = 'B';
			cnt++;
			for(int i=r; i<r+8; i+=2) {
				for(int j=c; j<c+8; j+=2) {
					if(cutBoard[i][j] != 'B') {
						cnt++; 
					}
				}
				for(int j=c+1; j<c+8; j+=2) {
					if(cutBoard[i][j] != 'W') {
						cnt++; 
					}
				}
			}
			for(int i=r+1; i<r+8; i+=2) {
				for(int j=c; j<c+8; j+=2) {
					if(cutBoard[i][j] != 'W') {
						cnt++;
					}
				}
				for(int j=c+1; j<c+8; j+=2) {
					if(cutBoard[i][j] != 'B') {
						cnt++;
					}
				}
			}

			if(cnt < result) {
				result = cnt;
			}
		}
	}
}
