package programmers;

/**
 * ¶¥µû¸Ô±â
 * @author wldud
 *
 */
public class Hopscotch {

	public static void main(String[] args) {
		Hopscotch test = new Hopscotch();
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		int answer = test.solution(land);
		System.out.println(answer);
	}
	
	int solution(int[][] land) {
        int answer = 0;
        for(int i=1; i<land.length; i++) {
        	for(int j=0; j<land[0].length; j++) {
        		int max = 0;
        		for(int k=0; k<4; k++) {
        			if(j != k) {
        				max = Math.max(max, land[i-1][k]);
        			}
        		}
        		land[i][j] = land[i][j] + max;
        	}
        	
        }
        
        for(int i=0; i<4; i++) {
        	answer = Math.max(answer, land[land.length-1][i]);
        }

        return answer;
    }
}
