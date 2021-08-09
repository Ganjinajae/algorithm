package programmers;

/**
 * ¹è´Þ
 * @author wldud
 *
 */
public class Delivery {
	
	static int ans;
	static int sK;
	static int[][] arr = new int[51][51];
	static boolean[][] visited = new boolean[51][51];

	public static void main(String[] args) {
		Delivery test = new Delivery();
		int N = 6;
//		int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		int K = 4;
		int answer = test.solution(N, road, K);
		System.out.println(ans);
	}
	
	public int solution(int N, int[][] road, int K) {
        for(int i=0; i<road.length; i++) {
       		int a = road[i][0];
       		int b = road[i][1];
       		int v = road[i][2];
       		arr[a][b] = v;
       		arr[b][a] = v;
        }
        sK = K;
        visited[1][1] = true;
        dfs(1, 1, 0);
        
        return ans;
    }
	
	public void dfs(int from, int cnt, int value) {
		if(value > sK) {
			if(cnt > ans) {
				ans = cnt;
			}
			return;
		}
		
		for(int i=1; i<=50; i++) {
			if(!visited[from][i] && arr[from][i] > 0) {
				visited[from][i] = true;
				visited[i][from] = true;
				dfs(i, cnt+1, value+arr[from][i]);
				visited[from][i] = false;
				visited[i][from] = false;
			}
		}
	}
}
