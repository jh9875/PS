import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;

		input =br.readLine();
		if(input.equals("") || input.equals(" ")) bw.write("0\n");
		else bw.write(input.trim().split(" ").length +"\n");
		
		bw.flush();
	}
}