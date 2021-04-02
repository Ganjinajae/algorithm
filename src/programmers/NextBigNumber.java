package programmers;

/**
 * 다음 큰 숫자
 * @author wldud
 *
 */
public class NextBigNumber {

	public static void main(String[] args) {
		NextBigNumber test = new NextBigNumber();
		int n = 78;
		int answer = test.solution(n);
		System.out.println(answer);
	}
	
	public int solution(int n) {
        int answer = 0;
        int compNum = numOne(n);
        int nextNum = n+1;
        while(true) {
        	if(compNum == numOne(nextNum)) {
        		answer = nextNum;
        		break;
        	}
        	nextNum += 1;
        }
        return answer;
    }
	
	public static int numOne(int n) {
		int cnt = 0;
		int num = n;
		while(true) {
			if(num == 0) {
				break;
			}
			if(num%2 == 1) {
				cnt++;
			}
			num = num/2;
		}
		return cnt;
	}
}
