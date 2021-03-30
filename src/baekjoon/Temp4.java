package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Temp4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] priorities = br.readLine().split(" ");
		String[] rc = br.readLine().split(" ");
		int r = Integer.parseInt(rc[0]);
		int c = Integer.parseInt(rc[1]);
		
		char[][] openInfoArr = new char[r][c];
		
		ArrayList<Content> arr = new ArrayList<>();
		
		for(int i=0; i<r; i++) {
			String openInfo = br.readLine();
			for(int j=0; j<c; j++) {
				char temp = openInfo.charAt(j);
				if(temp == 'Y') {
					temp = '0';
				}
				else if(temp == 'O') {
					temp = '1';
				}
				else {
					temp = '2';
				}
				openInfoArr[i][j] = temp;
			}
		}
		for(int i=0; i<r; i++) {
			String genre = br.readLine();
			for(int j=0; j<c; j++) {
				char g = genre.charAt(j);
				if(openInfoArr[i][j] == '2') {
					continue;
				}
				Content content = new Content(i, j, openInfoArr[i][j], Double.parseDouble(priorities[g-'A']), g);
				arr.add(content);
			}
		}
		
		arr.sort(new Comparator<Content>() {
			@Override
			public int compare(Content o1, Content o2) {
				if(o1.getOpenInfo() == o2.getOpenInfo()) {
					if(o1.getPriority() == o2.getPriority()) {
						if(o1.getR() == o2.getR()) {
							return o1.getC()-o2.getC();
						}
						return o1.getR()-o2.getR();
					}
					return (int) (o2.getPriority() - o1.getPriority());
				}
				else if(o1.getOpenInfo() > o2.getOpenInfo()) {
					return 1;
				}
				else {
					return -1;
				}
			}
		});
		
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i).getGenre() + " "
							+ arr.get(i).getPriority() + " "
							+ arr.get(i).getR() + " "
							+ arr.get(i).getC()
							);
		}
	}
	
}
class Content {
	int r;
	int c;
	char openInfo;
	double priority;
	char genre;
	
	Content(int r, int c, char openInfo, double priority, char genre) {
		this.r = r;
		this.c = c;
		this.openInfo = openInfo;
		this.priority = priority;
		this.genre = genre;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public char getOpenInfo() {
		return openInfo;
	}

	public void setOpenInfo(char openInfo) {
		this.openInfo = openInfo;
	}

	public double getPriority() {
		return priority;
	}

	public void setPriority(double priority) {
		this.priority = priority;
	}

	public char getGenre() {
		return genre;
	}

	public void setGenre(char genre) {
		this.genre = genre;
	}
	
}