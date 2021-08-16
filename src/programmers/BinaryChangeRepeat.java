package programmers;

import java.util.Arrays;

/**
 * 이진 변환 반복하기
 * @author wldud
 *
 */
public class BinaryChangeRepeat {

	public int[] solution(String s) {
        int[] answer = new int[2];
        int round = 0;
        int zero = 0;
        while(true) {
        	StringBuilder sb = new StringBuilder();
        	if(s.equals("1")) {
        		break;
        	}
        	for(int i=0; i<s.length(); i++) {
        		if(s.charAt(i) == '0') {
        			zero++;
        		}
        		else {
        			sb.append(s.charAt(i));
        		}
        	}
        	s = Integer.toBinaryString(sb.toString().length());
        	round++;
        }
        
        answer[0] = round;
        answer[1] = zero;
        return answer;
    }
	
	public static void main(String[] args) {
		BinaryChangeRepeat test = new BinaryChangeRepeat();
		String s = "110010101001";
		int[] answer = test.solution(s);
		System.out.println(Arrays.toString(answer));
	}
}
