package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ¿ÀÇÂÃ¤ÆÃ¹æ
 * @author wldud
 *
 */
public class OpenChattingRoom {
	
	Map<String, String> user = new HashMap<>();
	List<String> orderList = new ArrayList<>();

	public static void main(String[] args) {
		OpenChattingRoom test = new OpenChattingRoom();
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] answer = test.solution(record);
		
		System.out.println(Arrays.toString(answer));
	}
	
	public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        
        for(int i=0; i<record.length; i++) {
        	process(record[i]);
        }
        
        for(int i=0; i<orderList.size(); i++) {
        	String command = orderList.get(i);
        	int idx = command.indexOf("´Ô");
        	String order = user.get(command.substring(0, idx)) + command.substring(idx);
        	answer.add(order);
        }
        
        String[] ans = new String[answer.size()];
        ans = answer.toArray(ans);
        
        return ans;
    }
	
	public void process(String command) {
    	String[] temp = command.split(" ");
    	if(temp[0].equals("Enter")) {
    		user.put(temp[1], temp[2]);
    		orderList.add(temp[1] + "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
    	}
    	else if(temp[0].equals("Leave")){
    		orderList.add(temp[1] + "´ÔÀÌ ³ª°¬½À´Ï´Ù.");
    	}
    	else {
    		user.put(temp[1], temp[2]);
    	}
	}
}
