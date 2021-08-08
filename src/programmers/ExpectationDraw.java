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

		boolean flag = false;
		while(true) {
			List<Integer> temp = new ArrayList<>();
			for(int i=0; i<list.size()-1; i+=2) {
				if((list.get(i) == a && list.get(i+1) == b)
						|| (list.get(i) == b && list.get(i+1) == a)) {
					flag = true;
					break;
				}
				else {
					if(list.get(i) == a || list.get(i) == b) {
						temp.add(list.get(i));
					}
					else if(list.get(i+1) == a || list.get(i+1) == b) {
						temp.add(list.get(i+1));
					}
					else {
						temp.add(0);
					}
				}
			}
			answer++;
			if(flag) {
				break;
			}
			list = temp;
		}
		return answer;
	}
}
