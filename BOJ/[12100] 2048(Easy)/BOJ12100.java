import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] dirY = { 1, 0, -1, 0 };
	static int[] dirX = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N;
		int[][] board;

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		bw.write(simulateMoveBlock(N, board, 0) + "\n");
		bw.flush();
	}

	static int simulateMoveBlock(int N, int[][] board, int numOfMove) {
		if (numOfMove > 5)
			return 0;
		int ret = maxValueOfBoard(N, board);

		for (int dir = 0; dir < 4; dir++) {
			int[][] movedBoard = getMovedBoard(N, board, dir);
			ret = Math.max(ret, simulateMoveBlock(N, movedBoard, numOfMove + 1));
		}
		return ret;
	}

	static int[][] getMovedBoard(int N, int[][] board, int dir) {
		int[][] movedBoard = getCopyBoard(N, board);
		boolean[][] changed = new boolean[N][N];

		switch (dir) {
		case 0: // south
			for (int x = 0; x < N; x++) {
				for (int y = N - 1; y >= 0; y--) {
					if (board[y][x] != 0)
						moveNumber(y, x, N, movedBoard, dir, changed);
				}
			}
			break;
		case 1: // east
			for (int y = 0; y < N; y++) {
				for (int x = N - 1; x >= 0; x--) {
					if (board[y][x] != 0)
						moveNumber(y, x, N, movedBoard, dir, changed);
				}
			}
			break;
		case 2: // north
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					if (board[y][x] != 0)
						moveNumber(y, x, N, movedBoard, dir, changed);
				}
			}
			break;
		case 3: // west
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (board[y][x] != 0)
						moveNumber(y, x, N, movedBoard, dir, changed);
				}
			}
			break;
		}
		return movedBoard;
	}

	static void moveNumber(int y, int x, int N, int[][] board, int dir, boolean[][] changed) {
		int value = board[y][x];
		board[y][x] = 0;

		while (true) {
			int nextY = y + dirY[dir];
			int nextX = x + dirX[dir];

			if (inRange(nextY, nextX, N)) {
				if (board[nextY][nextX] != 0) {
					if (!changed[nextY][nextX]) {
						if (value == board[nextY][nextX]) {
							board[nextY][nextX] *= 2;
							changed[nextY][nextX] = true;
						} else { // 숫자가 다른 경우.
							board[y][x] = value;
						}
					} else { // 이미 바뀐경우
						board[y][x] = value;
					}
					break;
				}
			} else { // 보드의 범위를 벗어남.
				board[y][x] = value;
				break;
			}
			y = nextY;
			x = nextX;
		}
	}

	static boolean inRange(int y, int x, int N) {
		if (y < 0 || y >= N || x < 0 || x >= N)
			return false;
		return true;
	}

	static int[][] getCopyBoard(int N, int[][] board) {
		int[][] copy = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				copy[i][j] = board[i][j];
		return copy;
	}

	static int maxValueOfBoard(int N, int[][] board) {
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, board[i][j]);
			}
		}
		return max;
	}
}
