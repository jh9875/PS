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
		int[] A;
		int[] B;

		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			B[i] = Integer.parseInt(st.nextToken());
		bw.write(getResult(N, A, B) +"\n");
		bw.flush();
	}

	private static int getResult(int N, int[] A, int[] B) {
		int result = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		for (int i = 0; i < N; i++)
			result += A[i] * B[N-i-1];
		return result;
	}

}
