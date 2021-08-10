package programmers;

/**
 * 방문 길이
 * @author wldud
 *
 */
public class VisitLength {

	boolean[][][][] visited = new boolean[11][11][11][11];

	public static void main(String[] args) {

		VisitLength test = new VisitLength();
		String dirs = "LULLLLLLU";
		int answer = test.solution(dirs);
		System.out.println(answer);
	}

	public int solution(String dirs) {
		int answer = 0;

		int r = 5;
		int c = 5;
		int nr = 5;
		int nc = 5;
		for(int i=0; i<dirs.length(); i++) {
			char ch = dirs.charAt(i);
			r = nr;
			c = nc;
			if(ch == 'U') {
				nr = r-1;
			}
			else if(ch == 'D') {
				nr = r+1; 
			}
			else if(ch == 'R') {
				nc = c+1;
			}
			else if(ch == 'L') {
				nc = c-1;
			}
			
			if(nr<0 || nr>10 || nc<0 || nc>10) {
				nr = r;
				nc = c;
				continue;
			}

			if(!visited[r][c][nr][nc]) {
				visited[r][c][nr][nc] = true;
				visited[nr][nc][r][c] = true;
				answer++;
			}
		}

		return answer;
	}
}
