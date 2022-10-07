import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] T, P;
	static int[] cache;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N =Integer.parseInt(br.readLine());
		T =new int[N];
		P =new int[N];
		cache =new int[N];
		Arrays.fill(cache, -1);

		for(int i =0; i <N; ++i) {
			st =new StringTokenizer(br.readLine());
			T[i] =Integer.parseInt(st.nextToken());
			P[i] =Integer.parseInt(st.nextToken());
		}
		bw.write(getMaxIncome(0) +"\n");
		bw.flush();
	}

	static int getMaxIncome(int index) {
		if(index ==N) return 0;
		if(cache[index] !=-1) return cache[index];
		int ret =0;

		for(int i =index; i <N; ++i) {
			if(i+T[i] <=N)
				ret =Math.max(ret, getMaxIncome(i +T[i]) +P[i]);
		}

		return cache[index] =ret;
	}
}
