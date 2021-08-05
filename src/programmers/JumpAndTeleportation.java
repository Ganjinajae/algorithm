package programmers;

/**
 * ������ �����̵�
 * @author wldud
 *
 */
public class JumpAndTeleportation {

	public static void main(String[] args) {
		JumpAndTeleportation test = new JumpAndTeleportation();
		int n = 5000;
		int answer = test.solution(n);
		System.out.println(answer);
	}
	
	public int solution(int n) {
        int ans = 0;

        while(n!=0) {
        	if(n%2 == 0) {
        		n /= 2;
        	}
        	else {
        		n--;
        		ans++;
        	}
        }

        return ans;
    }
}
