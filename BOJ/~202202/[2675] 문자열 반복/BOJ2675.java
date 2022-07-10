import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int testCase = 0;

		testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			st = new StringTokenizer(br.readLine());
			int repeatNum = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			bw.write(getRepeatedStr(repeatNum, s) + "\n");
		}
		bw.flush();
	}

	static String getRepeatedStr(int R, String s) {
		StringBuilder sb = new StringBuilder();
		char[] charArr = s.toCharArray();

		for (char ch : charArr) {
			for (int i = 0; i < R; i++)
				sb.append(ch);
		}
		return sb.toString();
	}
}