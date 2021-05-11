package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 수식 최대화
 * @author wldud
 *
 */
public class MathExMaximize {
	
	Character[] combArr = null;
	List<String> combList = new ArrayList<>();
	boolean[] visited = null;

	public static void main(String[] args) {
		MathExMaximize test = new MathExMaximize();
		String expression = "100-200*300-500+20";
		long answer = test.solution(expression);
		System.out.println(answer);
	}
	
	public long solution(String expression) {
        long answer = 0;
        
    	Set<Character> ex = new HashSet<>();
        for(int i=0; i<expression.length(); i++) {
        	char c = expression.charAt(i);
        	if(c == '-' || c=='*' || c=='+') {
        		ex.add(c);
        	}
        }
        combArr = new Character[ex.size()];
        visited = new boolean[ex.size()];
        
        combArr = ex.toArray(combArr);
        combination(0, "", combArr);
        
        String[] operand = expression.replaceAll("[0-9]", "").split("");
        String[] numbers = expression.split("[*+-]");
        for(int i=0; i<combList.size(); i++) {
        	answer = Math.max(answer, calculate(combList.get(i), numbers, operand));
        }
        
        return answer;
    }
	
	public long calculate(String comb, String[] numbers, String[] operand) {
		ArrayList<String> numberList = new ArrayList<>(Arrays.asList(numbers));
		ArrayList<String> operandList = new ArrayList<>(Arrays.asList(operand));
		for(int i=0; i<comb.length(); i++) {
			String s = String.valueOf(comb.charAt(i));
			for(int j=0; j<operandList.size(); j++) {
				if(operandList.get(j).equals(s)) {
					long temp = 0;
					long number1 = Long.parseLong(numberList.get(j));
					long number2 = Long.parseLong(numberList.get(j+1));
					if(operandList.get(j).equals("*")) {
						temp = number1*number2;
					}
					else if(operandList.get(j).equals("-")) {
						temp = number1-number2;
					}
					else {
						temp = number1+number2;
					}
					numberList.remove(j+1);
					numberList.remove(j);
					operandList.remove(j);
					numberList.add(j, String.valueOf(temp));
					j--;
				}
			}
		}
		return Math.abs(Long.parseLong(numberList.get(0)));
	}
	
	public void combination(int idx, String comb, Character[] combArr) {
		if(comb.length() == combArr.length) {
			combList.add(comb);
			return;
		}
		
		for(int i=0; i<combArr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				combination(i+1, comb+combArr[i], combArr);
				visited[i] = false;
			}
		}
	}
}
