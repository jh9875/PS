import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] rgbPayments;
	static int[][] cache;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		rgbPayments = new int[N][3];
		cache = new int[N][3];
		for (int i = 0; i < N; i++)
			Arrays.fill(cache[i], -1);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			rgbPayments[i][0] = Integer.parseInt(st.nextToken()); // r
			rgbPayments[i][1] = Integer.parseInt(st.nextToken()); // g
			rgbPayments[i][2] = Integer.parseInt(st.nextToken()); // b
		}

		bw.write(solution() + "\n");
		bw.flush();
	}

	static int solution() {
		return Math.min(getMinimumPaintingPayment(0, 0),
				Math.min(getMinimumPaintingPayment(0, 1), getMinimumPaintingPayment(0, 2)));
	}

	static int getMinimumPaintingPayment(int index, int color) {
		if (index == N)
			return 0;
		if (cache[index][color] != -1)
			return cache[index][color];
		int ret = rgbPayments[index][color];

		ret += Math.min(getMinimumPaintingPayment(index + 1, (color + 1) % 3),
				getMinimumPaintingPayment(index + 1, (color + 2) % 3));
		return cache[index][color] = ret;
	}
}