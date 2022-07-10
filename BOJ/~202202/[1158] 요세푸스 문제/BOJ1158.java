import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb =new StringBuilder();
		List<Integer> peopleList =new ArrayList<>();
		int N, K;
		int index =0;

		st =new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		K =Integer.parseInt(st.nextToken());
		for(int i =1; i <=N; ++i)
			peopleList.add(i);

		sb.append("<");
		for(int i =0; i <N; ++i) {
			index =(index+K-1)%peopleList.size();
			sb.append(peopleList.remove(index) +", ");
		}

		sb.setLength(sb.length() -2);
		sb.append(">");
		bw.write(sb.toString());
		bw.flush();
	}
}
