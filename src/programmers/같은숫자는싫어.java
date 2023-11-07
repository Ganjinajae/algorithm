package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 같은숫자는싫어 {
	public static void main(String[] args) {
		같은숫자는싫어 test = new 같은숫자는싫어();
		int[] result = test.solution(new int[] {1,1,3,3,0,1,1});
		System.out.println(Arrays.toString(result));
	}
	
	public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>(); 

        int formerValue = arr[0];
        answer.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
			if (formerValue == arr[i]) {
				continue;
			}
			formerValue = arr[i];
			answer.add(arr[i]);
		}

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
