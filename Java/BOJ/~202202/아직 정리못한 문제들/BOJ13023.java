import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



public class Main {

	static int answer =0;
	static int N;
	static List<Integer>[] relation;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int M;

		st =new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		relation =new ArrayList[N];
		for(int i =0; i <N; ++i)
			relation[i] =new ArrayList<>();
		
		while(M-->0) {
			st =new StringTokenizer(br.readLine());
			int a =Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			relation[a].add(b);
			relation[b].add(a);
		}

		for(int start =0; start <N; ++start) {
			boolean[] check =new boolean[N];
			check[start] =true;
			checkRelation(start, 4, check);
			
			if(answer ==1) break;
		}

		bw.write(answer +"\n");
		bw.flush();
	}

	static void checkRelation(int index, int rest, boolean[] check) {
		if(rest ==0) {
			answer =1;
			return;
		}

		for(int friend : relation[index]) {
			if(check[friend]) continue;

			check[friend] =true;
			checkRelation(friend, rest-1, check);
			check[friend] =false;
			if(answer ==1) return;
		}

	}
	
}
