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
	
	static boolean[][] visited = new boolean[1001][1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int S = Integer.parseInt(br.readLine());
		
		Queue<Screen> q = new LinkedList<>();
		q.add(new Screen(0, 1, 0));
		visited[0][1] = true;
		while(!q.isEmpty()) {
			
			Screen s = q.poll();
			if(s.getNum() == S) {
				System.out.println(s.getSecond());
				break;
			}
			
			q.add(new Screen(s.getNum(), s.getNum(), s.getSecond()+1));
			if(s.getClipboard() != 0 && s.getNum()+s.clipboard <= S && !visited[s.getClipboard()][s.getNum()+s.clipboard]) {
				q.add(new Screen(s.getClipboard(), s.getNum()+s.clipboard, s.getSecond()+1));
				visited[s.getClipboard()][s.getNum()+s.clipboard] = true;
			}
			if(s.getNum()-1 >=0 && !visited[s.getClipboard()][s.getNum()-1]) {
				q.add(new Screen(s.getClipboard(), s.getNum()-1, s.getSecond()+1));
				visited[s.getClipboard()][s.getNum()-1] = true;
			}
		}
	}
}

class Screen {
	int clipboard;
	int num;
	int second;
	
	Screen(int clipboard, int num, int second) {
		this.clipboard = clipboard;
		this.num = num;
		this.second = second;
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
	public int getSecond() {
		return this.second;
	}
	public void setSecond(int second) {
		this.num = second;
	}
}
