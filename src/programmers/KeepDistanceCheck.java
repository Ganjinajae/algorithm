package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * �Ÿ��α� Ȯ���ϱ�
 * @author wldud
 *
 */
public class KeepDistanceCheck {

	char[][] waitingRoom;
	int[] dr = {1, -1, 0, 0};
	int[] dc = {0, 0, 1, -1};
	boolean[][] visited;
	
	public static void main(String[] args) {
		KeepDistanceCheck test = new KeepDistanceCheck();
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		int[] answer = test.solution(places);
		System.out.println(Arrays.toString(answer));
	}
	
	public boolean isSafe(int r, int c) {
		visited = new boolean[5][5];
		visited[r][c] = true;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c, 0));
		
		boolean result = true;
		
		while(!q.isEmpty()) {
			Point queue = q.poll();
			int cR = queue.getR();
			int cC = queue.getC();
			int d = queue.getD();
			
			if(d >= 2) continue;
			
			for(int i=0; i<4; i++) {
				int nr = cR+dr[i];
				int nc = cC+dc[i];
				
				if(nr>=0 && nc>=0 && nr<5 && nc<5) {
					if(!visited[nr][nc]) {
						if(waitingRoom[nr][nc] == 'P') {
							if(d<=2) {
								result = false;
								break;
							}
						}
						
						if(waitingRoom[nr][nc] == 'O') {
							visited[nr][nc] = true;
							q.add(new Point(nr, nc, d+1));
						}
					}
					
				}
			}
			
			if(!result) {
				break;
			}
		}
			
		return result;
	}
	
	public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i=0; i<5; i++) {
        	answer[i] = 1;
        }
        
        // 1. �����ڸ� �����ؼ� ��ǥ�� �־�α�
        for(int i=0; i<places.length; i++) { // ����
        	waitingRoom = new char[5][5];
        	List<Point> list = new ArrayList<>();
        	for(int j=0; j<places[0].length; j++) { // ��
        		for(int k=0; k<places[i][j].length(); k++) { // �� 
        			waitingRoom[j][k] = places[i][j].charAt(k);
        			if(places[i][j].charAt(k) == 'P') {
        				list.add(new Point(j, k, 0));
        			}
        		}
        	}
            // 2. �����ڳ����� �Ÿ��� 2������ �� �Ÿ��α� ��Ű�� �ִ��� bfs�� Ȯ��
        	for(int j=0; j<list.size()-1; j++) {
        		for(int k=j+1; k<list.size(); k++) {
        			Point p1 = list.get(j);
        			Point p2 = list.get(k);
        			int dist = Math.abs(p1.getR()-p2.getR()) + Math.abs(p1.getC()-p2.getC());
        			if(dist <= 2) {
        				if(!isSafe(p1.getR(), p1.getC())) {
        					answer[i] = 0;
        				}
        			}
        		}
        	}
        }
        
        return answer;
    }
}

class Point {
	int r;
	int c;
	int d;
	
	Point(int r, int c, int d) {
		this.r = r;
		this.c = c;
		this.d = d;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}
	
}
