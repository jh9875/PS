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
		int A, B;

		st =new StringTokenizer(br.readLine());
		A =Integer.parseInt(st.nextToken());
		B =Integer.parseInt(st.nextToken());

		if(A <B)
			bw.write("<\n");
		else if(A >B)
			bw.write(">\n");
		else
			bw.write("==\n");
		bw.flush();
	}
}
