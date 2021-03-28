class Solution {
	public String solution(int n) {
		StringBuilder sb = new StringBuilder();
		String[] num = { "4", "1", "2" };

		while (n > 0) {
			sb.append(num[n % 3]);
			n = (n - 1) / 3;
		}

		return sb.toString();
	}
}