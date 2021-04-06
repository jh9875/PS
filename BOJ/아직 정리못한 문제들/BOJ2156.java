import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	static int N;
	static int[] wine;
	static int[] cache;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N =Integer.parseInt(br.readLine());
		wine =new int[N];
		cache =new int[N];
		Arrays.fill(cache, -1);
		for(int i =0; i <N; ++i)
			wine[i] =Integer.parseInt(br.readLine());
		
		bw.write(solve(0) +"\n");
		bw.flush();
	}

	static int solve(int index) {
		if(index >=N) return 0;
		if(cache[index] !=-1) return cache[index];
		int ret =0;
		
		ret =Math.max(ret, solve(index+1));									//안마시고 다음 와인으로
		ret =Math.max(ret, solve(index+2) +wine[index]);					//현재 와인 마시고 한 칸 넘김
		if(index+1 <N)
			ret =Math.max(ret, solve(index+3) +wine[index]+wine[index+1]);	//연속 2잔 마시고 한 개 넘김.
		
		return cache[index] =ret;
	}

}
