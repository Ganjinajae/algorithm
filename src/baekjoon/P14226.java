package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 이모티콘
 * @author wldud
 *
 */
public class P14226 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int S = Integer.parseInt(br.readLine());
		
		Queue<Screen> q = new LinkedList<>();
		q.add(new Screen(0, 1));
		int answer = 0;
		boolean exitFlag = false;
		while(!q.isEmpty()) {
			int n = q.size();
			while(n-- > 0) {
				Screen s = q.poll();
				if(s.getNum() == S) {
					exitFlag = true;
					break;
				}
				q.add(new Screen(s.getNum(), s.getNum()));
				if(s.getClipboard() != 0) {
					q.add(new Screen(s.getNum(), s.getNum()+s.getClipboard()));
				}
				if(s.getNum() > 0) {
					q.add(new Screen(s.getClipboard(), s.getNum()-1));
				}
			}
			if(exitFlag) break;
			answer++;
		}
		
		System.out.println(answer);
	}
}

class Screen {
	int clipboard;
	int num = 1;
	
	Screen(int clipboard, int num) {
		this.clipboard = clipboard;
		this.num = num;
	}
	
	public int getClipboard() {
		return clipboard;
	}
	public void setClipboard(int clipboard) {
		this.clipboard = clipboard;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
