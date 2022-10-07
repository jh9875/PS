class Solution {
	static final int MOD = 1234567;

	public int solution(int n) {
		int[] fibonacci = new int[3];
		fibonacci[0] = 0;
		fibonacci[1] = 1;

		for (int i = 2; i <= n; i++)
			fibonacci[i % 3] = fibonacci[(i - 1) % 3] % MOD + fibonacci[(i - 2) % 3] % MOD;

		return fibonacci[n % 3] % MOD;
	}

}