package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class 숫자변환하기 {
	
	public static void main(String[] args) {
		System.out.println(new 숫자변환하기().solution(10, 40, 5));
		System.out.println(new 숫자변환하기().solution(10, 40, 30));
		System.out.println(new 숫자변환하기().solution(2, 5, 4));
	}
	
	
	
	/**
	 * DP 풀이 (top-down)
	 * @param x
	 * @param y
	 * @param n
	 * @return
	 */
	public int solution(int x, int y, int n) {
        return dp(x, y, n , new HashMap<>());
    }
	
	private int dp(int x, int y, int n, Map<Integer, Integer> memo) {
		// base
		if (x == y) {
			return 0;
		}
		if (x > y) {
			return -1;
		}
		
		// memo
		if (memo.containsKey(x)) {
			return memo.get(x);
		}
		
		// recursive
		int minOperation = Integer.MAX_VALUE;
		if (x*3 <= y) {
			int operation = dp(x*3, y, n, memo);
			if (operation != -1) {
				minOperation = Math.min(minOperation, operation + 1);
			}
		}
		if (x*2 <= y) {
			int operation = dp(x*2, y, n, memo);
			if (operation != -1) {
				minOperation = Math.min(minOperation, operation + 1);
			}	
		}
		if (x+n <= y) {
			int operation = dp(x+n, y, n, memo);
			if (operation != -1) {
				minOperation = Math.min(minOperation, operation + 1);
			}
		}

		
		if (minOperation == Integer.MAX_VALUE) {
			minOperation = -1;
		}
		memo.put(x, minOperation);

		return minOperation;
	}
	
	
	/**
	 * DP 풀이 (bottmp-up)
	 * @param x
	 * @param y
	 * @param n
	 * @return
	 */
//	public int solution(int x, int y, int n) {
//        int[] dp = new int[1_000_001];
//        
//        for (int i=x; i<=y; i++) {
//        	if (i!=x && dp[i] == 0) {
//        		dp[i] = -1;
//        		continue;
//        	}
//        	if (i+n <= y) {
//        		dp[i+n] = dp[i+n] == 0 ? dp[i]+1 : Math.min(dp[i]+1, dp[i+n]);
//        	}
//        	if (i*2 <= y) {
//        		dp[i*2] = dp[i*2] == 0 ? dp[i]+1 : Math.min(dp[i]+1, dp[i*2]);
//        	}
//        	if (i*3 <= y) {
//        		dp[i*3] = dp[i*3] == 0 ? dp[i]+1 : Math.min(dp[i]+1, dp[i*3]);
//        	}
//        }
//        
//        return dp[y];
//    }
	
	
	
	/**
	 * BFS 풀이
	 * @param x
	 * @param y
	 * @param n
	 * @return
	 */
//	public int solution(int x, int y, int n) {
//        Set<Integer> set = new HashSet<>();
//        set.add(x);
//        
//        int answer = 0;
//        Iterator<Integer> iter = set.iterator();
//        while(iter.hasNext()) {
//        	Set<Integer> tempSet = new HashSet<>();
//        	while (iter.hasNext()) {
//        		int num = iter.next();
//            	if (num == y) {
//            		return answer;
//            	}
//        		if (num + n <= y) {
//            		tempSet.add(num + n);
//            	}
//            	if (num*2 <= y) {
//            		tempSet.add(num*2);
//            	}
//            	if (num*3 <= y) {
//            		tempSet.add(num*3);
//            	}
//        	}
//        	
//        	answer++;
//        	iter = tempSet.iterator();
//        }
//        
//        
//        return -1;
//    }
	
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
