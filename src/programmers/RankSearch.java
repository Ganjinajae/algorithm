package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 순위검색
 * @author wldud
 *
 */
public class RankSearch {

	Map<String, List<Integer>> map = new HashMap<>();
	
	public void dfs(String s, int depth, String[] info) {
		if(depth == 4) {
			if(map.containsKey(s)) {
				map.get(s).add(Integer.valueOf(info[4]));
			}
			else {
				List<Integer> list = new ArrayList<>();
				list.add(Integer.valueOf(info[4]));
				map.put(s, list);
			}
			
			return;
		}
		
		dfs(s+"-", depth+1, info);
		dfs(s+info[depth], depth+1, info);
	}
	
	public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for(int i=0; i<info.length; i++) {
        	dfs("", 0, info[i].split(" "));
        }
        
        for(List<Integer> list : map.values()) {
        	list.sort(null);
        }
        
        int idx = 0;
        for(String s : query) {
        	String[] q = s.split(" ");
        	String key = "";
        	for(int i=0; i<q.length-1; i++) {
        		if(q[i].equals("and")) {
        			continue;
        		}
        		key += q[i];
        	}
        	if(!map.containsKey(key)) {
        		answer[idx++] = 0;
        		continue;
        	}
        	int point = Integer.valueOf(q[q.length-1]);
        	List<Integer> list = map.get(key);
        	int start = 0;
        	int end = list.size()-1;
        	while(start <= end) {
        		int mid = (start+end)/2;
        		if(point > list.get(mid)) {
        			start = mid+1;
        		}
        		else {
        			end = mid-1;
        		}
        	}
        	
        	answer[idx++] = list.size()-start;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		RankSearch test = new RankSearch();
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		int[] answer = test.solution(info, query);
		System.out.println(Arrays.toString(answer));
	}
}
