import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static int[] coins;
	static int[] cache;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st =new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		K =Integer.parseInt(st.nextToken());
		coins =new int[N];
		cache =new int[10001];
		Arrays.fill(cache, -1);
		for(int i =0; i <N; ++i)
			coins[i] =Integer.parseInt(br.readLine());
		
		int ans =solve(0);
		if(ans ==987654321)	bw.write("-1\n");
		else bw.write(ans +"\n");
		bw.flush();
	}

	static int solve(int sum) {
		if(sum ==K) return 0;
		if(sum >K) return 987654321;
		if(cache[sum] !=-1) return cache[sum];
		int ret =987654321;

		for(int i =0; i <N; ++i)
			ret =Math.min(ret, solve(sum + coins[i]) +1);
		
		return cache[sum] =ret;
	}
}
