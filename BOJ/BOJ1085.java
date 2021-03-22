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
		int x, y, w, h;
		int ans =Integer.MAX_VALUE;
		
		st =new StringTokenizer(br.readLine());
		x =Integer.parseInt(st.nextToken());
		y =Integer.parseInt(st.nextToken());
		w =Integer.parseInt(st.nextToken());
		h =Integer.parseInt(st.nextToken());

		ans =Math.min(ans, Math.abs(y-0));
		ans =Math.min(ans, Math.abs(h-y));
		ans =Math.min(ans, Math.abs(x-0));
		ans =Math.min(ans, Math.abs(w-x));
		
		bw.write(ans +"\n");
		bw.flush();
	}

}
