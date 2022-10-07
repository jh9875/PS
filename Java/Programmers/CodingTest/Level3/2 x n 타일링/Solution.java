import java.util.Arrays;

class Solution {
	static final int MOD = 1000000007;
	int[] cache;

	public int solution(int n) {
		cache = new int[n + 1];
		Arrays.fill(cache, -1);

		return tiling2(n);
	}

	public int tiling2(int restWidth) {
		if (restWidth == 0)
			return 1;
		if (cache[restWidth] != -1)
			return cache[restWidth];
		int ret = 0;

		ret += tiling2(restWidth - 1) % MOD;
		if (restWidth - 2 >= 0)
			ret += tiling2(restWidth - 2) % MOD;

		return cache[restWidth] = ret % MOD;
	}
}