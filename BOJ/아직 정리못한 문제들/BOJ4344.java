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
		StringTokenizer st;

		int C = Integer.parseInt(br.readLine());

		while (C-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] score = new int[N];

			for (int i = 0; i < N; i++) {
				score[i] = Integer.parseInt(st.nextToken());
			}

			double result = getPercentageOfOverAverage(N, score);
			bw.write(String.format("%.3f", result) +"%\n");
		}
		bw.flush();
	}

	private static double getPercentageOfOverAverage(int N, int[] score) {
		double average = getAverage(N, score);
		int count = 0;

		for (int num : score) {
			if (num > average)
				count++;
		}

		return (double)count / N * 100;
	}

	private static double getAverage(int N, int[] score) {
		int sum = 0;

		for (int num : score)
			sum += num;

		return (double) sum / N;
	}
}
