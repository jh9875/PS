import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static List<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int M;

		st =new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		graph =new ArrayList[N+1];
		for(int i =1; i <=N; ++i)
			graph[i] =new ArrayList<>();
		while(M-->0) {
			st =new StringTokenizer(br.readLine());
			int u =Integer.parseInt(st.nextToken());
			int v =Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		bw.write(numOfConnectedComponent() +"\n");
		bw.flush();
	}

	static int numOfConnectedComponent() {
		int ret =0;
		boolean[] visited =new boolean[N+1];
		
		for(int start =1; start <=N; ++start) {
			if(!visited[start]) {
				dfs(start, visited);
				++ret;
			}
		}

		return ret;
	}

	static void dfs(int index, boolean[] visited) {
		visited[index] =true;

		for(int next : graph[index]) {
			if(!visited[next])
				dfs(next, visited);
		}
	}
}