package programmers;

import java.util.Arrays;

/**
 * 구명 보트
 * @author wldud
 *
 */
public class LifeBoat {

	public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        
        boolean[] visited = new boolean[people.length];
        for(int i=0; i<people.length; i++) {
        	int min = 987654321;
        	if(visited[i]) continue;
        	visited[i] = true;
        	int n = people[i];
        	int idx = -1;
        	for(int j=0; j<people.length; j++) {
        		if(visited[j]) continue;
        		int m = people[j];
        		int sum = n+m;
        		if(sum == limit) {
        			answer++;
        			visited[j] = true;
        			idx = -2;
        			break;
        		}
        		int temp = Math.abs(limit-sum);
        		if(limit-sum > 0) {
        			 if(temp < min) {
        				 temp = min;
        				 idx = j;
        			 }
        		}
        	}
        	if(idx == -1) {
        		answer++;
        	}
        	else if(idx > 0) {
        		visited[idx] = true;
        		answer++;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		LifeBoat test = new LifeBoat();
		int[] people = {70, 80, 50};
//		int[] people = {70, 50, 80, 50};
		int limit = 100;
		int answer = test.solution(people, limit);
		System.out.println(answer);
	}
}
