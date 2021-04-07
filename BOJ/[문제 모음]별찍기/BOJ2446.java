import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		for (int i = N; i > 0; i--) {
			for (int j = 0; j < N - i; j++)
				bw.write(" ");
			for (int j = 0; j < i * 2 - 1; j++)
				bw.write("*");
			bw.write("\n");
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < N - i; j++)
				bw.write(" ");
			for (int j = 0; j < i * 2 - 1; j++)
				bw.write("*");
			bw.write("\n");
		}
		bw.flush();
	}
}
