import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int score;

		score =Integer.parseInt(br.readLine());
		if(90 <=score && score <=100)
			bw.write("A\n");
		else if(80 <=score && score <90)
			bw.write("B\n");
		else if(70 <=score && score <80)
			bw.write("C\n");
		else if(60 <=score && score <70)
			bw.write("D\n");
		else
			bw.write("F\n");
		bw.flush();
	}	

}