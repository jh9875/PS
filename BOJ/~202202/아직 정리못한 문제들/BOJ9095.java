import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T, n;

		T =Integer.parseInt(br.readLine());
		while(T-->0) {
			n =Integer.parseInt(br.readLine());
			bw.write(solve(n) +"\n");
		}
		bw.flush();
	}

	static int solve(int n) {
		if(n <0) return 0;
		if(n ==0) return 1;

		return solve(n-1) +solve(n-2) +solve(n-3);
	}
}
