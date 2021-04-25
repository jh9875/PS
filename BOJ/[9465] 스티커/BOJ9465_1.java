import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] sticker;
	static int[][] cache;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			n = Integer.parseInt(br.readLine());
			sticker = new int[2][n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				sticker[0][i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				sticker[1][i] = Integer.parseInt(st.nextToken());
			bw.write(solution() + "\n");
		}
		bw.flush();
	}

	private static int solution() {
		cache = new int[2][n];
		Arrays.fill(cache[0], -1);
		Arrays.fill(cache[1], -1);
		return Math.max(search(0, 0), search(1, 0));
	}

	private static int search(int row, int col) {
		if (col == n)
			return 0;
		if (cache[row][col] != -1)
			return cache[row][col];
		return cache[row][col] = Math.max(search((row + 1) % 2, col + 1) + sticker[row][col],
				Math.max(search(row, col + 1), search((row + 1) % 2, col + 1)));
	}
}