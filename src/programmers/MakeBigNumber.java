package programmers;

import java.util.Stack;

/**
 * 큰 수 만들기
 * @author wldud
 *
 */
public class MakeBigNumber {

    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<number.length(); i++) {
        	char c = number.charAt(i);
        	while(!stack.isEmpty() && c>stack.peek() && k>0) {
        		stack.pop();
        		k--;
        	}
        	stack.push(c);
        }
        
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        
        return new String(result);
    }
	
	public static void main(String[] args) {
		MakeBigNumber test = new MakeBigNumber();
		String number = "1231234";
		int k = 3;
		String answer = test.solution(number, k);
		System.out.println(answer);
	}
}
