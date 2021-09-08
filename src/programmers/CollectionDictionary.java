package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * 모음사전
 * @author wldud
 *
 */
public class CollectionDictionary {
	
	String[] arr = {"A", "E", "I", "O", "U"};
	List<String> list = new ArrayList<>();
	String w;
	int answer;
	
	public void dfs(String s) {
		if(answer != 0) {
			return;
		}
		if(s.equals(w)) {
			answer = list.size()+1;
			return;
		}
		if(s.length() == 6) {
			return;
		}
		
		list.add(s);
		for(int i=0; i<5; i++) {
			dfs(s+arr[i]);
		}
	}
	
	public int solution(String word) {
        w = word;
        for(int i=0; i<5; i++) {
        	dfs(arr[i]);
        }
        
        for(int i=0; i<list.size(); i++) {
        	if(list.get(i).equals(word)) {
        		answer = i+1;
        		break;
        	}
        }
        
//        System.out.println(Arrays.toString(list.stream().map(i->i).toArray()));
        
        return answer;
    }

	public static void main(String[] args) {
		
		CollectionDictionary test = new CollectionDictionary();
		String word = "I";
		int answer = test.solution(word);
		System.out.println(answer);
	}
}
