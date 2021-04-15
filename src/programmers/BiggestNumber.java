package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 가장 큰 수
 * @author wldud
 *
 */
public class BiggestNumber {

	public static void main(String[] args) {
		BiggestNumber test = new BiggestNumber();
		int[] numbers = {0};
		String answer = test.solution(numbers);
		System.out.println(answer);
	}
	
	public String solution(int[] numbers) {
        String answer = "";
        
        ArrayList<String> strList = new ArrayList<>();
        for(int i=0; i<numbers.length; i++) {
        	strList.add(String.valueOf(numbers[i]));        	
        }
        
        strList.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String s1 = o1+o2;
				String s2 = o2+o1;
				
				return s2.compareTo(s1);
			}
		});
        
        System.out.println(Arrays.toString(strList.toArray()));
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strList.size(); i++) {
        	sb.append(strList.get(i));
        }
        
        if(sb.toString().substring(0, 1).equals("0")) {
            return "0";
        }

        return sb.toString();
    }
}
