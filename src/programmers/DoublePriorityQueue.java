package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 이중우선순위큐
 * @author wldud
 *
 */
public class DoublePriorityQueue {
	
	public PriorityQueue<Integer> pq = new PriorityQueue<>();
	public PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());

	public static void main(String[] args) {
		DoublePriorityQueue test = new DoublePriorityQueue();
//		String[] operations = {"I 16","D 1"};
//		String[] operations = {"I 7","I 5","I -5","D -1"};
		String[] operations = {"I 1", "I 2", "I 3", "I 4", "I 5", "D -1", "D -1","D -1", "D -1"};
		int[] answer = test.solution(operations);                                            
		System.out.println(Arrays.toString(answer));
	}
	
	public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        for(int i=0; i<operations.length; i++) {
        	String operation = operations[i];
        	String[] strArr = operation.split(" ");
        	if(strArr[0].equals("I")) {
        		pq.add(Integer.parseInt(strArr[1]));
        		rpq.add(Integer.parseInt(strArr[1]));
        	}
        	else if(!pq.isEmpty()) {
        		if(strArr[1].equals("-1")) {
        			int f = pq.poll();
        			rpq.remove(f);
        		}
        		else {
        			int e = rpq.poll();
        			pq.remove(e);
        		}
        	}
        }
        
        if(!rpq.isEmpty()) {
        	answer[0] = rpq.poll();
        	answer[1] = pq.poll();
        }
        
        
        return answer;
    }
}
