package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 암호 만들기
 * @author wldud
 *
 */
public class P1759 {
	
	static int L;
	static int C;
	static String[] alphaArr;
	static List<String> arr = new ArrayList<>();
	
	public static boolean isCipher(String s) {
		int cnt = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == 'a'
			|| s.charAt(i) == 'e'
			|| s.charAt(i) == 'i'
			|| s.charAt(i) == 'o'
			|| s.charAt(i) == 'u') 
			{
				cnt++;
			}
		}
		int strLen = s.length();
		if(cnt>=1 && (strLen-cnt)>=2) {
			return true;
		}
		return false;
	}
	
	public static void dfs(int idx, int cnt, String result) {
		if(cnt == L) {
			if(isCipher(result)) {
				arr.add(result);
			}
			return;
		}
		
		for(int i=idx; i<alphaArr.length; i++) {
			dfs(i+1, cnt+1, result+alphaArr[i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alphaArr = new String[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			alphaArr[i] = st.nextToken(); 
		}
		
		Arrays.sort(alphaArr);
		
		dfs(0, 0, "");
		
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
}
