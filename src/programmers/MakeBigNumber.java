package programmers;

/**
 * 큰 수 만들기
 * @author wldud
 *
 */
public class MakeBigNumber {

    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        int idx = 0;
        int max = 0;
        for(int i=0; i<number.length()-k; i++) {
        	max = 0;
        	for(int j=idx; j<=i+k; j++) {
        		int num = number.charAt(j)-'0';
        		if(num > max) {
        			max = num;
        			idx = j+1;
        		}
        	}
        	answer.append(max);
        }
        
        return answer.toString();
    }
	
	public static void main(String[] args) {
		MakeBigNumber test = new MakeBigNumber();
		String number = "1231234";
		int k = 3;
		String answer = test.solution(number, k);
		System.out.println(answer);
	}
}
