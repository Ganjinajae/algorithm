package programmers;

/**
 * 조이스틱
 * @author wldud
 *
 */
public class Joystick {

	public static void main(String[] args) {
		Joystick test = new Joystick();
		int answer = test.solution("JAN");
		System.out.println(answer);
	}
	
	public int solution(String name) {
        int answer = 0;
        String goal = name.replaceAll("[A-Z]", "A");
        String[] arr = name.split("");
        int i = 0;
        while(true) {
        	String tempName = arrToString(arr);
        	answer += distance(tempName.charAt(i));
        	arr[i] = "A";
        	if(arrToString(arr).equals(goal)) {
        		break;
        	}
        	int lDist = leftDistance(i, tempName);
        	int rDist = rightDistance(i, tempName);
        	
        	if(lDist < rDist) {
        		i--;
        		if(i<0) {
        			i = name.length()-1;
        		}
        	}
        	else {
        		i++;
        		if(i >= name.length()) {
        			i = 0;
        		}
        	}
        	answer++; // 이동
        }
        
        
        return answer;
    }
	
	public int leftDistance(int idx, String name) {
		int cnt = 0;
		boolean flag = false;
		for(int i=idx-1; i>=0; i--) {
			cnt++;
			if(name.charAt(i) != 'A') {
				flag = true;
				break;
			}
		}
		
		if(!flag) {
			for(int i=name.length()-1; i>idx; i--) {
				cnt++;
				if(name.charAt(i) != 'A') {
					break;
				}
			}
		}
		
		return cnt;
	}
	
	public int rightDistance(int idx, String name) {
		int cnt = 0;
		boolean flag = false;
		for(int i=idx+1; i<name.length(); i++) {
			cnt++;
			if(name.charAt(i) != 'A') {
				flag = true;
				break;
			}
		}
		
		if(!flag) {
			for(int i=0; i<idx; i++) {
				cnt++;
				if(name.charAt(i) != 'A') {
					break;
				}
			}
		}
		
		return cnt;
	}
	
	public String arrToString(String[] arr) {
		StringBuilder sb = new StringBuilder();
		for(String s : arr) {
			sb.append(s);
		}
		return sb.toString();
	}
	
	public int distance(char c) {
		int result = c-'A';
		int result2 = 'Z'-c+1;
		
		return Math.min(result, result2);
	}
	
}
