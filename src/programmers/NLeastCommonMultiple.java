package programmers;

/**
 * N개의 최소 공배수
 * @author wldud
 *
 */
public class NLeastCommonMultiple {

	public static void main(String[] args) {
		NLeastCommonMultiple test= new NLeastCommonMultiple();
		int[] arr = {2, 6, 8, 14};
		int answer = test.solution(arr);
		System.out.println(answer);
	}
	
	public int gcd(int a, int b) {
		int r = 0;
		while(b != 0) {
			r = a%b;
			a = b;
			b = r;
		}
		return a;
	}
	
	public int lcm(int a, int b) {
		int g = gcd(a, b);
		return (a*b)/g;
	}
	
	public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i=1; i<arr.length; i++) {
        	answer = lcm(answer, arr[i]);
        }
        return answer;
    }
}
