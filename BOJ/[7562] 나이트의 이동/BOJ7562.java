import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Pos {
		int y, x, count;

		Pos(int y, int x, int count) {
			this.y = y;
			this.x = x;
			this.count = count;
		}
	}

	static int[] dirY = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dirX = { -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			int length = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Pos startPos = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			st = new StringTokenizer(br.readLine());
			Pos targetPos = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			bw.write(moveKnight(startPos, targetPos, length) + "\n");
		}
		bw.flush();
	}

	static int moveKnight(Pos startPos, Pos targetPos, int length) {
		Queue<Pos> queue = new LinkedList<>();
		boolean[][] visited = new boolean[length][length];
		visited[startPos.y][startPos.x] = true;
		queue.add(startPos);

		while (!queue.isEmpty()) {
			int nowY = queue.peek().y;
			int nowX = queue.peek().x;
			int count = queue.peek().count;
			queue.poll();

			if (nowY == targetPos.y && nowX == targetPos.x)
				return count;

			for (int d = 0; d < 8; d++) {
				int nextY = nowY + dirY[d];
				int nextX = nowX + dirX[d];
				if (!inRange(nextY, nextX, length) || visited[nextY][nextX])
					continue;
				visited[nextY][nextX] = true;
				queue.add(new Pos(nextY, nextX, count + 1));
			}
		}

		return 0;
	}

	static boolean inRange(int y, int x, int length) {
		if (y < 0 || y >= length || x < 0 || x >= length)
			return false;
		return true;
	}
}
