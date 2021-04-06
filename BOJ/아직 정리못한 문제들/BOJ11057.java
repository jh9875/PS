import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	static final int MOD =10007;
	static int N;
	static int[][] cache;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N =Integer.parseInt(br.readLine());
		cache =new int[N][10];
		for(int i =0; i <N; ++i)
			Arrays.fill(cache[i], -1);

		bw.write(ascNum(0, 0) +"\n");
		bw.flush();
	}

	static int ascNum(int index, int prev) {
		if(index ==N) return 1;
		if(cache[index][prev] !=-1) return cache[index][prev];
		int ret =0;

		for(int next =prev; next <10; ++next)
			ret +=ascNum(index+1, next) %MOD;

		return cache[index][prev] =ret %MOD;
	}

} 