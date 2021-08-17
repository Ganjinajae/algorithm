package programmers;

/**
 * 피보나치 수
 * @author wldud
 *
 */
public class FibonacciNumbers {
	
	int[] m = new int[100001];
	
	public int fibonacci(int n) {
		if(m[n] > 0) {
			return m[n];
		}
		if(n < 1) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		
		return m[n] = (fibonacci(n-1) + fibonacci(n-2))%1234567;
	}

	public int solution(int n) {
        
        return fibonacci(n);
    }
	
	public static void main(String[] args) {
		FibonacciNumbers test = new FibonacciNumbers();
		int n = 3;
		int answer = test.solution(n);
		System.out.println(answer);
	}
}
