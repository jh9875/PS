import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static String input;
	static int inputLen;
	static int index =0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		input =br.readLine();
		inputLen =input.length();

		bw.write(getUnzipedLen() +"\n");
		bw.flush();
	}

	static int getUnzipedLen() {
		int ret =0;

		while(index <inputLen) {
			char ch =input.charAt(index++);

			if(ch =='(') {
				--ret;
				int K =input.charAt(index-2)-'0';
				ret += K*getUnzipedLen();
			}else if(ch ==')') {
				return ret;
			}else {
				++ret;
			}
		}

		return ret;
	}

}
