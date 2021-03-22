import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N;

		N =Integer.parseInt(br.readLine());

		for(int i =0; i <N; ++i) {
			if(i%2 == 0) {
				for(int j =0; j <N; ++j)
					bw.write("* ");
			}else {
				for(int j =0; j <N; ++j)
					bw.write(" *");
			}
			bw.write("\n");
		}
		bw.flush();
	}

}
