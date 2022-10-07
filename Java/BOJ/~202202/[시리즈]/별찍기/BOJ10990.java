import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - i -1; j++)
				bw.write(" ");
			bw.write("*");
			for (int j = 0; j < 2 * i - 1; j++)
				bw.write(" ");
			if (i != 0)
				bw.write("*");
			bw.write("\n");
		}
		bw.flush();
	}

}
