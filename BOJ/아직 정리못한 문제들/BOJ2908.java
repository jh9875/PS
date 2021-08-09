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

		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();

		bw.write(getAnswerOfSangen(A, B) + "\n");
		bw.flush();
	}

	private static int getAnswerOfSangen(String A, String B) {
		String reverseA = new StringBuilder(A).reverse().toString();
		String reverseB = new StringBuilder(B).reverse().toString();
		int reverseIntA = Integer.parseInt(reverseA);
		int reverseIntB = Integer.parseInt(reverseB);

		return reverseIntA > reverseIntB ? reverseIntA : reverseIntB;
	}
}
