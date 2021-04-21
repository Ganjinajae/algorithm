package programmers;

import java.util.Stack;

/**
 * ¿Ã¹Ù¸¥ °ýÈ£
 * @author wldud
 *
 */
public class ProperBracket {

	public static void main(String[] args) {
		ProperBracket test = new ProperBracket();
		System.out.println(test.solution("(()("));
	}
	
	boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
        	char b = s.charAt(i);
        	if(b == '(') {
        		stack.add(b);
        	}
        	else {
        		if(stack.isEmpty()) {
        			return false;
        		}
        		stack.pop();
        	}
        }
        
        if(!stack.isEmpty()) {
        	return false;
        }

        return answer;
    }
}
