import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(getMultiple(N, arr));
	}

	private static int getMultiple(int N, int[] divisors) {
		int ans = 0;

		if (divisors.length == 1) {
			ans = (int) Math.pow(divisors[0], 2);
		} else {
			Arrays.sort(divisors);
			ans = divisors[N - 1] * divisors[0];
		}

		return ans;
	}
}