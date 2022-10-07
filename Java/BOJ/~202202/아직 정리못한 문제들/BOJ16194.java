import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] cards;
	static int[] cache;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N =Integer.parseInt(br.readLine());
		cards =new int[N+1];
		cache =new int[N+1];
		Arrays.fill(cache, -1);

		st =new StringTokenizer(br.readLine());
		for(int i =1; i <=N; ++i)
			cards[i] =Integer.parseInt(st.nextToken());

		bw.write(solve(N) +"\n");
		bw.flush();
	}

	static int solve(int rest) {
		if(cache[rest] !=-1) return cache[rest];
		if(rest ==0) return 0;
		int ret =987654321;

		for(int i =1; i <=N; ++i) {
			if(rest -i >=0)
				ret =Math.min(ret, solve(rest -i) +cards[i]);
		}

		return cache[rest] =ret;
	}
}