import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n, ans =0;
		
		n =Integer.parseInt(br.readLine());

		for(int i =3; i <n; i +=3) {
			for(int j =3; j <n; j +=3) {
				int rest =n-i-j;
				if(rest>0 && rest%3==0)
					++ans;
			}
		}
		bw.write(ans +"\n");
		bw.flush();
	}
}
