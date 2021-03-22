import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int maxIndex =0;
		int maxValue =Integer.MIN_VALUE;

		for(int i =1; i <10; ++i) {
			int value =Integer.parseInt(br.readLine());
			if(value >maxValue) {
				maxValue =value;
				maxIndex =i;
			}
		}
		bw.write(maxValue +"\n" +maxIndex);
		bw.flush();
	}	
}