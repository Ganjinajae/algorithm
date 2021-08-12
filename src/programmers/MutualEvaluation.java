package programmers;

/**
 * 상호평가
 * @author wldud
 *
 */
public class MutualEvaluation {

	public static void main(String[] args) {
		MutualEvaluation test = new MutualEvaluation();
		int[][] scores = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
		String answer = test.solution(scores);
		System.out.println(answer);
	}
	
	public String solution(int[][] scores) {
        String answer = "";
        
        for(int j=0; j<scores[0].length; j++) {
        	int selfScore = scores[j][j];
        	int max = 0;
        	int min = 100;
        	boolean flag = true; // true면 빼고 계산
        	int sum = 0;
        	int cnt = scores.length;
        	for(int i=0; i<scores.length; i++) {
        		if(i!=j && selfScore == scores[i][j]) {
        			flag = false;
        		}
        		max = Math.max(max, scores[i][j]);
        		min = Math.min(min, scores[i][j]);
        		sum += scores[i][j];
        	}
        	
        	if(flag && (max == selfScore || min == selfScore)) {
        		cnt--;
        		sum -= selfScore; 
        	}
        	
        	answer += getRank(sum/cnt);
        }
        
        return answer;
    }
	
	public String getRank(int score) {
		if(score>=90) {
			return "A";
		}
		else if(score>=80) {
			return "B";
		}
		else if(score>=70) {
			return "C";
		}
		else if(score>=50) {
			return "D";
		}
		else {
			return "F";
		}
	}
}
