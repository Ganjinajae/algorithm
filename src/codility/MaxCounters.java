package codility;

import java.util.Arrays;

public class MaxCounters {

	public int[] solution(int N, int[] A) {
			
		int[] arr = new int[N];
		int temp = 0;
		int max = 0;
		for(int i=0; i<A.length; i++) {
			int idx = A[i]-1;
			if(idx == N) {
				arr = new int[N];
				max = temp;
			}
			else {
				arr[idx]++;
				temp = Math.max(arr[idx], temp);
			}
		}
		for(int i=0; i<arr.length; i++) {
			arr[i] += max;
		}
		
		return arr;
	}

	public static void main(String[] args) {
		MaxCounters test = new MaxCounters();
		int N = 5;
		int[] A = {3, 4, 4, 6, 1, 4, 4};
		int[] answer = test.solution(N, A);
		System.out.println(Arrays.toString(answer));
	}
}
