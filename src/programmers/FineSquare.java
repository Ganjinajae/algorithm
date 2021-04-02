package programmers;

/**
 * 멀쩡한 사각형 
 * @author wldud
 *
 */
public class FineSquare {

	public static void main(String[] args) {
		FineSquare test = new FineSquare();
		int w = 8;
		int h = 12;
		long answer = test.solution(w, h);
		System.out.println(answer);
	}
	
	public long solution(int w, int h) {
        long answer = 0;
        
        for(int i=1; i<w; i++) {
        	long s = h*i/w;
        	System.out.println(s);
        	answer += s;
        }
        
        return answer*2;
    }
}
