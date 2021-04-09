import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static final int MOD = 1000000007;
	static int N;
	static List<Integer>[] graph;
	static int[][] cache;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int M;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new List[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();
		cache = new int[N + 1][7];
		for (int i = 1; i <= N; i++)
			Arrays.fill(cache[i], -1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		bw.write(search() + "\n");
		bw.flush();
	}

	static int search() {
		int ret = 0;
		for (int startVertexNum = 1; startVertexNum <= N; startVertexNum++)
			ret = (ret + moveNextVertex(startVertexNum, 0)) % MOD;
		return ret % MOD;
	}

	static int moveNextVertex(int nowVertexNum, int count) {
		if (count == 7)
			return 1;
		if (cache[nowVertexNum][count] != -1)
			return cache[nowVertexNum][count];
		int ret = 0;

		for (int nextvertexNum : graph[nowVertexNum])
			ret = (ret + moveNextVertex(nextvertexNum, count + 1)) % MOD;

		return cache[nowVertexNum][count] = ret % MOD;
	}
}
