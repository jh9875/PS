import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	static int[] cache;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N;

		N =Integer.parseInt(br.readLine());
		cache =new int[N+1];
		Arrays.fill(cache, -1);

		bw.write(makeOne(N) +"\n");
		bw.flush();
	}

	static int makeOne(int N) {
		if(N ==1) return 0;
		if(cache[N] !=-1) return cache[N];

		int ret =987654321;

		if(N %3 ==0) ret =Math.min(ret, makeOne(N/3) +1);
		if(N %2 ==0) ret =Math.min(ret, makeOne(N/2) +1);
		if(N >1) ret =Math.min(ret, makeOne(N-1) +1);

		return cache[N] =ret;
	}

}
