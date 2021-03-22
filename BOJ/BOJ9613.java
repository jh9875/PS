import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T, N;
		int[] numbers;

		T =Integer.parseInt(br.readLine());
		while(T-->0) {
			st =new StringTokenizer(br.readLine());
			N =Integer.parseInt(st.nextToken());
			numbers =new int[N];

			for(int i =0; i <N; ++i)
				numbers[i] =Integer.parseInt(st.nextToken());
			
			long sum =0;
			for(int i =0; i <N; ++i) {
				for(int j =i+1; j <N; ++j) {
					sum +=gcd(numbers[i], numbers[j]);
				}
			}
			bw.write(sum +"\n");
		}
		bw.flush();
	}

	static int gcd(int A, int B) {
		if(B ==0) return A;
		return gcd(B, A%B);
	}
}
