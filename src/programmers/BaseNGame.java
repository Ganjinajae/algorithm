package programmers;

/**
 * n진수 게임
 * @author wldud
 *
 */
class BaseNGame {
	
	// n진법으로 구한다. => 10만개까지 => 그리고 구한다.
	public String baseN(int n, int t, int m, int p) {
		StringBuilder b = new StringBuilder();
		b.append(0);
		int num = 1;
		while(b.length() < (t*m+p)) {
			StringBuilder tb = new StringBuilder();
			int temp = num;
			while(true) {
				if(temp == 0) break;
				int r = temp%n;
				if(r < 10) {
					tb.append(r);
				}
				else {
					tb.append((char)(r-10+'A'));
				}
				temp = temp/n;
			}
			num++;
			b.append(tb.reverse().toString());
		}
		
		return b.toString();
	}

	public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        
        String w = baseN(n, t, m, p);
        while(t-->0) {
        	answer.append(w.charAt(p-1));
        	p += m;
        }
        
        return answer.toString();
    }
	
	public static void main(String[] args) {
		BaseNGame test = new BaseNGame();
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 2;
		String answer = test.solution(n, t, m, p);
		System.out.println(answer);
	}
}
