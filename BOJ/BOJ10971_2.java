import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] costs;
	static int[][] cache;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N =Integer.parseInt(br.readLine());
		costs =new int[N][N];
		cache =new int[N][1<<N];

		for(int i =0; i <N; ++i)
			Arrays.fill(cache[i], -1);

		for(int i =0; i <N; ++i) {
			st =new StringTokenizer(br.readLine());
			for(int j =0; j <N; ++j)
				costs[i][j] =Integer.parseInt(st.nextToken());
		}

		bw.write(tsp(0, 1) +"\n");									//0번 도시로 시작.
		bw.flush();
	}

	//dp 사용
	static int tsp(int here, int visit) {
		if( visit ==(1<<N)-1 && costs[here][0] !=0) { 
			return costs[here][0];
		}
		if(cache[here][visit] !=-1) return cache[here][visit];
		int ret =987654321;

		for(int i =0; i <N; ++i) {
			int there =visit & (1<<i);
			if(there !=0 || costs[here][i] ==0) continue;

			ret =Math.min(ret, tsp(i, visit|(1<<i))+costs[here][i]);
		}

		return cache[here][visit] =ret;
	}
}