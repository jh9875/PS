import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N;
		int[] T, P;

		N = Integer.parseInt(br.readLine());
		T = new int[N + 1];
		P = new int[N + 1];

		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		bw.write(getMaxIncome(N, T, P) + "\n");
		bw.flush();
	}

	static int getMaxIncome(int N, int[] T, int[] P) {
		int[] dp = new int[N + 2];

		for (int i = N; i >= 1; i--) {
			if (i + T[i] > N + 1)
				dp[i] = dp[i + 1];
			else
				dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
		}
		return dp[1];
	}
}