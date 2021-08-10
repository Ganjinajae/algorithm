package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ÈÄº¸Å°
 * @author wldud
 *
 */
public class CandidateKey {

	String[][] sRelation;
	List<Set<Integer>> candidateKey; 
	int answer;

	public static void main(String[] args) {
		CandidateKey test = new CandidateKey();
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		int answer = test.solution(relation);
		System.out.println(answer);
	}

	public int solution(String[][] relation) {
		sRelation = relation;
		candidateKey = new ArrayList<>();
		for(int i=1; i<=sRelation[0].length; i++) {
			dfs(-1, i, 0, new HashSet<Integer>());
		}

		return answer;
	}

	public boolean check(Set<Integer> set) {

		List<String> list = new ArrayList<>();
		for(int i=0; i<sRelation.length; i++) {
			String temp = "";
			for(int idx : set) {
				temp += sRelation[i][idx];
			}
			if(!list.contains(temp)) {
				list.add(temp);
			}
			else {
				return false;
			}
		}
		return true;
	}

	public void dfs(int idx, int target, int cnt, Set<Integer> set) {
		if(cnt == target) {
			if(check(set)) {
				for(Set<Integer> s : candidateKey) {
					if(set.containsAll(s)) {
						return;
					}
				}
				candidateKey.add(set);
				answer++;
				return;
			}
		}
		for(int i=idx+1; i<sRelation[0].length; i++) {
			Set<Integer> newSet = new HashSet<>(set);
			newSet.add(i);
			dfs(i, target, cnt+1, newSet);
		}
	}
}
