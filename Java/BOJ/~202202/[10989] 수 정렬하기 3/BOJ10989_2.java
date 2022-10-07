import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] numberCount = new int[10001];

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			numberCount[Integer.parseInt(br.readLine())]++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10001; i++) {
			int count = numberCount[i];
			for (int j = 0; j < count; j++) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}