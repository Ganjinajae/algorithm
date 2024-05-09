package programmers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class 숫자변환하기 {
	
	public static void main(String[] args) {
		System.out.println(new 숫자변환하기().solution(10, 40, 5));
		System.out.println(new 숫자변환하기().solution(10, 40, 30));
		System.out.println(new 숫자변환하기().solution(2, 5, 4));
	}
	
	
	public int solution(int x, int y, int n) {
        Set<Integer> set = new HashSet<>();
        set.add(x);
        
        int answer = 0;
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()) {
        	Set<Integer> tempSet = new HashSet<>();
        	while (iter.hasNext()) {
        		int num = iter.next();
            	if (num == y) {
            		return answer;
            	}
        		if (num + n <= y) {
            		tempSet.add(num + n);
            	}
            	if (num*2 <= y) {
            		tempSet.add(num*2);
            	}
            	if (num*3 <= y) {
            		tempSet.add(num*3);
            	}
        	}
        	
        	answer++;
        	iter = tempSet.iterator();
        }
        
        
        return -1;
    }
	
//	private static int MIN_NUMBER = Integer.MAX_VALUE;
	
//	public int solution(int x, int y, int n) {
//		int answer = -1;
//        dfs(x, y, n, 0);
//        if (MIN_NUMBER < Integer.MAX_VALUE) {
//        	answer = MIN_NUMBER;
//        }
//		return answer; 
//    }
//	
//	public void dfs(int start, int end, int n, int number) {
//		if (number > MIN_NUMBER || start > end) {
//			return;
//		}
//		if (start == end) {
//			if (number < MIN_NUMBER) {
//				MIN_NUMBER = number;
//			}
//			return;
//		}
//		
//        dfs(start*3, end, n, number+1);
//        dfs(start*2, end, n, number+1);
//        dfs(start+n, end, n, number+1);
//	}
}
