import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		int N, sum =0;

		N =Integer.parseInt(br.readLine());
		input =br.readLine();

		for(int i =0; i <N; ++i)
			sum +=input.charAt(i) -'0';
		bw.write(sum +"\n");
		bw.flush();
	}
}
