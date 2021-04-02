import java.util.LinkedList;
import java.util.Queue;

class Solution {
	class Pos {
		int y, x;
		int cnt;

		Pos(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}

	static int[] dirY = { 1, 0, -1, 0 };
	static int[] dirX = { 0, 1, 0, -1 };

	public int solution(int[][] maps) {
		return bfs(maps);
	}

	public int bfs(int[][] maps) {
		Queue<Pos> queue = new LinkedList<>();
		int rows = maps.length;
		int cols = maps[0].length;
		boolean[][] visited = new boolean[rows][cols];

		queue.add(new Pos(0, 0, 1));
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			int y = queue.peek().y;
			int x = queue.peek().x;
			int cnt = queue.poll().cnt;

			if (y == rows - 1 && x == cols - 1)
				return cnt;

			for (int d = 0; d < 4; d++) {
				int nextY = y + dirY[d];
				int nextX = x + dirX[d];

				if (!canMove(nextY, nextX, maps, visited))
					continue;

				queue.add(new Pos(nextY, nextX, cnt + 1));
				visited[nextY][nextX] = true;
			}
		}

		return -1;
	}

	public boolean canMove(int y, int x, int[][] maps, boolean[][] visited) {
		if (inRange(y, x, maps) && maps[y][x] == 1 && !visited[y][x])
			return true;
		return false;
	}

	public boolean inRange(int y, int x, int[][] maps) {
		if (y < 0 || y >= maps.length || x < 0 || x >= maps[0].length)
			return false;
		return true;
	}
}