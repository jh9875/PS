import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Bead {
		int redY, redX;
		int blueY, blueX;
		int cnt;

		Bead(int redY, int redX, int blueY, int blueX, int cnt) {
			this.redY = redY;
			this.redX = redX;
			this.blueY = blueY;
			this.blueX = blueX;
			this.cnt = cnt;
		}
	}

	static int[] dirY = { 1, 0, -1, 0 };
	static int[] dirX = { 0, 1, 0, -1 };

	static int N, M;
	static char[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int redY = 0, redX = 0, blueY = 0, blueX = 0;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = input.charAt(j);
				if (board[i][j] == 'R') {
					redY = i;
					redX = j;
					board[i][j] = '.';
				} else if (board[i][j] == 'B') {
					blueY = i;
					blueX = j;
					board[i][j] = '.';
				}

			}
		}

		bw.write(bfs(redY, redX, blueY, blueX) + "\n");
		bw.flush();
	}

	static int bfs(int redY, int redX, int blueY, int blueX) {
		Queue<Bead> queue = new LinkedList<>();
		boolean[][][][] visited = new boolean[N][M][N][M]; // redY, redX, blueY, blueX 방문 체크

		visited[redY][redX][blueY][blueX] = true;
		queue.add(new Bead(redY, redX, blueY, blueX, 0));

		while (!queue.isEmpty()) {
			int nowRedY = queue.peek().redY;
			int nowRedX = queue.peek().redX;
			int nowBlueY = queue.peek().blueY;
			int nowBlueX = queue.peek().blueX;
			int cnt = queue.peek().cnt;
			queue.poll();

			if (cnt > 10 || board[nowBlueY][nowBlueX] == 'O')
				continue;
			if (board[nowRedY][nowRedX] == 'O')
				return cnt;

			for (int d = 0; d < 4; d++) {
				Bead movedBead;
				if (redMoveFirst(nowRedY, nowRedX, nowBlueY, nowBlueX, d)) {
					movedBead = getMovedBead(nowRedY, nowRedX, nowBlueY, nowBlueX, cnt, d, true);
					movedBead = getMovedBead(movedBead.redY, movedBead.redX, nowBlueY, nowBlueX, cnt + 1, d, false);
				} else {
					movedBead = getMovedBead(nowRedY, nowRedX, nowBlueY, nowBlueX, cnt, d, false);
					movedBead = getMovedBead(nowRedY, nowRedX, movedBead.blueY, movedBead.blueX, cnt + 1, d, true);
				}
				if (visited[movedBead.redY][movedBead.redX][movedBead.blueY][movedBead.blueX])
					continue;

				visited[movedBead.redY][movedBead.redX][movedBead.blueY][movedBead.blueX] = true;
				queue.add(movedBead);
			}
		}
		return -1;
	}

	static boolean redMoveFirst(int redY, int redX, int blueY, int blueX, int dir) {
		if (dir == 0) { // down
			if (redY < blueY)
				return false;
		} else if (dir == 1) { // right
			if (redX < blueX)
				return false;
		} else if (dir == 2) { // up
			if (redY > blueY)
				return false;
		} else if (dir == 3) { // left
			if (redX > blueX)
				return false;
		}
		return true;
	}

	static Bead getMovedBead(int redY, int redX, int blueY, int blueX, int cnt, int dir, boolean redMove) {
		Bead movedBead;

		if (redMove) {
			int nextRedY = redY;
			int nextRedX = redX;

			while (board[nextRedY][nextRedX] == '.') {
				nextRedY += dirY[dir];
				nextRedX += dirX[dir];

				if (board[nextRedY][nextRedX] == 'O')
					break;
				if ((board[nextRedY][nextRedX] == '#') || (nextRedY == blueY && nextRedX == blueX)) {
					nextRedY -= dirY[dir];
					nextRedX -= dirX[dir];
					break;
				}
			}
			movedBead = new Bead(nextRedY, nextRedX, blueY, blueX, cnt);
		} else {
			int nextBlueY = blueY;
			int nextBlueX = blueX;

			while (board[nextBlueY][nextBlueX] == '.') {
				nextBlueY += dirY[dir];
				nextBlueX += dirX[dir];

				if (board[nextBlueY][nextBlueX] == 'O')
					break;
				if ((board[nextBlueY][nextBlueX] == '#') || (nextBlueY == redY && nextBlueX == redX)) {
					nextBlueY -= dirY[dir];
					nextBlueX -= dirX[dir];
					break;
				}
			}
			movedBead = new Bead(redY, redX, nextBlueY, nextBlueX, cnt);
		}
		return movedBead;
	}
}
