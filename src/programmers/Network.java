package programmers;

/**
 * 네트워크
 * @author wldud
 *
 */
public class Network {

	public static void main(String[] args) {
		Network test = new Network();

		int n = 3;
		int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
		int answer = test.solution(n, computers);
		System.out.println(answer);
	}

	int[] visited = null;

	public int solution(int n, int[][] computers) {
		int answer = 0;
		visited = new int[n];
		for(int i=0; i<computers.length; i++) {
			if(visited[i]==0) {
				dfs(i, computers, ++answer);
			}
		}

		return answer;   
	}

	public void dfs(int i, int[][] computers, int num) {
		visited[i] = num;
		for(int j=0; j<computers[0].length; j++) {
			if(computers[i][j]==1 && visited[j]==0) {
				dfs(j, computers, num);
			}
		}
	}
}