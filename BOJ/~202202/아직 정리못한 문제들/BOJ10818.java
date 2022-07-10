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
		int max =Integer.MIN_VALUE, min =Integer.MAX_VALUE;
		int N;

		N =Integer.parseInt(br.readLine());
		st =new StringTokenizer(br.readLine());
		for(int i =0; i <N; ++i) {
			int n =Integer.parseInt(st.nextToken());
			if(n >max) max =n;
			if(n <min) min =n;
		} 
		bw.write(min +" " +max +"\n");
		bw.flush();
	}
}
