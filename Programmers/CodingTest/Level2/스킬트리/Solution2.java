import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		int skillTreesLen = skill_trees.length;

		for (int i = 0; i < skillTreesLen; i++) {
			if (isPossibleSkillTree(skill, skill_trees[i]))
				answer++;
		}

		return answer;
	}

	public boolean isPossibleSkillTree(String skill, String skillTree) {
		Queue<Character> skillQueue = stringToCharQueue(skill);
		int skillTreeIndex = 0;
		int skillTreeLen = skillTree.length();

		while (skillTreeIndex < skillTreeLen) {
			if (skillQueue.isEmpty())
				break;

			char haveToLearnSkill = skillQueue.peek();
			char nowSkill = skillTree.charAt(skillTreeIndex++);

			if (haveToLearnSkill == nowSkill) {
				skillQueue.poll();
			} else {
				if (skillQueue.contains(nowSkill))
					return false;
			}
		}
		return true;
	}

	public Queue<Character> stringToCharQueue(String skill) {
		Queue<Character> queue = new LinkedList<>();
		int len = skill.length();

		for (int i = 0; i < len; i++) {
			queue.add(skill.charAt(i));
		}

		return queue;
	}
}