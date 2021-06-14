package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * æ–√‡
 * @author wldud
 *
 */
public class P1662 {

	static String s;
	static int[] reverse;
	
	public static int traversal(int start, int end) {
		int lineLength = 0;
		
		for(int i=start; i<end; i++) {
			if(s.charAt(i) == '(') {
				lineLength += (s.charAt(i-1) - '0') * traversal(i+1, reverse[i])-1;
				i = reverse[i];
			}
			else {
				lineLength++;
			}
		}
		return lineLength;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
		Stack<Integer> stack = new Stack<>();
		
		reverse = new int[50];
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(') stack.add(i);
			else if(s.charAt(i) == ')') reverse[stack.pop()] = i;
		}
		
		
		System.out.println(traversal(0, s.length()));
	}
}
