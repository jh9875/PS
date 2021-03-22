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
		int E, S, M, e =1, s =1, m =1;
		int cnt =1;

		st =new StringTokenizer(br.readLine());
		E =Integer.parseInt(st.nextToken());
		S =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());

		while(true) {
			if(E ==e && S ==s && M ==m) break;

			++e; ++s; ++m;
			if(e >15) e =1;
			if(s >28) s =1;
			if(m >19) m =1;
			++cnt;
		}
		bw.write(cnt +"\n");
		bw.flush();
	}
}
