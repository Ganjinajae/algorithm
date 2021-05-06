package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ªÔ∞¢ ¥ﬁ∆ÿ¿Ã
 * @author wldud
 *
 */
public class TriangleSnail {

	public static void main(String[] args) {
		TriangleSnail test = new TriangleSnail();
		int n = 6;
		int[] answer = test.solution(n);
		System.out.println(Arrays.toString(answer));
	}
	
	public int[] solution(int n) {
        int[] answer = {};
        
        List<int[]> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
        	list.add(new int[i]);
        }
        
        int num = 1;
        int r = -1;
        int c = 0;
        while(n>0) {
        	// πÿ¿∏∑Œ
        	for(int i=n; i>=1; i--) {
        		list.get(++r)[c] = num++;
        	}
        	n--;
        	// ø¿∏•¬ 
        	for(int i=n; i>=1; i--) {
        		list.get(r)[++c] = num++;
        	}
        	n--;
        	// ¥Î∞¢º±
        	for(int i=n; i>=1; i--) {
        		list.get(--r)[--c] = num++;
        	}
        	n--;
        }
        
        answer = new int[num-1];
        int idx = 0;
        for(int i=0; i<list.size(); i++) {
        	for(int j=0; j<i+1; j++) {
        		answer[idx++] = list.get(i)[j];
        	}
        }
        
        return answer;
    }
}
