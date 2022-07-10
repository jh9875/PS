import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		int len;
		int[] alphabetCounter =new int[26];

		Arrays.fill(alphabetCounter, -1);

		input =br.readLine();
		len =input.length();

		for(int i =0; i <len; ++i) {
			int index =input.charAt(i) -'a';
			if(alphabetCounter[index] ==-1) alphabetCounter[index] =i;
		}
		for(int n : alphabetCounter)
			bw.write(n +" ");
		bw.flush();
	}
}