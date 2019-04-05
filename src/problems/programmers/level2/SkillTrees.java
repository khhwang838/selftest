/**
 * Created on Mar 23, 2019 by Keichee
 */
package problems.programmers.level2;

public class SkillTrees {
	// "CBD"
	// [BACDE, CBADF, AECB, BDA]
	// answer : 2
	public static void main(String[] args) {
		String skill = "CBD";	// [^CBD]
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		String replaced = skill_trees[3].replaceAll("[^" + skill + "]", "");
//		System.out.println(replaced);
		// BCD -1
		// CBD 0
		// CB 0
		// BD 1
		// CD -1
		System.out.println(skill.indexOf("BCD"));
		if(skill.contains("선택시")) {
			// do something..
		}
//		System.out.println(solution(skill, skill_trees));
	}
	public static int solution(String skill, String[] skill_trees) {
		String[] skills = skill.split("");
		int answer = 0;
		for (String skill_tree : skill_trees) {
			boolean isValid = true;
			int prevSkillIdx = skill_tree.indexOf(skills[0]);
			for (int idx = 1; idx < skills.length; idx++) {
				int curSkillIdx = skill_tree.indexOf(skills[idx]);

				if (prevSkillIdx == -1 && curSkillIdx == -1) {}
				else if (prevSkillIdx > curSkillIdx && curSkillIdx == -1){}
				else if (prevSkillIdx > -1 && curSkillIdx > -1 && prevSkillIdx < curSkillIdx ){}
				else {
					isValid = false;
					break; // 스킬트리에 맞지 않음
				}
					
//				if((prevSkillIdx > curSkillIdx)
//					|| (prevSkillIdx == -1 && curSkillIdx > -1)
//					|| ()) {
//					isValid = false;
//					break; // 스킬트리에 맞지 않음
//				}
				prevSkillIdx = curSkillIdx;
			}
			if(isValid) {
				answer++;
			}
		}
		return answer;
	}
}
