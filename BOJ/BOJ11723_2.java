import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int M;
		int set =0;												//비트마스크

		M =Integer.parseInt(br.readLine());
		while(M-->0) {
			st =new StringTokenizer(br.readLine());
			String command =st.nextToken();

			if(command.equals("all")) {
				set =(1<<21) -1;
			}else if(command.equals("empty")) {
				set =0;
			}else {
				int value =Integer.parseInt(st.nextToken());

				if(command.equals("add")) {
					set |=(1<<value);
				}else if(command.equals("remove")) {
					set &=~(1<<value);
				}else if(command.equals("check")) {
					if((set & (1<<value)) !=0) bw.write("1\n");
					else bw.write("0\n");
				}else if(command.equals("toggle")) {
					if((set & (1<<value)) !=0) {
						set &=~(1<<value);
					}else {
						set |=(1<<value);
					}
				}
			}
		}
		bw.flush();
	}
}