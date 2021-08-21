package codility;

import java.util.HashSet;
import java.util.Set;

public class AbsDistinct {

	public int solution(int[] A) {
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<A.length; i++) {
			int num = Math.abs(A[i]);
			set.add(num);
		}
		
		return set.size();
    }
	
	public static void main(String[] args) {
		AbsDistinct test = new AbsDistinct();
		int[] A = {-5, -3, -1, 0, 3, 6}; 
		int answer = test.solution(A);
		System.out.println(answer);
	}
}
