import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static int[][] cache;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] triangle = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");

			for (int j = 0; j <= i; j++) {
				triangle[i][j] = Integer.parseInt(line[j]);
			}
		}

		init(N);

		System.out.println(getMaximumSum(0, 0, N, triangle));
	}

	private static void init(int N) {
		cache = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(cache[i], -1);
		}
	}

	private static int getMaximumSum(int row, int col, int N, int[][] triangle) {
		if (row == N)
			return 0;
		if (cache[row][col] != -1)
			return cache[row][col];

		int ret = 0;

		ret = Math.max(getMaximumSum(row + 1, col, N, triangle), getMaximumSum(row + 1, col + 1, N, triangle))
				+ triangle[row][col];

		return cache[row][col] = ret;
	}
}