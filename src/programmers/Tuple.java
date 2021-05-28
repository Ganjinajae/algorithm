package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Æ©ÇÃ
 * @author wldud
 *
 */
public class Tuple {

	public static void main(String[] args) {
		
		Tuple test = new Tuple();
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
//		String s = "{{2},{2,1,3},{2,1},{2,1,3,4}}";
		int[] ans = test.solution(s);
		System.out.println(Arrays.toString(ans));
	}
	
	public int[] solution(String s) {
        int[] answer = {};
        
        s = s.substring(2, s.length()-2).replace("},{","-");
        String[] temp = s.split("-");
        Arrays.sort(temp, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		});
        
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<temp.length; i++) {
        	String[] strs = temp[i].split(",");
        	
        	for(int j=0; j<strs.length; j++) {
        		int num = Integer.valueOf(strs[j]);
        		if(!list.contains(num)) {
        			list.add(num);
        		}
        	}
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}
