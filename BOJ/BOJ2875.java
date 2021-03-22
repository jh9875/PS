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
		int N, M, K;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bw.write(maxTeam(N, M, K) + "\n");
		bw.flush();
	}

	static int maxTeam(int N, int M, int K) {
		int ret = 0;

		// 비율이 높은 성별 인턴으로
		while (K > 0) {
			if (N > M * 2)
				N--;
			else
				M--;
			K--;
		}

		while (N > 1 && M > 0) {
			N -= 2;
			M--;
			ret++;
		}

		return ret;
	}

}
