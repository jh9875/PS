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
		int N, ans;

		N =Integer.parseInt(br.readLine());
		cache =new int[N+1];
		Arrays.fill(cache, -1);

		ans =minBags(N);
		if(ans ==987654321) bw.write("-1\n");
		else bw.write(ans +"\n");
		bw.flush();
	}

	static int minBags(int rest) {
		if(rest ==0) return 0;
		if(cache[rest] !=-1) return cache[rest];
		int ret =987654321;

		if(rest -5 >=0) ret =Math.min(ret, minBags(rest -5) +1);
		if(rest -3 >=0) ret =Math.min(ret, minBags(rest -3) +1);

		return cache[rest] =ret;
	}

} 