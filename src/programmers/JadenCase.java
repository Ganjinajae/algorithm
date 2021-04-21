package programmers;

/**
 * JadenCase 문자열 만들기
 * @author wldud
 *
 */
public class JadenCase {

	public static void main(String[] args) {
		JadenCase test = new JadenCase();
		String s = " A  sdf fFt ";
		String answer = test.solution(s);
		System.out.println(answer);
	}
	
	public String solution(String s) {
        String answer = "";
        
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;
        
        for(String ss : sp) {
        	answer += flag ? ss.toUpperCase() : ss;
        	flag = ss.equals(" ") ? true : false;
        }
        return answer;
    }
	
//	public String solution(String s) {
//        String answer = "";
//        
//        String[] words = s.split(" ", -1);
//        for(int i=0; i<words.length; i++) {
//        	String word = words[i];
//        	if(i != 0) {
//        		answer += " ";
//        	}
//        	if(!word.equals("")) {
//        		if((word.charAt(0)>='a' && word.charAt(0)<='z')
//        				|| (word.charAt(0)>='A' && word.charAt(0)<='Z')) {
//        			answer += String.valueOf(word.charAt(0)).toUpperCase();
//        			if(word.length()>1) {
//        				answer += word.substring(1).toLowerCase();
//        			}
//        		}
//        		else {
//        			answer += word.toLowerCase();
//        		}
//        	}
//        }
//        
//        return answer;
//    }
}
