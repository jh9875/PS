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
		int h, m;

		st =new StringTokenizer(br.readLine());
		h =Integer.parseInt(st.nextToken());
		m =Integer.parseInt(st.nextToken());

		m =m-45;
		if(m <0) {
			--h;
			m =60+m;
			if(h <0)
				h =23;
		}
		bw.write(h +" " +m +"\n");
		bw.flush();
	}
}
