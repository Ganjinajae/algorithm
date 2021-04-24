package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 여행경로
 * @author wldud
 *
 */
public class TravelPath {

	List<String> tempList = null;
	String[] ans = null;
	boolean[] visited = null;

	public static void main(String[] args) {
		TravelPath test = new TravelPath();
		//		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		//		String[][] tickets = {{"ICN", "A"},{"ICN", "B"},{"B", "ICN"}};
		String[][] tickets = {{"ICN", "A"},{"ICN", "A"},{"A", "ICN"},{"A","C"}};
		//		String[][] tickets = {{"ICN","B"},{"B","ICN"},{"ICN","A"},{"A","D"},{"D","A"}};
		System.out.println(Arrays.toString(test.solution(tickets)));
	}

	public String[] solution(String[][] tickets) { 
		visited = new boolean[tickets.length];
		Arrays.sort(tickets, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return o1[1].compareTo(o2[1]);
			}
		});

		for(int i=0; i<tickets.length; i++) {
			tempList = new ArrayList<>();
			if(tickets[i][0].equals("ICN")) {
				dfs(i, tickets, 1);
			}
			if(ans != null) {
				break;
			}
		}

		return this.ans;
	}

	public void dfs(int idx, String[][] tickets, int cnt) {
		if(ans != null) {
			return;
		}
		visited[idx] = true;
		tempList.add(tickets[idx][0]);
		if(cnt == tickets.length) {
			tempList.add(tickets[idx][1]);
			ans = new String[tickets.length];
			ans = tempList.toArray(ans);
			return;
		}
		for(int i=0; i<tickets.length; i++) {
			if(!visited[i] && tickets[i][0].equals(tickets[idx][1])) {
				dfs(i, tickets, cnt+1);
			}
		}
		tempList.remove(tempList.size()-1);
		visited[idx] = false;
	}
}

//public String[] solution(String[][] tickets) {
//    String[] answer = new String[tickets.length];
//    
//    Arrays.sort(tickets, new Comparator<String[]>() {
//		@Override
//		public int compare(String[] o1, String[] o2) {
//			return o1[1].compareTo(o2[1]);
//		}
//    });
//    
//    HashMap<String, List<String>> map = new HashMap<>();
//    for(int i=0; i<tickets.length; i++) {
//    	List<String> list = null;
//    	if(map.get(tickets[i][0]) == null) {
//    		list = new LinkedList<>();
//    	}
//    	else {
//    		list = map.get(tickets[i][0]);
//    	}
//    	list.add(tickets[i][1]);
//    	map.put(tickets[i][0], list);
//    }
//    
//    ArrayList<String> ans = new ArrayList<>();
//    ans.add("ICN");
//    String start = "ICN";
//    String dest = "";
//    while(true) {
//    	List<String> dests = map.get(start);
//    	if(dests == null || dests.isEmpty()) {
//    		break;
//    	}
//    	dest = dests.get(0);
//    	dests.remove(0);
//    	start = dest;
//    	ans.add(dest);
//    }
//    
//    answer = ans.toArray(answer);
//    
//    return answer;
//}

//import java.util.*;
//class Solution {
//    List<String> tempList = null;
//    String[] ans = null;
//    boolean[] visited = null;
//
//    public String[] solution(String[][] tickets) { 
//        visited = new boolean[tickets.length];
//        Arrays.sort(tickets, new Comparator<String[]>() {
//    		@Override
//    		public int compare(String[] o1, String[] o2) {
//    			return o1[1].compareTo(o2[1]);
//    		}
//        });
//        
//        for(int i=0; i<tickets.length; i++) {
//        	tempList = new ArrayList<>();
//        	if(tickets[i][0].equals("ICN")) {
//        		dfs(i, tickets, 1);
//        	}
//        	if(ans != null) {
//        		break;
//        	}
//        }
//        
//        return this.ans;
//    }
//	
//	public void dfs(int idx, String[][] tickets, int cnt) {
//		if(ans != null) {
//			return;
//		}
//		visited[idx] = true;
//		tempList.add(tickets[idx][0]);
//		if(cnt == tickets.length) {
//			tempList.add(tickets[idx][1]);
//			ans = new String[tickets.length];
//			ans = tempList.toArray(ans);
//			return;
//		}
//		for(int i=0; i<tickets.length; i++) {
//			if(!visited[i] && tickets[i][0].equals(tickets[idx][1])) {
//				dfs(i, tickets, cnt+1);
//			}
//		}
//		tempList.remove(tempList.size()-1);
//		visited[idx] = false;
//	}
//}

//public String[] solution(String[][] tickets) { 
//    visited = new boolean[tickets.length];
//    Arrays.sort(tickets, new Comparator<String[]>() {
//		@Override
//		public int compare(String[] o1, String[] o2) {
//			return o1[1].compareTo(o2[1]);
//		}
//    });
//    
//    for(int i=0; i<tickets.length; i++) {
//    	if(tickets[i][0].equals("ICN")) {
//    		ArrayList<String> list = new ArrayList<>();
//    		list.add("ICN");
//    		visited[i] = true;
//    		dfs(tickets, list, tickets[i][1], 1);
//    		visited[i] = false;
//    	}
//    	if(ans != null) {
//    		break;
//    	}
//    }
//    
//    return this.ans;
//}
//
//public void dfs(String[][] tickets, List<String> list, String dest, int cnt) {
//	if(ans != null) {
//		return;
//	}
//	list.add(dest);
//	if(cnt == tickets.length) {
//		ans = new String[tickets.length];
//		ans = list.toArray(ans);
//		return;
//	}
//	for(int i=0; i<tickets.length; i++) {
//		if(!visited[i] && dest.equals(tickets[i][0])) {
//			visited[i] = true;
//			dfs(tickets, list, tickets[i][1], cnt+1);
//			visited[i] = false;
//		}
//	}
//	list.remove(list.size()-1);
//}