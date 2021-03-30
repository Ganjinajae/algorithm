package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Temp2 {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		String path = br.readLine();

		int[] d = new int[length+1];
		d[0] = 1;
		
		for(int i=1; i<length; i++) {
			char p = path.charAt(i);
			if(p == '1') {
				if(i%2 == 0) {
					d[i] = d[i-2] + d[i-1]; 
				}
				else {
					d[i] = d[i-1] + 1;
				}
			}
			else {
				d[i] = d[i-2];
			}
		}
		
		System.out.println(d[length-1]);
	}
}
