import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	static int[] cache;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		cache = new int[N + 1];
		Arrays.fill(cache, -1);

		bw.write(fibonacci(N) + "\n");
		bw.flush();
	}

	static int fibonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (cache[n] != -1)
			return cache[n];
		return cache[n] = fibonacci(n - 1) + fibonacci(n - 2);
	}

}
