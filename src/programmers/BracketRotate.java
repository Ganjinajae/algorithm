package programmers;

import java.util.Stack;

/**
 * 괄호 회전하기
 * @author wldud
 *
 */
public class BracketRotate {

	public static void main(String[] args) {
	
		BracketRotate test = new BracketRotate();
		String s = "[](){}";
		int answer = test.solution(s);
		System.out.println(answer);
	}
	
	public boolean isCorrect(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c == ')') {
				if(stack.isEmpty()) {
					return false;
				}
				if(stack.peek() != '(') {
					return false;
				}
				stack.pop();
			}
			else if(c == '}') {
				if(stack.isEmpty()) {
					return false;
				}
				if(stack.peek() != '{') {
					return false;
				}
				stack.pop();
			}
			else if(c == ']') {
				if(stack.isEmpty()) {
					return false;
				}
				if(stack.peek() != '[') {
					return false;
				}
				stack.pop();
			}
			else {
				stack.add(c);
			}
		}
		
		if(stack.isEmpty()) {
			return true;
		}
		return false;
		
	}
	
	public int solution(String s) {
        int answer = 0;
        int cnt = 0;
        
        while(true) {
        	if(cnt == s.length()) {
        		break;
        	}
        	if(isCorrect(s)) {
        		answer++;
        	}
        	String f = String.valueOf(s.charAt(0));
        	s = s.substring(1, s.length()) + f;
        	
        	cnt++;
        }
        
        return answer;
    }
}
