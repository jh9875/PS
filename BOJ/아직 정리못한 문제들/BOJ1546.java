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
		int[] score = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			score[i] = Integer.parseInt(st.nextToken());

		bw.write(getSejunAverage(N, score) + "\n");
		bw.flush();
	}

	private static double getSejunAverage(int N, int[] score) {
		double ret = 0.0;

		Arrays.sort(score);
		int M = score[N - 1];

		for (int i = 0; i < N; i++) {
			double changedValue = (double) score[i] / M * 100;
			ret += changedValue;
		}

		return ret / N;
	}
}
