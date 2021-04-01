package programmers;

/**
 * 문자열 압축
 * @author wldud
 *
 */
public class StringCompression {

	public static void main(String[] args) {
		StringCompression test = new StringCompression();
		
		String s = "aaaaaaaaaab";
		int answer = test.solution(s);
		System.out.println(answer);
	}
	
	public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        for(int i=0; i<s.length(); i++) {
        	String str = splitString(i+1, s);
        	System.out.println(str);
        	if(str.length() < answer) {
        		answer = str.length();
        	}
        }
        
        return answer;
    }
	
	public String splitString(int unit, String str) {
		StringBuilder sb = new StringBuilder();
		String prev = str.substring(0, unit);
		int count = 1;
		
		for(int i=unit; i<str.length(); i+=unit) {
			if(i+unit > str.length()) {
				if(count >= 2) {
					sb.append(count);
				}
				sb.append(prev);
				count = 1;
				prev = str.substring(i);
				break;
			}
			String cur = str.substring(i, i+unit);
			if(!prev.equals(cur)) {
				if(count >= 2) {
					sb.append(count);
				}
				sb.append(prev);
				count = 0;
				prev = cur;
			}
			count++;
		}
		if(count >= 2) {
			sb.append(count);
		}
		sb.append(prev);		
		
		return sb.toString();
	}
}
