package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * ����(�ذ�)
 * @author wldud
 *
 */
public class P15683 {

	static int N, M = 0;
	static int K = 0; // CCTV����
	static int[][] office = null;
	static List<Cctv> cctvList = new ArrayList<>();
	static int min = Integer.MAX_VALUE; // �簢���� �ּҰ�

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		office = new int[N][M];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if(office[i][j] != 0 && office[i][j] != 6) {
					K++;
					cctvList.add(new Cctv(i, j));
				}
			}
		}

		dfs(0, office);

		System.out.println(min);
	}

	static void copyArr(int[][] obj, int[][] arr) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				obj[i][j] = arr[i][j];
			}
		}
	}
	
	static void rollback(int[][] obj, int[][] arr) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				obj[i][j] = arr[i][j];
			}
		}
	}

	static void dfs(int n, int[][] arr) {
		if(n == K) {
			compareUnvisibleArea(arr);
			return;
		}

		int[][] temp = new int[N][M];
		copyArr(temp, arr);

		int r = cctvList.get(n).r;
		int c = cctvList.get(n).c;

		if(temp[r][c] == 1) {
			for(int k=0; k<4; k++) {  // ��, ��, ��, ��
				cctv1(r, c, k, temp);
				dfs(n+1, temp);
				rollback(temp, arr);
			}
		}
		else if(temp[r][c] == 2) {
			for(int k=0; k<2; k++) {
				cctv2(r, c, k, temp);
				dfs(n+1, temp);
				rollback(temp, arr);
			}
		}
		else if(temp[r][c] == 3) {
			for(int k=0; k<4; k++) {
				cctv3(r, c, k, temp);
				dfs(n+1, temp);
				rollback(temp, arr);
			}
		}
		else if(temp[r][c] == 4) {
			for(int k=0; k<4; k++) {
				cctv4(r, c, k, temp);
				dfs(n+1, temp);
				rollback(temp, arr);
			}
		}
		else if(temp[r][c] == 5) {
			cctv5(r, c, 0, temp);
			dfs(n+1, temp);
			rollback(temp, arr);
		}
	}

	// �簢���� ���� ���� �ּҰ� ����
	static void compareUnvisibleArea(int[][] temp) {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(temp[i][j] == 0) {
					cnt++;
				}
			}
		}

		if(cnt < min) {
			min = cnt;
		}
	}

	static void cctv1(int r, int c, int dir, int[][] temp) {
		if(dir == 0) { // ��
			for(int l=r; l>=0; l--) {
				if(temp[l][c] == 6) {
					break;
				}
				if(temp[l][c] == 0) {
					temp[l][c] = 7; // #���� ����
				}
			}
		}
		else if(dir == 1) { // ��
			for(int l=c; l<M; l++) { 
				if(temp[r][l] == 6) {
					break;
				}
				if(temp[r][l] == 0) {
					temp[r][l] = 7; // #���� ����
				}
			}
		}
		else if(dir == 2) { // ��
			for(int l=r; l<N; l++) { 
				if(temp[l][c] == 6) {
					break;
				}
				if(temp[l][c] == 0) {
					temp[l][c] = 7; // #���� ����
				}
			}
		}
		else if(dir == 3) { // ��
			for(int l=c; l>=0; l--) { 
				if(temp[r][l] == 6) {
					break;
				}
				if(temp[r][l] == 0) {
					temp[r][l] = 7; // #���� ����
				}
			}
		}
	}

	static void cctv2(int r, int c, int dir, int[][] temp) {
		if(dir == 0) { // �翷
			for(int l=c; l<M; l++) { // ������
				if(temp[r][l] == 6) {
					break;
				}
				if(temp[r][l] == 0) {
					temp[r][l] = 7; 
				}
			}
			for(int l=c; l>=0; l--) { // ����
				if(temp[r][l] == 6) {
					break;
				}
				if(temp[r][l] == 0) {
					temp[r][l] = 7; 
				}
			}
		}
		else { // ���Ʒ�
			for(int l=r; l>=0; l--) { // ��
				if(temp[l][c] == 6) {
					break;
				}
				if(temp[l][c] == 0) {
					temp[l][c] = 7; 
				}
			}
			for(int l=r; l<N; l++) {  // �Ʒ�
				if(temp[l][c] == 6) {
					break;
				}
				if(temp[l][c] == 0) {
					temp[l][c] = 7; 
				}
			}
		}
	}

	static void cctv3(int r, int c, int dir, int[][] temp) {
		if(dir == 0) { // ��, ��
			for(int l=r; l>=0; l--) { // ��
				if(temp[l][c] == 6) {
					break;
				}
				if(temp[l][c] == 0) {
					temp[l][c] = 7; 
				}
			}
			for(int l=c; l<M; l++) { // ������
				if(temp[r][l] == 6) {
					break;
				}
				if(temp[r][l] == 0) {
					temp[r][l] = 7; 
				}
			}
		}
		else if(dir == 1){ // ��, ��
			for(int l=c; l<M; l++) { // ������
				if(temp[r][l] == 6) {
					break;
				}
				if(temp[r][l] == 0) {
					temp[r][l] = 7; 
				}
			}
			for(int l=r; l<N; l++) {  // �Ʒ�
				if(temp[l][c] == 6) {
					break;
				}
				if(temp[l][c] == 0) {
					temp[l][c] = 7; 
				}
			}
		}
		else if(dir == 2){ // ��, ��
			for(int l=r; l<N; l++) {  // �Ʒ�
				if(temp[l][c] == 6) {
					break;
				}
				if(temp[l][c] == 0) {
					temp[l][c] = 7; 
				}
			}
			for(int l=c; l>=0; l--) { // ����
				if(temp[r][l] == 6) {
					break;
				}
				if(temp[r][l] == 0) {
					temp[r][l] = 7; 
				}
			}
		}
		else if(dir == 3){ // ��, ��
			for(int l=c; l>=0; l--) { // ����
				if(temp[r][l] == 6) {
					break;
				}
				if(temp[r][l] == 0) {
					temp[r][l] = 7; 
				}
			}
			for(int l=r; l>=0; l--) { // ��
				if(temp[l][c] == 6) {
					break;
				}
				if(temp[l][c] == 0) {
					temp[l][c] = 7; 
				}
			}
		}
	}

	static void cctv4(int r, int c, int dir, int[][] temp) {
		if(dir == 0) { // ��, ��, ��
			for(int l=r; l>=0; l--) { // ��
				if(temp[l][c] == 6) {
					break;
				}
				if(temp[l][c] == 0) {
					temp[l][c] = 7; 
				}
			}
			for(int l=c; l<M; l++) { // ������
				if(temp[r][l] == 6) {
					break;
				}
				if(temp[r][l] == 0) {
					temp[r][l] = 7; 
				}
			}
			for(int l=c; l>=0; l--) { // ����
				if(temp[r][l] == 6) {
					break;
				}
				if(temp[r][l] == 0) {
					temp[r][l] = 7; 
				}
			}
		}
		else if(dir == 1){ // ��, ��, ��
			for(int l=r; l<N; l++) {  // �Ʒ�
				if(temp[l][c] == 6) {
					break;
				}
				if(temp[l][c] == 0) {
					temp[l][c] = 7; 
				}
			}
			for(int l=c; l>=0; l--) { // ����
				if(temp[r][l] == 6) {
					break;
				}
				if(temp[r][l] == 0) {
					temp[r][l] = 7; 
				}
			}
			for(int l=c; l<M; l++) { // ������
				if(temp[r][l] == 6) {
					break;
				}
				if(temp[r][l] == 0) {
					temp[r][l] = 7; 
				}
			}
		}
		else if(dir == 2) { // ��, ��, ��
			for(int l=r; l>=0; l--) { // ��
				if(temp[l][c] == 6) {
					break;
				}
				if(temp[l][c] == 0) {
					temp[l][c] = 7; 
				}
			}
			for(int l=c; l<M; l++) { // ������
				if(temp[r][l] == 6) {
					break;
				}
				if(temp[r][l] == 0) {
					temp[r][l] = 7; 
				}
			}
			for(int l=r; l<N; l++) {  // �Ʒ�
				if(temp[l][c] == 6) {
					break;
				}
				if(temp[l][c] == 0) {
					temp[l][c] = 7; 
				}
			}
		}
		else if(dir == 3) { // ��, ��, ��
			for(int l=r; l>=0; l--) { // ��
				if(temp[l][c] == 6) {
					break;
				}
				if(temp[l][c] == 0) {
					temp[l][c] = 7; 
				}
			}
			for(int l=c; l>=0; l--) { // ����
				if(temp[r][l] == 6) {
					break;
				}
				if(temp[r][l] == 0) {
					temp[r][l] = 7; 
				}
			}
			for(int l=r; l<N; l++) {  // �Ʒ�
				if(temp[l][c] == 6) {
					break;
				}
				if(temp[l][c] == 0) {
					temp[l][c] = 7; 
				}
			}
		}
	}

	static void cctv5(int r, int c, int dir, int[][] temp) {
		for(int l=r; l>=0; l--) { // ��
			if(temp[l][c] == 6) {
				break;
			}
			if(temp[l][c] == 0) {
				temp[l][c] = 7; 
			}
		}
		for(int l=c; l<M; l++) { // ������
			if(temp[r][l] == 6) {
				break;
			}
			if(temp[r][l] == 0) {
				temp[r][l] = 7; 
			}
		}
		for(int l=r; l<N; l++) {  // �Ʒ�
			if(temp[l][c] == 6) {
				break;
			}
			if(temp[l][c] == 0) {
				temp[l][c] = 7; 
			}
		}
		for(int l=c; l>=0; l--) { // ����
			if(temp[r][l] == 6) {
				break;
			}
			if(temp[r][l] == 0) {
				temp[r][l] = 7; 
			}
		}
	}
}

class Cctv {
	int r;
	int c;

	Cctv(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
