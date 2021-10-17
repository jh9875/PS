import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] numberCheck = new boolean[2001];

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			numberCheck[n + 1000] = true;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 2001; i++) {
			if (numberCheck[i]) {
				sb.append(i - 1000).append(" ");
			}
		}
		System.out.println(sb.toString());
	}
}