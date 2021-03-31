package programmers;

public class CountryNumber124 {

	public static void main(String[] args) {
		CountryNumber124 test = new CountryNumber124();
		String answer = test.solution(4);
		System.out.println(answer);
	}
	
	public String solution(int n) {
		String[] numbers = { "4", "1", "2" };
		String answer = "";
		
		int num = n;
		while(true) {
			if(num == 0) {
				break;
			}
			int remain = num%3;
			num /= 3;
			
			answer = numbers[remain] + answer;
		}
		
		return answer;
    }
}
