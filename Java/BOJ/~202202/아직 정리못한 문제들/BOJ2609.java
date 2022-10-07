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
		int a, b;

		st =new StringTokenizer(br.readLine());
		a =Integer.parseInt(st.nextToken());
		b =Integer.parseInt(st.nextToken());
		int g =gcd(a, b);
		int lcm =a*b/g;
	
		bw.write(g +"\n" +lcm +"\n");
		bw.flush();
	}

	static int gcd(int a, int b) {
		if(b ==0) return a;
		return gcd(b, a%b);
	}
}
