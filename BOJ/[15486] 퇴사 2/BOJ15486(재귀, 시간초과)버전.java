import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] T, P;
	static int[] cache;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		T = new int[N + 1];
		P = new int[N + 1];
		cache = new int[N + 1];
		Arrays.fill(cache, -1);

		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		bw.write(getMaxIncome(1) + "\n");
		bw.flush();
	}

	// 함수의 정의 : index일차부터 시작해서 상담했을 때 얻을 수 있는 최대 수익
	static int getMaxIncome(int index) {
		if (index > N)
			return 0;
		if (cache[index] != -1)
			return cache[index];
		int ret = 0;
		if (index + T[index] - 1 <= N)
			ret = getMaxIncome(index + T[index]) + P[index];
		ret = Math.max(ret, getMaxIncome(index + 1));
		return cache[index] = ret;
	}
}