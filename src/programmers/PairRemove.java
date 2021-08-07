package programmers;

import java.util.Stack;

public class PairRemove {

	public static void main(String[] args) {
		PairRemove test = new PairRemove();
		String s = "cdcd";
		int answer = test.solution(s);
		System.out.println(answer);
	}
	
	public int solution(String s) {
        int answer = 1;

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	if(!stack.isEmpty() && stack.peek() == c) {
        		stack.pop();
        	}
        	else {
        		stack.push(c);
        	}
        }
        
        if(!stack.isEmpty()) {
        	answer = 0;
        }
        
        return answer;
    }
}
