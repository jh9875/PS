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

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int totalScore = 0;
			double GPA = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int C = Integer.parseInt(st.nextToken());
				double G = Double.parseDouble(st.nextToken());
				totalScore += C;
				GPA += C * G;
			}
			bw.write(totalScore + " " + (Math.round(GPA * 10 / totalScore) / 10.0) + "\n");
		}
		bw.flush();
	}

}