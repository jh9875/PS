class Solution {
	public int solution(int[] numbers, int target) {
		return searchTargetNumber(0, 0, target, numbers);
	}

	public int searchTargetNumber(int index, int sum, int target, int[] numbers) {
		if (index == numbers.length) {
			if (sum == target)
				return 1;
			return 0;
		}
		return searchTargetNumber(index + 1, sum + numbers[index], target, numbers)
				+ searchTargetNumber(index + 1, sum - numbers[index], target, numbers);
	}
}