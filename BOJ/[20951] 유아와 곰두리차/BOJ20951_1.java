import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static final int MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		List<Integer>[] graph;
		int N, M;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new List[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}

		bw.write(solve(N, graph) + "\n");
		bw.flush();
	}

	// 반복적 dp
	static int solve(int N, List<Integer>[] graph) {
		int[][] dp = new int[8][N + 1]; // [count][정점의 번호]
		for (int i = 1; i <= N; i++)
			dp[0][i] = 1;
		for (int count = 1; count <= 7; count++) {
			for (int vertexNum = 1; vertexNum <= N; vertexNum++) {
				for (int adjVertexNum : graph[vertexNum])
					dp[count][adjVertexNum] = (dp[count][adjVertexNum] + dp[count - 1][vertexNum]) % MOD;
			}
		}

		int ret = 0;
		for (int i = 1; i <= N; i++)
			ret = (ret + dp[7][i]) % MOD;
		return ret;
	}
}
