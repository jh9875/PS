import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static final int MOD =1000000009;
	static long[] cache;

	//반복문 사용.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T, N;

		cache =new long[1000001];

		cache[1] =1; cache[2] =2; cache[3] =4;
		for(int i =4; i <1000001; ++i) {
			cache[i] =cache[i-1] +cache[i-2] +cache[i-3];
			cache[i] %=MOD;
		}

		T =Integer.parseInt(br.readLine());
		while(T-->0) {
			N =Integer.parseInt(br.readLine());
			bw.write(cache[N] +"\n");
		}
		bw.flush();
	}
}
