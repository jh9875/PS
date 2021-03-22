import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int A;
		String B;

		A =Integer.parseInt(br.readLine());
		B =br.readLine();

		for(int i =2; i >=0; --i)
			bw.write(A*(B.charAt(i)-'0') +"\n");
		bw.write(A*Integer.parseInt(B) +"\n");
		bw.flush();
	}


}
