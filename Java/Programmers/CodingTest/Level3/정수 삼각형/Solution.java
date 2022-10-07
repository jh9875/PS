import java.util.Arrays;

class Solution {
	int[][] cache;

	public int solution(int[][] triangle) {
		initCache(triangle);
		return search(0, 0, triangle);
	}

	public void initCache(int[][] triangle) {
		int len = triangle.length;
		cache = new int[len][len];
		for (int i = 0; i < len; i++)
			Arrays.fill(cache[i], -1);
	}

	public int search(int y, int x, int[][] triangle) {
		if (y == triangle.length)
			return 0;
		if (cache[y][x] != -1)
			return cache[y][x];

		return cache[y][x] = triangle[y][x] + Math.max(search(y + 1, x, triangle), search(y + 1, x + 1, triangle));
	}
}