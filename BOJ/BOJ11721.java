import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		int len, index =0;

		input =br.readLine();
		len =input.length();

		while(index <len) {
			if(index+10 <len)
				bw.write(input.substring(index, index+10));
			else 
				bw.write(input.substring(index, len));
			bw.write("\n");
			index +=10;
		}
		bw.flush();
	}
}