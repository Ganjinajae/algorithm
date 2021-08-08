package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * 예상 대진표
 * @author wldud
 *
 */
public class ExpectationDraw {

	public static void main(String[] args) {
		
		ExpectationDraw test = new ExpectationDraw();
		int n = 8;
		int a = 4;
		int b = 7;
		int answer = test.solution(n, a, b);
		System.out.println(answer);
	}

	public int solution(int n, int a, int b) {
		int answer = 0;

		List<Integer> list = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			list.add(i);
		}

		while(a!=b) {
			a = a/2 + a%2;
			b = b/2 + b%2;
			answer++;
		}
		
		return answer;
	}
}
