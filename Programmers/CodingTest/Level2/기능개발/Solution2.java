import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> answer = new ArrayList<>();
		int[] takeDays = getTakeDays(progresses, speeds);
		int progressesLen = progresses.length;
		int index = 0;

		while (index < progressesLen) {
			int nextProgressIndex = index;
			int count = 0;

			while (nextProgressIndex < progressesLen && takeDays[index] >= takeDays[nextProgressIndex]) {
				nextProgressIndex++;
				count++;
			}
			answer.add(count);
			index = nextProgressIndex;
		}

		return answer.stream().mapToInt(i -> i.intValue()).toArray();
	}

	public int[] getTakeDays(int[] progresses, int[] speeds) {
		int progressesLen = progresses.length;
		int[] takeDays = new int[progressesLen];

		for (int i = 0; i < progressesLen; i++) {
			int quotient = (100 - progresses[i]) / speeds[i];
			int remainder = (100 - progresses[i]) % speeds[i];
			takeDays[i] = remainder == 0 ? quotient : quotient + 1;
		}

		return takeDays;
	}
}