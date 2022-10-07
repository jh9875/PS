import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		boolean findFlag = false;
		int minimum = Integer.MAX_VALUE;
		int sum = 0;

		for (int i = M; i <= N; i++) {
			if (isPrime(i)) {
				sum += i;
				if (!findFlag) {
					findFlag = true;
					minimum = i;
				}
			}
		}

		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(minimum);
		}
	}

	private static boolean isPrime(int num) {
		if (num == 1)
			return false;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}