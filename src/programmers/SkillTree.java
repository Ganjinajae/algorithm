package programmers;

public class SkillTree {

	public static void main(String[] args) {
		SkillTree test = new SkillTree();
		
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };
		int answer = test.solution(skill, skill_trees);
		System.out.println(answer);
	}
	
	public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++) {
			if(isPossible(skill, skill_trees[i])) {
				answer++;
			}
        }
        
        return answer;
    }
	
	public boolean isPossible(String skill, String skillTree) {
		boolean possible = true;
		
		int prevIdx = skillTree.indexOf(skill.charAt(0));
		int curIdx = 0;
		for(int i=1; i<skill.length(); i++) {
			char c = skill.charAt(i);
			curIdx = skillTree.indexOf(c);
			if(
					(prevIdx>curIdx) && (curIdx != -1) // skill�� �ֱ� ������ ������ �߸��� ���
				  || (prevIdx==-1 && curIdx != -1) // �߰��� �� ���
				) 
			{
				return false;
			}
			prevIdx = curIdx;
		}
		
		return possible;
	}
}
