스킬트리
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/49993

<br>

### 풀이

여러 가지 방법으로 해결할 수 있지만 Queue로 해결해봤다.

선행스킬 순서들을 Queue에 차례대로 넣어서 스킬트리의 순서가 올바른지 확인하는 방식으로 진행했다.

~~~java
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
~~~

현재 배워야하는 스킬이 스킬트리와 같다면 queue를 poll하여 다음 배워야하는 선행 스킬을 확인하고, <br>
만약 다르다면 선행 스킬 순서가 틀리지 않았는지 확인해본다.

<br>