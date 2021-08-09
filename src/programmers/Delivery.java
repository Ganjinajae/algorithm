package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * ¹è´Þ
 * @author wldud
 *
 */
public class Delivery {
	
	static ArrayList<Edge>[] list;
	static int[] distance;
	static int sK;

	public static void main(String[] args) {
		Delivery test = new Delivery();
		int N = 6;
//		int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		int K = 4;
		int answer = test.solution(N, road, K);
		System.out.println(answer);
	}
	
	public void dijkstra() {
		
		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.add(new Edge(1, 0));
		
		while(!q.isEmpty()) {
			Edge edge = q.poll();
			int vertex = edge.vertex;
			int weight = edge.weight;
			
			//
			if(weight > distance[vertex]) {
				continue;
			}
			
			for(int i=0; i<list[vertex].size(); i++) {
				int vertex2 = list[vertex].get(i).vertex;
				int weight2 = list[vertex].get(i).weight + weight;
				if(weight2 < distance[vertex2]) {
					distance[vertex2] = weight2;
					q.add(new Edge(vertex2, weight2));
				}
			}
		}
		
	}
	
	public int solution(int N, int[][] road, int K) {
		
		int answer = 0;
		list = new ArrayList[N+1];
		distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
        for(int i=0; i<road.length; i++) {
       		int a = road[i][0];
       		int b = road[i][1];
       		int v = road[i][2];
       		list[a].add(new Edge(b, v));
       		list[b].add(new Edge(a, v));
        }
        
        distance[1] = 0;
        
        dijkstra();
        
        for(int i=1; i<=N; i++) {
        	if(distance[i] <= K) {
        		answer++;
        	}
        }
        return answer;
    }
	
}

class Edge implements Comparable<Edge> {
	
	int vertex;
	int weight;
	
	public Edge(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return weight-o.weight;
	}
}
