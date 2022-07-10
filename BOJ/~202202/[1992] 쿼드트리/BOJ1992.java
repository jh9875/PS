import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 1이면 true, 0이면 false
		boolean[][] video = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();

			for (int j = 0; j < N; j++) {
				video[i][j] = line.charAt(j) == '1' ? true : false;
			}
		}

		System.out.println(getPartOfQuadTree(0, 0, N, video));
	}

	private static String getPartOfQuadTree(int y, int x, int len, boolean[][] video) {
		if (isOneColor(y, x, len, video)) {
			return video[y][x] ? "1" : "0";
		}

		StringBuilder sb = new StringBuilder();
		int halfLen = len / 2;

		sb.append("(");
		sb.append(getPartOfQuadTree(y, x, halfLen, video));
		sb.append(getPartOfQuadTree(y, x + halfLen, halfLen, video));
		sb.append(getPartOfQuadTree(y + halfLen, x, halfLen, video));
		sb.append(getPartOfQuadTree(y + halfLen, x + halfLen, halfLen, video));
		sb.append(")");

		return sb.toString();
	}

	private static boolean isOneColor(int y, int x, int len, boolean[][] video) {
		boolean color = video[y][x];

		for (int i = y; i < y + len; i++) {
			for (int j = x; j < x + len; j++) {
				if (video[i][j] != color) {
					return false;
				}
			}
		}

		return true;
	}

}