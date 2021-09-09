package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 직업군 추천하기
 * @author wldud
 *
 */
public class JobRecommend {

	public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        
        List<Map<String, Integer>> jobDesc = new ArrayList<>();
        Map<Integer, String> jobs = new HashMap<>();
        
        for(int i=0; i<table.length; i++) {
        	String s = table[i];
        	String[] datas = s.split(" ");
        	String job = datas[0];
        	jobs.put(i, job);
        	int point = 5;
        	Map<String, Integer> map = new HashMap<>();
        	for(int j=1; j<datas.length; j++) {
        		String lang = datas[j];
        		map.put(lang, point--);
        	}
        	jobDesc.add(map);
        }
        
        int max = -1;
        for(int i=0; i<jobs.size(); i++) {
        	String job = jobs.get(i);
        	Map<String, Integer> desc = jobDesc.get(i);
        	int sum = 0;
        	for(int j=0; j<languages.length; j++) {
        		sum += desc.getOrDefault(languages[j], 0)*preference[j];
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
