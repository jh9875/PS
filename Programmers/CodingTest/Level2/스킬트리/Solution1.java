class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int treeLen = skill_trees.length;
        char[] skillArr = skill.toCharArray();

        for (int i = 0; i < treeLen; i++) {
            if (isOk(skillArr, skill_trees[i]))
                answer++;

        }
        return answer;
    }

    public boolean isOk(char[] skillArr, String someSkill) {
        int skillLen = skillArr.length;
        int somSkillLen = someSkill.length();
        int index = 0;

        for (int i = 0; i < somSkillLen; i++) {
            if (someSkill.charAt(i) == skillArr[index]) {
                index++;
            } else {
                for (int next = index + 1; next < skillLen; next++) {
                    if (someSkill.charAt(i) == skillArr[next])
                        return false;
                }
            }

            if (index == skillLen)
                return true;
        }

        return true;
    }
}