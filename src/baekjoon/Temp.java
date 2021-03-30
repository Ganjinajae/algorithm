package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ø¨Ω¿¿Â
 * @author wldud
 *
 */
public class Temp {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int people = Integer.parseInt(input);
		String fromTime = "00:00";
		String toTime = "23:59"; 
		for(int i=0; i<people; i++) {
			String time = br.readLine();
			String[] times = time.split(" ~ ");
			if(fromTime.compareTo(times[0]) < 0) {
				fromTime = times[0];
			}
			if(toTime.compareTo(times[1]) > 0) {
				toTime = times[1];
			}
			if((times[1].compareTo(fromTime) < 0) || (times[0].compareTo(toTime) > 0)) {
				System.out.println(-1);
				return ;
			}
		}
		
		System.out.println(fromTime +" ~ "+ toTime);
	}
}

