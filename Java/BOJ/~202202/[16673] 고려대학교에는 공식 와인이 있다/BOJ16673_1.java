import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int C = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int P = Integer.parseInt(input[2]);

		int ans = 0;
		for (int i = 1; i <= C; i++) {
			ans += ((i * K) + (i * i * P));
		}

		System.out.println(ans);
	}

}