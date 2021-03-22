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
		int L, n, answer = 0;
		int[] S;

		L = Integer.parseInt(br.readLine());
		S = new int[L];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < L; i++)
			S[i] = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(br.readLine());

		if (nInS(S, n)) {
			bw.write(0 + "\n");
		} else {
			Arrays.sort(S);

			int A = getA(S, n) + 1;
			int B = getB(S, n) - 1;

			for (int left = A; left <= n; left++) {
				for (int right = n == left ? left + 1 : n; right <= B; right++) {
					answer++;
				}
			}
			bw.write(answer + "\n");
		}

		bw.flush();
	}

	static boolean nInS(int[] S, int n) {
		int len = S.length;

		for (int i = 0; i < len; i++)
			if (S[i] == n)
				return true;
		return false;
	}

	static int getA(int[] S, int n) {
		int len = S.length;
		int leftIndex = 0;

		while (leftIndex < len) {
			if (S[leftIndex] < n)
				leftIndex++;
			else {
				leftIndex--;
				break;
			}
		}
		return leftIndex == -1 ? 0 : S[leftIndex];
	}

	static int getB(int[] S, int n) {
		int len = S.length;
		int rightIndex = len - 1;

		while (0 <= rightIndex) {
			if (n < S[rightIndex])
				rightIndex--;
			else {
				rightIndex++;
				break;
			}
		}
		return rightIndex == -1 ? S[0] : S[rightIndex];
	}
}
