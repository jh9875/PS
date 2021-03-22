import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] cost;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N =Integer.parseInt(br.readLine());
		cost =new int[N+1][N+1];

		for(int i =1; i <=N; ++i) {
			st =new StringTokenizer(br.readLine());
			for(int j =1; j <=N; ++j)
				cost[i][j] =Integer.parseInt(st.nextToken());
		}

		boolean[] visited =new boolean[N+1];
		bw.write(tsp(1, N, visited) +"\n");			//1번 도시로 시작.
		bw.flush();
	}

	//brute force 해결
	static int tsp(int here, int rest, boolean[] visited) {
		if(rest ==0 && here ==1) return 0;
		int ret =987654321;

		for(int there =1; there <=N; ++there) {
			if(visited[there] || cost[here][there] ==0) continue;

			visited[there] =true;
 			ret =Math.min(ret, tsp(there, rest-1, visited) +cost[here][there]);
			visited[there] =false;
		}

		return ret;
	}
}