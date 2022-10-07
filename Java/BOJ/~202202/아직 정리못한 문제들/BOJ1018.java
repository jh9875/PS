import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static int N, M;
	private static char[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		board = new char[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();

			for (int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
			}
		}

		System.out.println(solve());
	}

	private static int solve() {
		int ret = Integer.MAX_VALUE;

		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				if (row + 8 <= N && col + 8 <= M) {
					ret = Math.min(ret, getNumberOfDiff('W', new boolean[N][M], row, col, row + 8, col + 8));
					ret = Math.min(ret, getNumberOfDiff('B', new boolean[N][M], row, col, row + 8, col + 8));
				}
			}
		}

		return ret;
	}

	private static int getNumberOfDiff(char color, boolean[][] isChecked, int row, int col, int rowEnd, int colEnd) {
		isChecked[row][col] = true;
		int ret = color == board[row][col] ? 0 : 1;

		char nextColor = getNextColor(color);
		if (inRange(row + 1, col, rowEnd, colEnd) && !isChecked[row + 1][col]) {
			ret += getNumberOfDiff(nextColor, isChecked, row + 1, col, rowEnd, colEnd);
		}
		if (inRange(row, col + 1, rowEnd, colEnd) && !isChecked[row][col + 1]) {
			ret += getNumberOfDiff(nextColor, isChecked, row, col + 1, rowEnd, colEnd);
		}

		return ret;
	}

	private static boolean inRange(int row, int col, int rowEnd, int colEnd) {
		if (row < 0 || row >= rowEnd || col < 0 || col >= colEnd)
			return false;
		return true;
	}

	private static char getNextColor(char current) {
		return current == 'W' ? 'B' : 'W';
	}

}