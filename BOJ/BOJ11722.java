import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	static int[] arr;
	static int[] cache;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N =Integer.parseInt(br.readLine());
		arr =new int[N+1];
		cache =new int[N+1];
		Arrays.fill(cache, -1);
		st =new StringTokenizer(br.readLine());
		for(int i =1; i <=N; ++i)
			arr[i] =Integer.parseInt(st.nextToken());


		bw.write(solve(0) +"\n");
		bw.flush();
	}

	static int solve(int index) {
		if(cache[index] !=-1)
			return cache[index];
		int ret =0;

		for(int next =index+1; next <=N; ++next)
			if(index ==0 || arr[index] >arr[next])
				ret =Math.max(ret, solve(next) +1);
		return cache[index] =ret;
	}	
}
