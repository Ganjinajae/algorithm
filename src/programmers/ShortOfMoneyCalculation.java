package programmers;

/**
 * 부족한 금액 계산하기
 * @author wldud
 *
 */
public class ShortOfMoneyCalculation {

	public static void main(String[] args) {
		ShortOfMoneyCalculation test = new ShortOfMoneyCalculation();
		int price = 3;
		int money = 20;
		int count = 4;
		
		long answer = test.solution(price, money, count);
		System.out.println(answer);
	}
	
	public long solution(int price, int money, int count) {
        long answer = 0;
        
        long lastPrice = price + (count-1)*price;
        long sum = count*(price+lastPrice)/2;
        if(sum > money) {
        	answer = sum-money;
        }
        
        return answer;
    }
}
