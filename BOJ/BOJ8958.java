import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T;

		T =Integer.parseInt(br.readLine());
		while(T-->0) {
			bw.write(getOXScore(br.readLine()) +"\n");
		}
		bw.flush();
	}

	static int getOXScore(String input) {
		int ret =0;
		int len =input.length();
		int cnt =1;

		for(int i =0; i <len; ++i) {
			if(input.charAt(i) =='O')
				ret +=cnt++;
			else
				cnt =1;
		}
		return ret;
	}

}