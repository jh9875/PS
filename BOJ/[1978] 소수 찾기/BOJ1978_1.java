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
		int N;
		int ans =0;

		N =Integer.parseInt(br.readLine());
		st =new StringTokenizer(br.readLine());

		for(int i =0; i <N; ++i)
			if(isPrime(Integer.parseInt(st.nextToken())))
				++ans;

		bw.write(ans +"\n");
		bw.flush();
	}

	static boolean isPrime(int num) {
		if(num ==1) return false;

		for(int i =2; i*i <=num; ++i) {
			if(num %i ==0)
				return false;
		}
		return true;
	}
}
