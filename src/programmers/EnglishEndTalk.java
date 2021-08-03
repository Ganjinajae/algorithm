package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 영어 끝말잇기
 * @author wldud
 *
 */
public class EnglishEndTalk {
	
	public static void main(String[] args) {
		EnglishEndTalk test = new EnglishEndTalk();
		int n = 2;
		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
//		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int[] answer = test.solution(n, words);
		System.out.println(Arrays.toString(answer));
	}

	public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int len = words.length;

        List<Person> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
        	list.add(new Person(0));
        }
        Map<String, Integer> word = new HashMap<>();
        for(int i=0; i<len; i++) {
        	int idx = i%n;
        	Person p = list.get(idx);
        	list.get(idx).setCnt(p.getCnt()+1);
        	String w = words[i];
        	word.put(w, word.getOrDefault(w, 0)+1);
        	if(word.get(w) == 2
        			|| (i>0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0))) 
        	{
        		answer[0] = idx+1;
        		answer[1] = list.get(idx).getCnt();
        		break;
        	}
        }
        
        return answer;
    }
}

class Person {
	int cnt;

	Person(int cnt) {
		this.cnt = cnt;
	}
	
	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
}