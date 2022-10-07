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
		String A, B;
		int aLen, diff;
		int ans =50;

		st =new StringTokenizer(br.readLine());
		A =st.nextToken();
		B =st.nextToken();
		aLen =A.length();
		diff =B.length()-aLen;

		for(int start =0; start <=diff; ++start) {
			int cnt =0;

			for(int i =0; i <aLen; ++i) {
				if(A.charAt(i) !=B.charAt(i +start)) ++cnt;
			}
			ans =Math.min(ans, cnt);
		}
		bw.write(ans +"\n");
		bw.flush();
	}
} 