import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		int T;

		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			input = br.readLine();
			int len = input.length();
			int parenthesis = 0;

			for (int i = 0; i < len; i++) {
				if (input.charAt(i) == '(')
					++parenthesis;
				else
					--parenthesis;

				if (parenthesis < 0)
					break;
			}
			if (parenthesis == 0)
				bw.write("YES\n");
			else
				bw.write("NO\n");
		}
		bw.flush();

	}

}
