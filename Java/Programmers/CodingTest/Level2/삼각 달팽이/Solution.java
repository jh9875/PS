import java.util.ArrayList;
import java.util.List;

class Solution {
	static int[] dirY = { 1, 0, -1 };
	static int[] dirX = { 0, 1, -1 };

	public int[] solution(int n) {
		if (n == 1) {
			int[] ret = { 1 };
			return ret;
		}
		List<Integer> answer = new ArrayList<>();
		int[][] triangle = fillingNumbers(n);

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (triangle[y][x] != 0)
					answer.add(triangle[y][x]);
				else
					break;
			}
		}

		return answer.stream().mapToInt(i -> i.intValue()).toArray();
	}

	public int[][] fillingNumbers(int n) {
		int[][] triangle = new int[n][n];
		int index = 1, dir = 0;
		int y = 0, x = 0;

		while (triangle[y][x] == 0) {
			triangle[y][x] = index++;

			int nextY = y + dirY[dir];
			int nextX = x + dirX[dir];
			if (!inRange(nextY, nextX, n) || (inRange(nextY, nextX, n) && triangle[nextY][nextX] != 0)) {
				dir = (dir + 1) % 3;
				nextY = y + dirY[dir];
				nextX = x + dirX[dir];
			}
			y = nextY;
			x = nextX;
		}

		return triangle;
	}

	public boolean inRange(int y, int x, int n) {
		if (y < 0 || y >= n || x < 0 || x >= n)
			return false;
		return true;
	}
}