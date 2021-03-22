import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N =Integer.parseInt(br.readLine());

		if(N%14==1 || N%14==13) {
			bw.write("baby");
		}else if(N%14==2 || N%14==0) {
			bw.write("sukhwan");
		}else if(N%14==3 || N%14==7 || N%14==11) {
			if(N/14 < 3) {
				bw.write("tu");
				for(int i =0; i <N/14+2; ++i)
					bw.write("ru");
			}else {
				bw.write("tu+ru*" +(N/14+2));
			}
		}else if(N%14==4 || N%14==8 || N%14==12) {
			if(N/14 < 4) {
				bw.write("tu");
				for(int i =0; i <N/14+1; ++i)
					bw.write("ru");
			}else {
				bw.write("tu+ru*" +(N/14+1));
			}
		}else if(N%14 == 5) {
			bw.write("very");
		}else if(N%14 == 6) {
			bw.write("cute");
		}else if(N%14 == 9) {
			bw.write("in");
		}else if(N%14 == 10) {
			bw.write("bed");
		}

		bw.flush();
	}
}
