package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class 뒤에있는큰수찾기 {
	private static int[] temp;
	public static void main(String[] args) {
//		int[] numbers = {2, 3, 3, 5};
//		int[] numbers = {9, 1, 5, 3, 6, 2};
//		int[] numbers = {1, 1, 1, 1};
//		int[] numbers = {1, 2, 3, 4};
//		int[] numbers = {4,3,2,1};
//		int[] numbers = {3,4,1,2};
		int[] numbers = {2,3,6,4,5,6,7};


		int[] answer = new 뒤에있는큰수찾기().solution(numbers);
		System.out.println(Arrays.toString(answer));
	}
	
	
	public int[] solution(int[] numbers) {
        List<Integer> answer = new ArrayList<>();
        
        Stack<Integer> stack = new Stack<>();
        for (int i = numbers.length-1; i >= 0; i--) {
        	while (!stack.empty()) {
        		if (stack.peek() > numbers[i]) {
            		answer.add(stack.peek());
            		break;
            	} else {
            		stack.pop();
            	}
        	}
        	if (stack.isEmpty()) {
        		answer.add(-1);
        	}
        	stack.add(numbers[i]);
		}
        
        Collections.reverse(answer);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
	
//	public int[] solution(int[] numbers) {
//		List<Integer> answer = new ArrayList<>();
//		
//		int n = numbers.length;
//		answer.add(-1);
//		int bigNumber = numbers[n-1];
//		for (int i = n-2; i >= 0; i--) {
//			if (numbers[i+1] > numbers[i]) {
//				answer.add(numbers[i+1]);
//				bigNumber = numbers[i+1];
//				continue;
//			}
//			if (bigNumber > numbers[i]) {
//				answer.add(bigNumber);
//				continue;
//			}
//			answer.add(-1);
//		}
//		
//		Collections.reverse(answer);
//		
//		return answer.stream().mapToInt(i-> i).toArray();
//	}
	
	
//	public int[] solution(int[] numbers) {
//        List<Integer> list = new ArrayList<>();
//        
//        for (int i = 0; i < numbers.length; i++) {
//			for (int j = i+1; j < numbers.length; j++) {
//				if(numbers[j] > numbers[i]) {
//					list.add(numbers[j]);
//					break;
//				}
//			}
//			if(i+1 != list.size()) {
//				list.add(-1);
//			}
//		}
//        
//        return list.stream().mapToInt(i -> i).toArray();
//    }

}
