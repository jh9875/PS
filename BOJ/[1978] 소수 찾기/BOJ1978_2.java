import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static final int MAX =1000;
	static boolean[] isPrime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N;
		int ans =0;

		eratosthenes();

		N =Integer.parseInt(br.readLine());
		st =new StringTokenizer(br.readLine());

		for(int i =0; i <N; ++i)
			if(isPrime[Integer.parseInt(st.nextToken())])
				++ans;
		
		bw.write(ans +"\n");
		bw.flush();
	}

	static void eratosthenes() {
		isPrime = new boolean[MAX + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;

		int sqrtn = (int) Math.sqrt(MAX);

		for (int i = 2; i <= sqrtn; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= MAX; j += i)
					isPrime[j] = false;
			}
		}
	}
}
