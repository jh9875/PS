import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		int ans = factorial(N) / (factorial(K) * factorial(N - K));
		System.out.println(ans);
	}

	private static int factorial(int n) {
		int result = 1;

		for (int i = 1; i <= n; i++)
			result *= i;

		return result;
	}
}