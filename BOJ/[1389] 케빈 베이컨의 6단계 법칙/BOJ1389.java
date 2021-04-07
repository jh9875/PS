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
		int[][] relations;
		int N, M;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		relations = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(relations[i], 1000);
			relations[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			relations[A][B] = 1;
			relations[B][A] = 1;
		}
		floyd(N, relations);
		bw.write(smallestKevinBacon(N, relations) + "\n");
		bw.flush();
	}

	static void floyd(int N, int[][] relations) {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					relations[i][j] = Math.min(relations[i][j], relations[i][k] + relations[k][j]);
				}
			}
		}
	}

	static int smallestKevinBacon(int N, int[][] relations) {
		int minIndex = 0;
		int minValue = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			int value = sumOfArray(N, relations[i]);
			if (value < minValue) {
				minIndex = i;
				minValue = value;
			}
		}
		return minIndex;
	}

	static int sumOfArray(int N, int[] arr) {
		int sum = 0;
		for (int i = 1; i <= N; i++)
			sum += arr[i];
		return sum;
	}
}
