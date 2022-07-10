import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int C = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int P = Integer.parseInt(input[2]);

		int ans = K * (C * (C + 1) / 2) + P * (C * (C + 1) * (2 * C + 1) / 6);
		System.out.println(ans);
	}

}