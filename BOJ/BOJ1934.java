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
		int T, A, B;
		
		T =Integer.parseInt(br.readLine());
		while(T-->0) {
			st =new StringTokenizer(br.readLine());
			A =Integer.parseInt(st.nextToken());
			B =Integer.parseInt(st.nextToken());
			bw.write(lcm(A, B) +"\n");
		}
		bw.flush();
	}

	static int lcm(int A, int B) {
		return A*B /gcd(A, B);
	}
	static int gcd(int A, int B) {
		if(B ==0) return A;
		return gcd(B, A%B);
	}
}
