package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 불량 사용자
 * @author wldud
 *
 */
public class BadUser {

	Set<String> set = new HashSet<>();

	public static void main(String[] args) {
		BadUser test = new BadUser();
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
		int answer = test.solution(user_id, banned_id);
		System.out.println(answer);
	}

	public int solution(String[] user_id, String[] banned_id) {
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		for(int i=0; i<banned_id.length; i++) {
			ArrayList<String> temp = new ArrayList<>();
			for(int j=0; j<user_id.length; j++) {
				if(isPossible(banned_id[i], user_id[j])) {
					temp.add(user_id[j]);
				}
			}
			list.add(temp);
		}

		dfs(0, list, new ArrayList<String>());

//		for(String s : set) {
//			System.out.println(s);
//		}

		return set.size();
	}

	public void dfs(int idx, ArrayList<ArrayList<String>> list, ArrayList<String> result) {
		if(idx == list.size()) {
//			System.out.println(result.stream().collect(Collectors.joining()));
			result.sort(null);
			set.add(result.stream().collect(Collectors.joining()));
			return;
		}

		for(int i=0; i<list.get(idx).size(); i++) {
			if(!result.contains(list.get(idx).get(i))) {
				result.add(list.get(idx).get(i));
				dfs(idx+1, list, result);
				result.remove(list.get(idx).get(i));
			}
		}
	}

	public boolean isPossible(String bannedId, String userId) {
		boolean result = true;

		if(bannedId.length() != userId.length()) {
			return false;
		}

		for(int i=0; i<bannedId.length(); i++) {
			if(bannedId.charAt(i)!='*' && bannedId.charAt(i)!=userId.charAt(i)) {
				return false;
			}
		}

		return result;
	}
}
