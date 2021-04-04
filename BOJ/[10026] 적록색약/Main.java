import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static class Pos {
		int y, x;

		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int[] dirY = { 1, 0, -1, 0 };
	static int[] dirX = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[][] normalDrawing;
		char[][] redGreenMedicineDrawing;
		int N;

		N = Integer.parseInt(br.readLine());
		normalDrawing = new char[N][N];
		redGreenMedicineDrawing = new char[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				char color = line.charAt(j);
				normalDrawing[i][j] = color;
				if (color == 'R' || color == 'G')
					redGreenMedicineDrawing[i][j] = 'R';
			}
		}
		int[] result = scanDrawing(N, normalDrawing, redGreenMedicineDrawing);
		bw.write(result[0] + " " + result[1] + "\n");
		bw.flush();
	}

	public static int[] scanDrawing(int N, char[][] normalDrawing, char[][] redGreenMedicineDrawing) {
		int[] result = new int[2];
		boolean[][] redGreenMedicineChecked = new boolean[N][N];
		boolean[][] normalChecked = new boolean[N][N];

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (!normalChecked[y][x]) {
					bfs(y, x, N, normalDrawing, normalChecked);
					result[0]++;
				}
				if (!redGreenMedicineChecked[y][x]) {
					bfs(y, x, N, redGreenMedicineDrawing, redGreenMedicineChecked);
					result[1]++;
				}
			}
		}

		return result;
	}

	public static void bfs(int startY, int startX, int N, char[][] drawing, boolean[][] checked) {
		Queue<Pos> queue = new LinkedList<>();
		char color = drawing[startY][startX];

		queue.add(new Pos(startY, startX));
		checked[startY][startX] = true;

		while (!queue.isEmpty()) {
			int nowY = queue.peek().y;
			int nowX = queue.peek().x;
			queue.poll();

			for (int d = 0; d < 4; d++) {
				int nextY = nowY + dirY[d];
				int nextX = nowX + dirX[d];

				if (!inRange(nextY, nextX, N) || checked[nextY][nextX] || drawing[nextY][nextX] != color)
					continue;

				queue.add(new Pos(nextY, nextX));
				checked[nextY][nextX] = true;
			}
		}
	}

	public static boolean inRange(int y, int x, int N) {
		if (y < 0 || y >= N || x < 0 || x >= N)
			return false;
		return true;
	}
}
