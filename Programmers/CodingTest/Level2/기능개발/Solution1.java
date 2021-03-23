import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int len = progresses.length;
        int index = 0;

        while (index < len) {
            for (int i = 0; i < len; i++) {
                if (progresses[i] < 100)
                    progresses[i] += speeds[i];
            }
            int cnt = 0;
            while (index < len && progresses[index] >= 100) {
                index++;
                cnt++;
            }
            if (cnt != 0)
                answer.add(cnt);
        }
        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }
}