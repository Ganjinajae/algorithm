package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 파일명 정렬
 * @author wldud
 *
 */
public class FileNameSorting {

	public int convertNum(String s, String head) {
		s = s.substring(head.length());
		String res = "";
		for(char c : s.toCharArray()) {
			if(Character.isDigit(c) && res.length() < 5) {
				res += c; 
			}
			else {
				break;
			}
		}
		return Integer.valueOf(res);
	}

	public String[] solution(String[] files) {
		Arrays.sort(files, (s1, s2) -> {
			String head1 = s1.split("[0-9]")[0];
			String head2 = s2.split("[0-9]")[0];

			int result = head1.toLowerCase().compareTo(head2.toLowerCase());

			if(result == 0) {
				result = convertNum(s1, head1) - convertNum(s2, head2);
			}

			return result;
		});

		return files;
	}

	public static void main(String[] args) {
		FileNameSorting test = new FileNameSorting();
		//		String[] files = {"img1.png", "IMG01.GIF"};
		//		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		String[] answer = test.solution(files);
		System.out.println(Arrays.toString(answer));
	}
}
