import java.util.Arrays;

class Solution {
	public int solution(int[] people, int limit) {
		int answer = 0;
		int left = 0, right = people.length - 1;
		Arrays.sort(people);

		while (left <= right) {
			int sum = people[left] + people[right];
			if (sum <= limit) { // �θ� Ÿ�� ���
				left++;
				right--;
			} else { // �Ѹ� Ÿ�� ���
				right--;
			}
			answer++;
		}

		return answer;
	}
}