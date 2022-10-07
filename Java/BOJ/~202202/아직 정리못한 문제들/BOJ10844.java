import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	static final int MOD =1000000000;
	static int N;
	static int[][] cache;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N =Integer.parseInt(br.readLine());
		cache =new int[N+1][10];
		for(int i =1; i <=N; ++i)
			Arrays.fill(cache[i], -1);
		bw.write(solve() +"\n");
		bw.flush();
	}

	//모듈러 한 값을 더하는 것이기 대문에 범위를 넘어갈 수 있다. 그럼으로 long으로..
	static long solve() {
		long ret =0;

		for(int start =1; start <10; ++start)
			ret += easyStairsNumber(1, start)%MOD;
		
		return ret%MOD;
	}

	static int easyStairsNumber(int index, int prev) {
		if(index ==N)
			return 1;
		if(cache[index][prev] !=-1)
			return cache[index][prev];

		int ret =0;

		if(prev-1 >=0) ret += easyStairsNumber(index+1, prev-1)%MOD;
		if(prev+1 <=9) ret += easyStairsNumber(index+1, prev+1)%MOD;

		return cache[index][prev] =ret%MOD;
	}

}
