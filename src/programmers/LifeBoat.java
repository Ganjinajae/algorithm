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
        int left = 0;
        int right = 0;
        
        for(right=people.length-1; left<=right; right--) {
        	if(people[left]+people[right] <= limit) left++;
        	answer++;
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
