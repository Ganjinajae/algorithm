package programmers;

/**
 * 숫자의 표현
 * @author wldud
 *
 */
public class ExpressionOfNumber {

	public int solution(int n) {
        int answer = 0;
        
        int idx = 1;
        while(true) {
        	int sum = 0;
        	for(int i=idx; i<=n; i++) {
        		sum += i;
        		if(sum >= n) {
        			if(sum == n) answer++;
        			break;
        		}
        	}
        	idx++;
        	if(idx > n) {
        		break;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		ExpressionOfNumber test = new ExpressionOfNumber();
		int n = 15;
		int answer = test.solution(n);
		System.out.println(answer);
	}
}
