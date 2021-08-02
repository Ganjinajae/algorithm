package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 거리두기 확인하기
 * @author wldud
 *
 */
public class KeepDistanceCheck {

	char[][] waitingRoom;
	int[] dr = {1, -1, 0, 0};
	int[] dc = {0, 0, 1, -1};
	int[][] visited;
	
	public static void main(String[] args) {
		KeepDistanceCheck test = new KeepDistanceCheck();
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		int[] answer = test.solution(places);
		System.out.println(Arrays.toString(answer));
	}
	
	public boolean isSafe(int r, int c) {
		visited = new int[5][5];
		visited[r][c] = 1;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		
		boolean result = true;
		
		while(!q.isEmpty()) {
			Point queue = q.poll();
			int cR = queue.getR();
			int cC = queue.getC();
			
			if(visited[cR][cC] == 2) continue;
			
			for(int i=0; i<4; i++) {
				int nr = cR+dr[i];
				int nc = cC+dc[i];
				
				if(nr>=0 && nc>=0 && nr<5 && nc<5) {
					if(waitingRoom[nr][nc] == 'P') {
						result = false;
						break;
					}
					if(waitingRoom[nr][nc] != 'X' && visited[nr][nc] == 0) {
						visited[nr][nc] = visited[r][c]+1;
						q.add(new Point(nr, nc));
					}
				}
			}
			
			if(!result) {
				break;
			}
		}
		
		return result;
	}
//	public boolean isSafe(int r, int c) {
//		visited = new int[5][5];
//		visited[r][c] = 1;
//		Queue<Point> q = new LinkedList<>();
//		q.add(new Point(r, c));
//		
//		boolean result = true;
//		
//		while(!q.isEmpty()) {
//			Point queue = q.poll();
//			int cR = queue.getR();
//			int cC = queue.getC();
//			
//			if(visited[cR][cC] == 2) continue;
//			
//			for(int i=0; i<4; i++) {
//				int nr = cR+dr[i];
//				int nc = cC+dc[i];
//				
//				if(nr>=0 && nc>=0 && nr<5 && nc<5) {
//					if(waitingRoom[nr][nc] == 'P') {
//						result = false;
//						break;
//					}
//					if(waitingRoom[nr][nc] != 'X' && visited[nr][nc] == 0) {
//						visited[nr][nc] = visited[r][c]+1;
//						q.add(new Point(nr, nc));
//					}
//				}
//			}
//			
//			if(!result) {
//				break;
//			}
//		}
//		
//		return result;
//	}
	
	public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i=0; i<5; i++) {
        	answer[i] = 1;
        }
        
        // 1. 응시자를 구분해서 좌표랑 넣어두기
        for(int i=0; i<places.length; i++) { // 대기실
        	waitingRoom = new char[5][5];
        	List<Point> list = new ArrayList<>();
        	for(int j=0; j<places[0].length; j++) { // 행
        		for(int k=0; k<places[i][j].length(); k++) { // 열 
        			waitingRoom[j][k] = places[i][j].charAt(k);
        			if(places[i][j].charAt(k) == 'P') {
        				list.add(new Point(j, k));
        			}
        		}
        	}
            // 2. 응시자끼리의 거리가 2이하일 때 거리두기 지키고 있는지 bfs로 확인
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
	
	Point(int r, int c) {
		this.r = r;
		this.c = c;
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
}
