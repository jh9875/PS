import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[][] paper;
	static int[] ans;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N =Integer.parseInt(br.readLine());
		paper =new int[N][N];
		ans =new int[3];
		for(int i =0; i <N; ++i) {
			st =new StringTokenizer(br.readLine());
			for(int j =0; j <N; ++j) {
				paper[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		divide(0, 0, N);

		bw.write(ans[0] +"\n" + ans[1] + "\n" + ans[2] + "\n");
		bw.flush();	
	}

	static void divide(int y, int x, int n) {
		if(check(y, x, n)) {
			int leftTop =paper[y][x];
			if(leftTop ==-1) ++ans[0];
			else if(leftTop ==0) ++ans[1];
			else if(leftTop ==1) ++ans[2];
			return;
		}
		for(int i =0; i <3; ++i) {
			for(int j =0; j <3; ++j) {
				divide(y +n*i/3, x +n*j/3, n/3);
			}
		}
	}

	static boolean check(int y, int x, int n) {
		int leftTop =paper[y][x];
		for(int i =y; i <y+n; ++i)
			for(int j =x; j <x+n; ++j)
				if(paper[i][j] !=leftTop)
					return false;
		return true;
	}
}
