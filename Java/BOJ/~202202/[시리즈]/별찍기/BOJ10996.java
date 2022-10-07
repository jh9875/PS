import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j % 2 == 0)
					sb.append("*");
				else
					sb.append(" ");
			}
			sb.append("\n");
			for (int j = 1; j <= N; j++) {
				if (j % 2 == 0)
					sb.append("*");
				else
					sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}