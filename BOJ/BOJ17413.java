import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		StringBuilder sb =new StringBuilder();
		int len;
		boolean status =false;
		
		input =br.readLine();
		len =input.length();

		for(int i =0; i <len; ++i) {
			char ch =input.charAt(i);

			if(ch =='<') {
				bw.write(sb.reverse().toString() +"");
				status =true;
				bw.write(ch +"");
				sb.setLength(0);
			}else if(ch =='>') {
				status =false;
				bw.write(ch +"");
			}else {
				if(status) {
					bw.write(ch +"");
				}else {
					if(ch ==' ') {
						bw.write(sb.reverse().toString() +" ");
						sb.setLength(0);
					}else {
						sb.append(ch);
					}
				}
			}
		}
		bw.write(sb.reverse().toString());
		bw.flush();
	
	}
}
