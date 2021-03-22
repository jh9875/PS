import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		int inputLen;

		input =br.readLine();
		inputLen =input.length();

		for(int i =0; i <inputLen; ++i) {
			char ch =input.charAt(i);
			if(65 <=ch && ch <=90)
				bw.write(ch +"");
		}
		bw.flush();
	}
}
