import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] maze;
	static int[] cache;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N =Integer.parseInt(br.readLine());
		maze =new int[N+1];
		cache =new int[N+1];
		Arrays.fill(cache, -1);
		st =new StringTokenizer(br.readLine());
		for(int i =1; i <=N; ++i)
			maze[i] =Integer.parseInt(st.nextToken());
		
		int ans =escape(1);
		if(ans ==987654321)	bw.write("-1\n");
		else bw.write(escape(1) +"\n");
		bw.flush();
	}

	//dp »ç¿ë
	static int escape(int index) {
		if(index ==N) return 0;
		if(cache[index] !=-1) return cache[index];
		int ret =987654321;
		int maxJump =maze[index];

		for(int i =1; i <=maxJump; ++i) {
			if(index+i <=N)
				ret =Math.min(ret, escape(index+i) +1);
			
		}
		return cache[index] =ret;
	}
}
