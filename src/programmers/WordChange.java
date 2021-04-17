package programmers;

/**
 * 단어 변환
 * @author wldud
 *
 */
public class WordChange {

	boolean[] visited = null;
    int answer = 987654321;

	public static void main(String[] args) {
		WordChange test = new WordChange();
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		int answer = test.solution(begin, target, words);
		System.out.println(answer);
	}
	
	public int solution(String begin, String target, String[] words) {
        
        if(!isPossible(target, words)) {
        	return 0;
        }
        // words를 돌면서 바꿔보기
    	visited = new boolean[words.length];
    	dfs(0, words, begin, target, 0);
        
        return answer;
    }
	
	public void dfs(int idx, String[] words, String begin, String target, int cnt) {
		if(begin.equals(target)) {
			if(cnt < answer) {
				answer = cnt;
			}
			return;
		}
		for(int i=0; i<words.length; i++) {
			if(!visited[i] && isPossibleChange(words[i], begin)) {
				visited[i] = true;
				dfs(i, words, words[i], target, cnt+1);
				visited[i] = false;
			}
		}
	}
	
	public boolean isPossibleChange(String word, String target) {
		int cnt = 0;
		for(int i=0; i<word.length(); i++) {
			if(word.charAt(i) != target.charAt(i)) {
				cnt++;
			}
		}
		if(cnt > 1) {
			return false;
		}
		return true;
	}
	
	public boolean isPossible(String target, String[] words) {
		// target이 words안에 있는지 검사
        boolean possible = false;
        for(int i=0; i<words.length; i++) {
        	if(words[i].equals(target)) {
        		possible = true;
        	}
        }
        
        return possible;
	}
}
