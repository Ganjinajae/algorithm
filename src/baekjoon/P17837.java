package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * ���ο� ����2(�ذ�) List<Integer>[][] ����� �� Ȯ���� ��
 * @author wldud
 *
 */
public class P17837 {

	static int N, K = 0;
	static int[][] chess = null; // ü���� ���� ������ ĥ�������� 0:��, 1:��, 2:��
	static List<Horse> horse = null; // ������ �̵� ����
	static List<Integer>[][] stack = null; // ü������ �׿��ִ� ��� 
	static int[] dr = { 0, 0, 0, -1, 1 };
	static int[] dc = { 0, 1, -1, 0, 0 };
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		chess = new int[N+1][N+1];
		horse = new ArrayList<>();
		horse.add(new Horse());  // index���߱� ���� add
		stack = new ArrayList[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				chess[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			horse.add(new Horse(r, c, d));
			stack[r][c] = new ArrayList<>();
			stack[r][c].add(i);
		}
		
		int turn = 0; // �� ��ȣ
		
		while(turn++ <=1000) {
//			System.out.println("turn" + turn);
			for(int i=1; i<=K; i++) {
//				System.out.println(i);
				int r = horse.get(i).r;
				int c = horse.get(i).c;
				int d = horse.get(i).d;
				
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr>N || nc>N || nr<=0 || nc<=0 || (chess[nr][nc]==2)){ // �Ķ��� or ����� ���
					int nd = d%2 == 1 ? d+1 : d-1; // 1->2, 2->1, 3->4, 4->3
					nr = r+dr[nd];
					nc = c+dc[nd];
									
					if(nr>N || nc>N || nr<=0 || nc<=0 || (chess[nr][nc] == 2)) {
						horse.get(i).put(r, c, nd);
						continue;
					}
					else {
						if(chess[nr][nc] == 0) {  // ���
							if(stack[nr][nc] == null) {
								stack[nr][nc] = new ArrayList<>();
							}
							int from = stack[r][c].indexOf(Integer.valueOf(i));  // stack�� 0���� ���� , �� ���� ���� ���� -1 �����ϴµ�
							int to = stack[r][c].size();
							
							for(int j=from; j<to; j++) {
								stack[nr][nc].add(stack[r][c].get(j));
								if(stack[r][c].get(j) == i) {
									horse.get(stack[r][c].get(j)).put(nr, nc, nd);
								}
								else {
									horse.get(stack[r][c].get(j)).put(nr, nc); // ��ǥ �̵�
								}
							}
							// �ű���� �����
							for(int j=from; j<to; j++) {
								stack[r][c].remove(from); // index ���������� ����� ��������� �������ϱ� ���ڸ��� ��� ���� ��
							}
						}
						else if(chess[nr][nc] == 1) { // ������
							if(stack[nr][nc] == null) {
								stack[nr][nc] = new ArrayList<>();
							}
							
							int from = stack[r][c].indexOf(Integer.valueOf(i));  // stack�� 0���� ����
							int to = stack[r][c].size();
							
							for(int j=to-1; j>=from; j--) {
								stack[nr][nc].add(stack[r][c].get(j));
								if(stack[r][c].get(j) == i) {
									horse.get(stack[r][c].get(j)).put(nr, nc, nd);
								}
								else {
									horse.get(stack[r][c].get(j)).put(nr, nc); // ��ǥ �̵�
								}
							}
							// �ű���� �����
							for(int j=from; j<to; j++) {
								stack[r][c].remove(from); // index ���������� ����� ��������� �������ϱ� ���ڸ��� ��� ���� ��
							}
						}
					}
				}
				else if(chess[nr][nc] == 0) {  // ���
					if(stack[nr][nc] == null) {
						stack[nr][nc] = new ArrayList<>();
					}
					int from = stack[r][c].indexOf(Integer.valueOf(i));  // stack�� 0���� ���� , �� ���� ���� ���� -1 �����ϴµ�
					int to = stack[r][c].size();
					
					for(int j=from; j<to; j++) {
						stack[nr][nc].add(stack[r][c].get(j));
						horse.get(stack[r][c].get(j)).put(nr, nc); // ��ǥ �̵�
					}
					// �ű���� �����
					for(int j=from; j<to; j++) {
						stack[r][c].remove(from); // index ���������� ����� ��������� �������ϱ� ���ڸ��� ��� ���� ��
					}
				}
				else if(chess[nr][nc] == 1) { // ������
					if(stack[nr][nc] == null) {
						stack[nr][nc] = new ArrayList<>();
					}
					
					int from = stack[r][c].indexOf(Integer.valueOf(i));  // stack�� 0���� ����
					int to = stack[r][c].size();
					
					for(int j=to-1; j>=from; j--) {
						stack[nr][nc].add(stack[r][c].get(j));
						horse.get(stack[r][c].get(j)).put(nr, nc); // ��ǥ �̵�
					}
					// �ű���� �����
					for(int j=from; j<to; j++) {
						stack[r][c].remove(from); // index ���������� ����� ��������� �������ϱ� ���ڸ��� ��� ���� ��
					}
				}
				
				// ����Ǵ� ���� 4���̻� �׿� ������ ���
				if(stack[nr][nc].size() >= 4) {
					System.out.println(turn);
					return;
				}
				
			}
		}
		
		System.out.println(-1);
	}
}

class Horse {
	int r;
	int c;
	int d; // ����
	
	public Horse() {}
	public Horse(int r, int c, int d) {
		this.r = r;
		this.c = c;
		this.d = d;
	}
	
	void put(int r, int c, int d) {
		this.r = r;
		this.c = c;
		this.d = d;
	}
	
	void put(int r, int c) {
		this.r = r;
		this.c = c;
	}
	

}
