import java.util.Arrays;

class Solution {
	public int solution(int[] people, int limit) {
		int answer = 0;
		int left = 0, right = people.length - 1;
		Arrays.sort(people);

		while (left <= right) {
			int sum = people[left] + people[right];
			if (sum <= limit) { // 두명 타는 경우
				left++;
				right--;
			} else { // 한명만 타는 경우
				right--;
			}
			answer++;
		}

		return answer;
	}
}