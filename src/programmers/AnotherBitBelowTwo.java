package programmers;

import java.util.Arrays;

/**
 * 2개 이하로 다른 비트
 * @author wldud
 *
 */
public class AnotherBitBelowTwo {

	public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
        	long num = numbers[i];
        	if(num%2 == 0) {
        		answer[i] = num+1;
        	}
        	else {
        		StringBuilder sb = new StringBuilder();
        		String binaryString = Long.toBinaryString(num);
        		if(!binaryString.contains("0")) {
        			sb.append("10");
        			sb.append(binaryString.substring(1).replace("0", "1"));
        		}
        		else {
        			int lastIndex = binaryString.lastIndexOf("0");
        			int firstOneIndex = binaryString.indexOf("1", lastIndex);
        			
        			sb.append(binaryString, 0, lastIndex).append("1");
        			sb.append("0");
        			sb.append(binaryString.substring(firstOneIndex+1));
        		}
        		answer[i] = Long.parseLong(sb.toString(), 2);
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
	
		AnotherBitBelowTwo test = new AnotherBitBelowTwo();
		long[] numbers = {2, 7};
		long[] answer = test.solution(numbers);
		System.out.println(Arrays.toString(answer));
	}
}
