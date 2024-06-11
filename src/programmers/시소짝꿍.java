package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ½Ã¼ÒÂ¦²á {
	public static void main(String[] args) {
		System.out.println(new ½Ã¼ÒÂ¦²á().solution(new int[]{100,180,360,100,270}));
	}
	
	
	public long solution(int[] weights) {
        long answer = 0;
        
        Map<Double, Integer> map = new HashMap<>();
        double[] divide = new double[] {1.0, 2.0/3, 3.0/4, 1.0/2};
        Arrays.sort(weights);
        for (int weight : weights) {
        	for (double d : divide) {
				double b = weight * d;
				if (map.containsKey(b)) {
					answer += map.get(b);
				}
			}
			map.put((double)weight, map.getOrDefault((double)weight, 0) + 1);
		}
        
        return answer;
    }
}
