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
		int N, R, C;

		st =new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		R =Integer.parseInt(st.nextToken());
		C =Integer.parseInt(st.nextToken());
	
		for(int r =1; r <=N; ++r) {
			for(int c =1; c <=N; ++c) {
				if((R+C)%2 == (r+c)%2)
					bw.write("v");
				else
					bw.write(".");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
