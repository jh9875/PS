import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		if (N % 2 == 0) {
			bw.write("I LOVE CBNU");
		} else {
			for (int star = 0; star < N; star++)
				bw.write("*");
			bw.write("\n");

			for (int line = 0; line < N / 2 + 1; line++) {
				for (int space = 0; space < N / 2 - line; space++)
					bw.write(" ");
				bw.write("*");
				if (line != 0) {
					for (int space = 0; space < 2 * line - 1; space++)
						bw.write(" ");
					bw.write("*\n");
				} else {
					bw.write("\n");
				}

			}
		}
		bw.flush();
	}

}