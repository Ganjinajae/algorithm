package baekjoon;

public class Temp6 {

	public static void main(String[] args) {
		Temp6 test = new Temp6();
		int n = 5;
		int[] money = {1, 2, 5};
		int answer = test.solution(n, money);

		System.out.println(answer);
	}
	
	public static final int MOD = 1000000007;

	public int solution(int n, int[] money) {
		int[] d = new int[n+1];
		d[0] = 1;
		for(int i=0; i<money.length; i++) {
			for(int j=money[i]; j<=n; j++) {
				d[j] = (d[j] + d[j-money[i]])%MOD;
			}
		}
		
		return d[n];
	}

}

