package programmers;

/**
 * 단체사진 찍기
 * @author wldud
 *
 */
public class TeamPhoto {

	int answer;
	String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
	int[] line = new int[8];
	String[] condition;
	boolean[] visited = new boolean[8];

	public static void main(String[] args) {
		TeamPhoto test = new TeamPhoto();
		int n = 2;
		String[] data = {"N~F=0", "R~T>2"};
		int answer = test.solution(n, data);
		System.out.println(answer);
	}

	public int solution(int n, String[] data) {
		
		condition = data;
		dfs(0, "");

		return answer;
	}

	public void dfs(int cnt, String line) {
		if(cnt == 8) {
			if(check(line)) {
				answer++;
			}
			return;
		}

		for(int i=0; i<friends.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(cnt+1, line+friends[i]);
				visited[i] = false;
			}
		}

	}

	public boolean check(String line) {

		for(int i=0; i<condition.length; i++) {
			int a = line.indexOf(condition[i].charAt(0));
			int b = line.indexOf(condition[i].charAt(2));
			char o = condition[i].charAt(3);
			int d = condition[i].charAt(4)-'0';

			if(o == '=') {
				if(Math.abs(a-b) != d+1) { return false; }
			}
			else if(o == '>') {
				if(Math.abs(a-b) <= d+1) { return false; }
			}
			else if(o == '<') {
				if(Math.abs(a-b) >= d+1) { return false; }
			}
		}
		return true;
	}
}
