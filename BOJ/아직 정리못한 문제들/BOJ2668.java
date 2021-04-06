import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N;
	static int cnt =0;
	static int[] arr;
	static boolean[] visited;
	static boolean[] cycle;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N =Integer.parseInt(br.readLine());
		arr =new int[N+1];
		visited =new boolean[N+1];
		cycle =new boolean[N+1];
		for(int i =1; i <=N; ++i)
			arr[i] =Integer.parseInt(br.readLine());
		
		solve();
		bw.write(cnt +"\n");
		for(int i =1; i <=N; ++i)
			if(cycle[i]) bw.write(i +"\n");
		bw.flush();
	}

	static void solve() {
		for(int start =1; start <=N; ++start) {
			dfs(start, arr[start]);
			for(int i =1; i <=N; ++i)
				visited[i] =cycle[i];
		}
	}
	static boolean dfs(int start, int now) {
		if(visited[now])
			return false;

		visited[now] =true;

		if(start==now || dfs(start, arr[now])) {
			++cnt;
			cycle[now] =true;
			return true;
		}
		return false;
	}
}
