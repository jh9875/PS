import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			set.add(n % 42);
		}
		
		bw.write(set.size() +"\n");
		bw.flush();
	}

}
