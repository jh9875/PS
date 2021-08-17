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

		cache = new int[21];
		Arrays.fill(cache, -1);
		cache[0] = 0;
		cache[1] = 1;

		int n = Integer.parseInt(br.readLine());

		bw.write(fibonacci(n) + "\n");
		bw.flush();
	}

	private static int fibonacci(int n) {
		if (cache[n] != -1)
			return cache[n];
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
