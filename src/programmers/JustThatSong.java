package programmers;

/**
 * ¹æ±Ý ±× °î
 * @author wldud
 *
 */
public class JustThatSong {

	public static void main(String[] args) {

		JustThatSong test = new JustThatSong();
		String m = "ABC";
		String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		String answer = test.solution(m, musicinfos);
		System.out.println(answer);
	}

	public String solution(String m, String[] musicinfos) {
		String answer = "(None)";
		int max = 0;
		
		m = changeMelody(m);
		for(int i=0; i<musicinfos.length; i++) {
			String[] info = musicinfos[i].split(",");
			String start = info[0];
			String end = info[1];
			String title = info[2];
			String code = changeMelody(info[3]);

			String[] starts = start.split(":");
			String[] ends = end.split(":");
			int sHour = Integer.parseInt(starts[0]);
			int eHour = Integer.parseInt(ends[0]);
			int sMinute = Integer.parseInt(starts[1]);
			int eMinute = Integer.parseInt(ends[1]);
			int minute = (eHour-sHour)*60 + eMinute-sMinute; 

			int share = minute/code.length();
			int rem = minute%code.length();
			String realPlay = "";
			for(int j=0; j<share; j++) {
				realPlay += code;
			}
			realPlay += code.substring(0, rem);

			if(realPlay.contains(m)) {
				if(realPlay.length() > max) {
					max = realPlay.length();
					answer = title;
				}
			}
		}
		return answer;
	}
	
	public String changeMelody(String melody) {
		melody = melody.replaceAll("C#", "c");
		melody = melody.replaceAll("D#", "d");
		melody = melody.replaceAll("F#", "f");
		melody = melody.replaceAll("G#", "g");
		melody = melody.replaceAll("A#", "a");
		
		return melody;
	}
}