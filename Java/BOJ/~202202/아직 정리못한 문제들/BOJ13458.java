import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] A;
	static int B, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		long sum =0;
		
		N =Integer.parseInt(br.readLine());
		A =new int[N];

		st =new StringTokenizer(br.readLine());
		for(int i =0; i <N; ++i)
			A[i] =Integer.parseInt(st.nextToken());

		st =new StringTokenizer(br.readLine());
		B =Integer.parseInt(st.nextToken());
		C =Integer.parseInt(st.nextToken());

		for(int i =0; i <N; ++i) {
			A[i] -=B;
			++sum;

			if(A[i] >0) {
				sum +=A[i] /C;
				if(A[i] %C !=0) ++sum;
			}
		}
		bw.write(sum +"\n");
		bw.flush();
	}
}