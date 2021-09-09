package programmers;

import java.util.Arrays;

/**
 * 직업군 추천하기
 * @author wldud
 *
 */
public class JobRecommend {

	public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";

        int max = -1;
        for(String s : table) {
        	String[] arr = s.split(" ");
        	String job = arr[0];
        	int sum = 0;
        	for(int i=0; i<languages.length; i++) {
        		int idx = Arrays.asList(arr).indexOf(languages[i]);
        		if(idx > -1) {
        			sum += (6-idx)*preference[i];
        		}
        	}
        	if(sum > max) {
        		max = sum;
        		answer = job;
        	}
        	else if(sum == max) {
        		if(answer.compareTo(job) < 0) continue;
        		answer = job;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
	
		JobRecommend test = new JobRecommend();
		String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
		String[] languages = {"JAVA", "JAVASCRIPT"};
		int[] preference = {7, 5};
		String answer = test.solution(table, languages, preference);
		System.out.println(answer);
		
		System.out.println("SI".compareTo("CONTENTS"));
	}
}
