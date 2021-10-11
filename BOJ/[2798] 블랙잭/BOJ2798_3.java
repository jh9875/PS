import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] cards;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		cards = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(getBestBlackjackNumber(0, 3, 0));
	}

	private static int getBestBlackjackNumber(int index, int count, int sum) {
		if (count == 0) {
			return sum > M ? 0 : sum;
		}
		int ans = 0;
		for (int i = index; i < N; i++) {
			ans = Math.max(ans, getBestBlackjackNumber(i + 1, count - 1, sum + cards[i]));
		}
		return ans;
	}
}