import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] chemistry;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N =Integer.parseInt(br.readLine());
		chemistry =new int[N][N];
		
		for(int i =0; i <N; ++i) {
			st =new StringTokenizer(br.readLine());
			for(int j =0; j <N; ++j) {
				chemistry[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		bw.write(pickTeam1(0, new Stack<Integer>()) +"\n");
		bw.flush();
	}

	static int pickTeam1(int index, Stack<Integer> picked) {
		if(index ==N) {
			if(picked.isEmpty() || picked.size() ==N)
				return 987654321;
			return getDiff(picked);
		}
		int ret =987654321;

		for(int next =index; next <N; ++next) {
			picked.add(next);
			ret =Math.min(ret, pickTeam1(next+1, picked));
			picked.pop();
		}
		
		return ret;
	}

	static int getDiff(Stack<Integer> picked) {
		int sum1 =0, sum2 =0;
		boolean[] team1 =new boolean[N];
		Iterator<Integer> it =picked.iterator();
		while(it.hasNext())
			team1[it.next()] =true;

		for(int i =0; i <N; ++i) {
			for(int j =i+1; j <N; ++j) {
				if(team1[i] && team1[j])
					sum1 +=chemistry[i][j] +chemistry[j][i];
				else if(!team1[i] && !team1[j])
					sum2 +=chemistry[i][j] +chemistry[j][i];
			}
		}
		
		return Math.abs(sum1-sum2);
	}
}
