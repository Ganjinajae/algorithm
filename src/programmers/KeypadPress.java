package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * 키패드 누르기
 * @author wldud
 *
 */
public class KeypadPress {
	
	public static void main(String[] args) {
		KeypadPress test = new KeypadPress();
		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand = "left";
		String answer = test.solution(numbers, hand);
		System.out.println(answer);
	}
	
	public String solution(int[] numbers, String hand) {
        String answer = "";
        
        Map<String, Position> dial = new HashMap<>();
        dial.put("1", new Position(0, 0));
        dial.put("2", new Position(0, 1));
        dial.put("3", new Position(0, 2));
        dial.put("4", new Position(1, 0));
        dial.put("5", new Position(1, 1));
        dial.put("6", new Position(1, 2));
        dial.put("7", new Position(2, 0));
        dial.put("8", new Position(2, 1));
        dial.put("9", new Position(2, 2));
        dial.put("*", new Position(3, 0));
        dial.put("0", new Position(3, 1));
        dial.put("#", new Position(3, 2));
        
        String left = "*";
        String right = "#";
        
        for(int i=0; i<numbers.length; i++) {
        	String nextNum = String.valueOf(numbers[i]);
        	Position nPos = dial.get(nextNum); 
        	Position lPos = dial.get(left);
        	Position rPos = dial.get(right);
        	
        	int lDist = dist(nPos, lPos);
        	int rDist = dist(nPos, rPos);
        	
        	if("1".equals(nextNum) 
        			|| "4".equals(nextNum) 
        			|| "7".equals(nextNum)
        			|| "*".equals(nextNum)
        		) {
        		left = nextNum;
        		answer += "L";
        	}
        	else if("3".equals(nextNum) 
        			|| "6".equals(nextNum) 
        			|| "9".equals(nextNum)
        			|| "#".equals(nextNum)
        			) {
        		right = nextNum;
        		answer += "R";
        	}
        	else {
        		if(rDist > lDist) {
        			left = nextNum;
            		answer += "L";
        		}
        		else if(lDist > rDist) {
        			right = nextNum;
            		answer += "R";
        		}
        		else {
        			if(hand.equals("left")) {
        				left = nextNum;
        				answer += "L";
        			}
        			else {
            			right = nextNum;
            			answer += "R";
            		}
        		}
        	}
        }
        
        return answer;
    }
	
	public static int dist(Position p1, Position p2) {
		return (Math.abs(p1.getR()-p2.getR()) + Math.abs(p1.getC()-p2.getC()));
	}
}

class Position {
	int r;
	int c;
	Position(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
	int getR() {
		return this.r;
	}
	int getC() {
		return this.c;
	}
}