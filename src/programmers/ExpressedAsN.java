package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * N으로 표현
 * @author wldud
 *
 */
public class ExpressedAsN {

	public static void main(String[] args) {
		ExpressedAsN test = new ExpressedAsN();
		int N = 8;
		int number = 53;
		int answer = test.solution(N, number);
		System.out.println(answer);
	}

	public int solution(int N, int number) {
		int answer = -1;
		
		ArrayList<Set<Integer>> list = new ArrayList<>();
		list.add(null);
		int prev = 0;
		
		for(int i=1; i<9; i++) {
			Set<Integer> set = new HashSet<>();
			int value = 10*prev+N;
			set.add(value);
			list.add(set);
			prev = value;
		}
		
		for(int i=1; i<9; i++) {
			for(int j=1; j<i; j++) {
				for(int a : list.get(j)) {
					for(int b : list.get(i-j)) {
						list.get(i).add(a+b);
						list.get(i).add(a-b);
						list.get(i).add(b-a);
						list.get(i).add(a*b);
						if(a != 0) {
							list.get(i).add(b/a);
						}
						if(b != 0) {
							list.get(i).add(a/b);
						}
					}
				}
			}
		}
		
		for(int i=1; i<list.size(); i++) {
			if(list.get(i).contains(number)) {
				answer = i;
				break;
			}
		}
		
		return answer;
	}

}

// 이 방법의 한계는 더하고 빼려고 하는 값이 무조건 N이기 때문에 안 됨.
// ex) 8*8-88/8 이 경우를 고려할 수 없음
//	public int solution(int N, int number) {
//        int answer = -1;
//
//        Set<Integer> origin = new HashSet<>();
//        Set<Integer> temp = new HashSet<>();
//        origin.add(N);
//        
//        int cnt = 1; 
//        while(true) {
//        	if(origin.contains(number) || cnt > 8) {
//        		break;
//        	}
//        	cnt++;
//        	temp.clear();
//        	for(int num : origin) {
//        		temp.add(num+N);
//        		temp.add(num-N);
//        		temp.add(num*N);
//        		temp.add(num/N);
//        		temp.add(Integer.parseInt(String.valueOf(num)+N));
//        	}
//        	for(int n : temp) {
//        		System.out.print(n + " ");
//        	}
//        	System.out.println();
//        	origin.addAll(temp);
//        }
//        
//        if(cnt <= 8) {
//        	answer = cnt;
//        }
//        
//        return answer;
//    }

// 전에 블로그 보면서 참고했던 풀이
//import java.util.*;
//class Solution {
//    public int solution(int N, int number) {
//        int answer = -1;
//
//        Set<Integer>[] setArr = new Set[9];
//
//        int t = N;
//        for(int i=1; i<9; i++) {
//            setArr[i] = new HashSet<>();
//            setArr[i].add(t);
//            t = t*10 + N;
//        }
//
//        for(int i=1; i<9; i++) {
//            for(int j=1; j<i; j++) {
//                for(Integer a : setArr[j]) {
//                    for(Integer b : setArr[i-j]) {
//                        setArr[i].add(a + b);
//                        setArr[i].add(a - b);
//                        setArr[i].add(b - a);
//                        setArr[i].add(a * b);
//                        if(b != 0) {
//                            setArr[i].add(a / b);
//                        }
//                        if(a != 0) {
//                            setArr[i].add(b / a);
//                        }
//                    }
//                }
//            }
//        }
//
//        for(int i=1; i<9; i++) {
//            if(setArr[i].contains(number)) {
//                answer = i;
//                break;
//            }
//        }
//
//        return answer;
//    }
//}