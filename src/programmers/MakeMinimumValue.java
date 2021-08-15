package programmers;

import java.util.Arrays;

/**
 * 최솟값 만들기
 * @author wldud
 *
 */
public class MakeMinimumValue {

	public int solution(int []A, int []B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0; i<A.length; i++) {
        	answer += A[i]*B[A.length-1-i];
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		MakeMinimumValue test = new MakeMinimumValue();
		int[] A = {1, 4, 2};
		int[] B = {5, 4, 4};
		int answer = test.solution(A, B);
		System.out.println(answer);
	}
}
