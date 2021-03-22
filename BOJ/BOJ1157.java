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

		input =br.readLine().toUpperCase();
		len =input.length();

		for(int i =0; i <len; ++i)
			++alphabetCounter[input.charAt(i) -'A'];
		
		bw.write(getMostUsedAlph(alphabetCounter) +"\n");
		bw.flush();
	}

	static char getMostUsedAlph(int[] alphabetCounter) {
		int index =0;
		int maxValue =0;

		for(int i =0; i <26; ++i) {
			if(maxValue <alphabetCounter[i]) {
				index =i;
				maxValue =alphabetCounter[i];
			}
		}
		Arrays.sort(alphabetCounter);

		return alphabetCounter[alphabetCounter.length-2] ==maxValue ? '?' : (char)(index+65);
	}
}