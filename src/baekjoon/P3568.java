package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * iSharp
 * @author wldud
 *
 */
public class P3568 {

	public static void main(String[] args) throws IOException {
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		String[] arr = s.split(" ");
		
		String defaultVar = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			String temp = arr[i];
			temp = temp.replaceAll(",|;", "");
			String ex = temp.replaceAll("[a-z]|[A-Z]", "");
			String alpha = temp.substring(0, temp.length()-ex.length());
			String[] test = ex.split("");
			String newEx = "";
			for(int j=test.length-1; j>=0; j--) {
				if(test[j].equals("]")) {
					newEx += test[j-1] + test[j];
					j--;
				}
				else {
					newEx += test[j];
				}
			}
			
			System.out.println(defaultVar + newEx + " " + alpha + ";"); 
		}
	}
}
