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
		int N, K;
		int[] coins;

		st =new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		K =Integer.parseInt(st.nextToken());
		coins =new int[N];
		for(int i =0; i <N; ++i)
			coins[i] =Integer.parseInt(br.readLine());
			
		bw.write(minimumCoins(N, K, coins) +"\n");
		bw.flush();
	}

	static int minimumCoins(int N, int K, int[] coins) {
		int ret =0;

		//단순하게 뺄필요 없이 나누면 되는구나..
		for(int i =N-1; i >=0; --i) {
			if(coins[i] <=K) {
				ret +=K/coins[i];
				 K %=coins[i];
			}
		}

		return ret;
	}
}
