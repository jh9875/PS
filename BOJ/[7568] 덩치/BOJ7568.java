import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		int N = Integer.parseInt(br.readLine());
		Pair[] arr = new Pair[N];

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);
			arr[i] = new Pair(x, y);
		}

		// get answer
		int[] ans = getRating(N, arr);
		StringBuilder sb = new StringBuilder();

		// output
		for(int n : ans)
			sb.append(n).append(" ");
		System.out.println(sb.toString());
	}

	private static int[] getRating(int N, Pair[] arr) {
		int[] ans = new int[N];
		Arrays.fill(ans, 1);

		for (int i = 0; i < N; i++) {
			int x = arr[i].x;
			int y = arr[i].y;

			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;

				int otherX = arr[j].x;
				int otherY = arr[j].y;

				if (x < otherX && y < otherY)
					ans[i]++;
			}
		}

		return ans;
	}
}