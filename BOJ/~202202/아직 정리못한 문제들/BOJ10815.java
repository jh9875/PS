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
		int N, M;
		boolean[] cards =new boolean[20000001];

		N =Integer.parseInt(br.readLine());
		st =new StringTokenizer(br.readLine());
		for(int i =0; i <N; ++i)
			cards[Integer.parseInt(st.nextToken()) +10000000] =true;
		
		M =Integer.parseInt(br.readLine());
		st =new StringTokenizer(br.readLine());
		for(int i =0; i <M; ++i) {
			if(cards[Integer.parseInt(st.nextToken()) +10000000]) {
				bw.write(1 +" ");
			}else {
				bw.write(0 +" ");
			}
		}
		bw.flush();				
	}
}
