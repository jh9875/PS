import java.util.Arrays;

class Solution {
	final int MOD = 1000000007;
	int N, M;
	int[][] cache;
	boolean[][] cantMove;

	public int solution(int m, int n, int[][] puddles) {
		N = n;
		M = m;
		cantMove = new boolean[N][M];
		for (int[] pos : puddles)
			cantMove[pos[1] - 1][pos[0] - 1] = true;
		cache = new int[N][M];
		for (int i = 0; i < N; i++)
			Arrays.fill(cache[i], -1);

		return goToSchool(0, 0) % MOD;
	}

	int goToSchool(int y, int x) {
		if ((y == N || x == M) || cantMove[y][x])
			return 0;
		if (y == N - 1 && x == M - 1)
			return 1;
		if (cache[y][x] != -1)
			return cache[y][x];

		return cache[y][x] = goToSchool(y + 1, x) % MOD + goToSchool(y, x + 1) % MOD;
	}
}