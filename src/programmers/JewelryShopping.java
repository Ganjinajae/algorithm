package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ∫∏ºÆ ºÓ«Œ
 * @author wldud
 *
 */
public class JewelryShopping {

	public static void main(String[] args) {
		JewelryShopping test = new JewelryShopping();
//		String[] gems = {"AA", "AB", "AC", "AA", "AC"};
		String[] gems = {"DIA", "EM", "EM", "RUB", "DIA"};
//		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		int[] answer = test.solution(gems);
		System.out.println(Arrays.toString(answer));
	}
	
	public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        Set<String> set = new HashSet<>();
        for(int i=0; i<gems.length; i++) {
        	set.add(gems[i]);
        }

        Map<String, Integer> map = new HashMap<>();
        int total = set.size();
        int start = 0;
        int end = 0;
        int min = 987654321;
        while(true) {
        	if(end >= gems.length) {
        		break;
        	}
        	String endS = gems[end];
        	map.put(endS, map.getOrDefault(endS, 0)+1);
        	end++;
        	if(map.keySet().size() == total) {
        		while(start < end) {
        			if(end-start < min) {
        				min = end-start;
        				answer[0] = start+1;
        				answer[1] = end;
        			}
        			String s = gems[start];
        			map.put(s, map.get(s)-1);
        			if(map.get(s) == 0) {
        				map.remove(s);
        			}
        			start++;
                	if(map.keySet().size() != total) {
        				break;
        			}
        		}
        	}
        }
        
        return answer;
    }
}
