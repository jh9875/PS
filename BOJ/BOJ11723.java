import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		HashSet<Integer> hs =new HashSet<>();
		int M;

		M =Integer.parseInt(br.readLine());
		while(M-->0) {
			st =new StringTokenizer(br.readLine());
			String command =st.nextToken();

			if(command.equals("add")) {
				int value =Integer.parseInt(st.nextToken());
				hs.add(value);
			}else if(command.equals("remove")) {
				int value =Integer.parseInt(st.nextToken());
				hs.remove(value);
			}else if(command.equals("check")) {
				int value =Integer.parseInt(st.nextToken());
				if(hs.contains(value)) bw.write("1\n");
				else bw.write("0\n");
			}else if(command.equals("toggle")) {
				int value =Integer.parseInt(st.nextToken());
				if(hs.contains(value)) hs.remove(value);
				else hs.add(value);
			}else if(command.equals("all")) {
				hs.clear();
				for(int i =1; i <21; ++i)
					hs.add(i);
			}else if(command.equals("empty")) {
				hs.clear();
			}
		}
		
		bw.flush();
	}
}