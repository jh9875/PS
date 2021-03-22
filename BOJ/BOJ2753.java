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

		if(N %4 ==0 && (N %100 !=0 || N %400 ==0)) bw.write("1\n");
		else bw.write("0\n");
		bw.flush();
	}
}
