package baekjoon;



import java.util.LinkedList;
import java.util.Queue;

public class Temp5 {

	public static void main(String[] args) {
		Temp5 test = new Temp5();
		int n = 6;
		int[][] edge = { {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		int answer = test.solution(n, edge);
		
		System.out.println(answer);
	}
	
	public int solution(int n, int[][] edge) {
        int answer = 0;
        
        boolean[][] node = new boolean[n+1][n+1];
        for(int i=0; i<edge.length; i++) {
        	node[edge[i][0]][edge[i][1]] = true;
        	node[edge[i][1]][edge[i][0]] = true;
        }
        
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        int max = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        
        while(!q.isEmpty()) {
        	int p = q.poll();
        	
        	for(int i=2; i<=n; i++) {
        		if(node[p][i] && !visited[i]) {
        			q.add(i);
        			visited[i] = true;
        			distance[i] = distance[p]+1;
        			if(max < distance[i]) {
        				max = distance[i];
        			}
        		}
        	}
        }
        
        for(int i=0; i<distance.length; i++) {
        	if(distance[i] == max) {
        		answer++;
        	}
        }
        
        return answer;
    }

}
