package programmers;

/**
 * 피보나치 수
 * @author wldud
 *
 */
public class FibonacciNumbers {
	
	public int fibonacci(int n) {
		int[] d = new int[n+1];
		d[0] = 0;
		d[1] = 1;
		for(int i=2; i<=n; i++) {
			d[i] = (d[i-1]+d[i-2])%1234567;
		}
		
		return d[n];
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
