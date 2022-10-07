import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] ability;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N =Integer.parseInt(br.readLine());
		ability =new int[N][N];

		for(int i =0; i <N; ++i) {
			st =new StringTokenizer(br.readLine());
			for(int j =0; j <N; ++j)
				ability[i][j] =Integer.parseInt(st.nextToken());
		}

		bw.write(pickTeam(-1, N/2, new boolean[N]) +"\n");
		bw.flush();
	}

	static int pickTeam(int index, int rest, boolean[] picked) {
		if(rest ==0) return getDiff(picked);
		int ret =987654321;

		for(int next =index+1; next <N; ++next) {
			picked[next] =true;
			ret =Math.min(ret, pickTeam(next, rest-1, picked));
			picked[next] =false;
		}

		return ret;
	}

	static int getDiff(boolean[] picked) {
		int team1 =0, team2 =0;

		for(int i =0; i <N; ++i) {
			for(int j =0; j <N; ++j) {
				if(i ==j) continue;
				if(picked[i] && picked[j]) team1 +=ability[i][j];
				if(!picked[i] && !picked[j]) team2 +=ability[i][j];
			}
		}

		return Math.abs(team1-team2);
	}
}
