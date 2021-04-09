package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 다리를 지나는 트럭
 * @author wldud
 *
 */
public class CrossingBridgeTruck {

	public static void main(String[] args) {
		CrossingBridgeTruck test = new CrossingBridgeTruck();
		int bridge_length = 10000;
		int weight = 10000;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10,10,10,10};
		int answer = test.solution(bridge_length, weight, truck_weights);
		System.out.println(answer);
	}

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0; // 초

		Queue<Integer> crossingTruck = new LinkedList<>();
		Queue<Integer> crossedTruck = new LinkedList<>();
		int[] truckPosition = new int[10001];
		int idx = 0;
		int totalWeight = 0;
		while(true) {
			answer++;
			// 다리를 지난 트럭은 빼기
			while(!crossingTruck.isEmpty()) {
				int i = crossingTruck.peek();
				if(truckPosition[i] >= bridge_length) {
					crossedTruck.add(crossingTruck.poll());
					totalWeight -= truck_weights[i];
				}
				if(truckPosition[i] < bridge_length) {
					break;
				}
			}
			if(crossedTruck.size() == truck_weights.length) {
				break;
			}
			// 대기트럭에서 다리를 건너는 트럭으로 추가
			if(idx<truck_weights.length 
					&& totalWeight+truck_weights[idx]<=weight) 
			{
				crossingTruck.add(idx);
				totalWeight += truck_weights[idx];
				idx++;
			}
			// 다리를 건너는 트럭 로직
			for(int truckIdx : crossingTruck) {
				truckPosition[truckIdx]++;
			}
		}

		return answer;
	}
}


//import java.util.*;
//class Solution {
//    public int solution(int bridge_length, int weight, int[] truck_weights) {
//        int answer = 1; // 시간
//
//        Queue<Integer> passedTruck = new LinkedList<>();
//        Queue<Integer> passingTruck = new LinkedList<>();
//        int truckNum = truck_weights.length;
//        int[] waitingTime = new int[truckNum];
//
//        passingTruck.add(0);
//        int curIdx = 0;
//        int curWgt = truck_weights[0];
//        waitingTime[0]++;
//        while(true) {
//        	answer++;
//        	if(waitingTime[passingTruck.peek()] == bridge_length) {
//        		int passedcurIdx = passingTruck.poll();
//        		passedTruck.add(passedcurIdx);
//        		curWgt -= truck_weights[passedcurIdx];
//        	}
//        	if(passedTruck.size() == truckNum && passingTruck.size() == 0) {
//        		break;
//        	}
//
//        	if(curIdx+1 < truckNum) {
//        		int tempWgt = curWgt + truck_weights[curIdx+1];
//        		if(tempWgt <= weight) {
//        			curIdx++;
//        			passingTruck.add(curIdx);
//        			curWgt += truck_weights[curIdx];
//        		}
//        		int startIdx = passingTruck.peek();
//        		for(int i=startIdx; i<=curIdx; i++) {
//        			waitingTime[i]++;
//        		}
//        	}
//        	else {
//        		if(passingTruck.size() > 0) {
//        			int startIdx = passingTruck.peek();
//        			for(int i=startIdx; i<=curIdx; i++) {
//        				waitingTime[i]++;
//        			}
//        		}
//        	}
//        }
//
//
//        return answer;
//    }
//}
