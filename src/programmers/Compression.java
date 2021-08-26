package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * æ–√‡
 * @author wldud
 *
 */
public class Compression {

	public int[] solution(String msg) {
        int[] answer = {};

        Map<String, Integer> map = new HashMap<>();
        String[] msgs = msg.split("");
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'A');
            map.put(String.valueOf(c), i + 1);
        }

        String s = "";
        int cnt = 27;
        int index = -1;
        int j=0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < msgs.length; i++) {
            s += msgs[i];
            for (j = i + 1; j < msgs.length; j++) {
                index = map.get(s);
                s += msgs[j];
                if (!map.containsKey(s)) {
                    map.put(s, cnt++);
                    list.add(index);
                    s = "";
                    break;
                }
            }
            i = j-1;
        }
        if(!s.equals("")) {
            list.add(map.get(s));
        }

        answer = list.stream().mapToInt(i -> i).toArray();

        return answer;
    }
	
	public static void main(String[] args) {
		Compression test= new Compression();
		String msg = "KAKAO";
		int[] answer = test.solution(msg);
		System.out.println(Arrays.toString(answer));
	}
}
