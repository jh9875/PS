import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visited;
	static int[] ans;

	static int N;
	static List<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N =Integer.parseInt(br.readLine());
		ans =new int[N+1];
		visited =new boolean[N+1];
		graph =new ArrayList[N+1];
		for(int i =1; i <=N; ++i)
			graph[i] =new ArrayList<>();
		for(int i =1; i <N; ++i) {
			st =new StringTokenizer(br.readLine());
			int n1 =Integer.parseInt(st.nextToken());
			int n2 =Integer.parseInt(st.nextToken());
			graph[n1].add(n2);
			graph[n2].add(n1);
		}
		dfs(1);
		for(int i =2; i <=N; ++i)
			bw.write(ans[i] +"\n");
		bw.flush();
	}

	static void dfs(int index) {
		visited[index] =true;

		for(int child : graph[index]) {
			if(visited[child]) continue;

			ans[child] =index;
			dfs(child);
		}
	}
}
