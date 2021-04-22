package programmers;

import java.util.Arrays;

/**
 * Ä«Æê
 * @author wldud
 *
 */
public class Carpet {

	public static void main(String[] args) {
		Carpet test = new Carpet();
		int brown = 24;
		int yellow = 24;
		int[] answer = test.solution(brown, yellow);
		System.out.println(Arrays.toString(answer));
	}
	
	public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int n = yellow;
        int m = 1;
        while(true) {
        	if(n < m) {
        		break;
        	}
        	if(yellow%n == 0) {
        		m = yellow/n;
        		int sum = (n+2)*2 + m*2;
        		if(sum == brown) {
        			answer[0] = n+2;
        			answer[1] = m+2;
        			break;
        		}
        	}
        	n--;
        }
        
        return answer;
    }
}
