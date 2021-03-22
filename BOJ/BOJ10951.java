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
		String input;
		

		while((input =br.readLine()) !=null) {
			st =new StringTokenizer(input);
			bw.write( ( Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) ) +"\n");
		}
		bw.flush();
	}

}