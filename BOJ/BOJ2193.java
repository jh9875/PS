import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static long[][] cache;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N =Integer.parseInt(br.readLine());
		cache =new long[N][2];
		for(int i =1; i <N; ++i) {
			cache[i][0] =-1;
			cache[i][1] =-1;
		}

		bw.write(getNumOfPinaryNumber(1, 1) +"\n");
		bw.flush();
	}

	static long getNumOfPinaryNumber(int index, int prev) {
		if(index == N)
			return 1;
		if(cache[index][prev] !=-1)
			return cache[index][prev];
		long ret = 0;

		ret = getNumOfPinaryNumber(index+1, 0);
		if(prev == 0)
			ret += getNumOfPinaryNumber(index+1, 1);

		return cache[index][prev] =ret;
	}
}
