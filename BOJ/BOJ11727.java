import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	static final int MOD =10007;
	static int[] cache;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N;

		N =Integer.parseInt(br.readLine());
		cache =new int[N+1];
		Arrays.fill(cache, -1);

		bw.write(tiling2(N)%MOD +"\n");
		bw.flush();
	}

	static int tiling2(int N) {
		if(N ==0) return 1;
		if(cache[N] !=-1) return cache[N];
		int ret =0;

		ret =tiling2(N-1)%MOD;
		if(N-2 >=0) ret +=tiling2(N-2)*2%MOD;

		return cache[N] =ret%MOD;
	}
}
