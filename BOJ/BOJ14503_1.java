import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] dirR ={-1, 0, 1, 0};					//북, 동, 남, 서
	static int[] dirC ={0, 1, 0, -1};
	static int[] backR ={1, 0, -1, 0};
	static int[] backC ={0, -1, 0, 1};
	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int r, c, d;

		st =new StringTokenizer(br.readLine());			//input line1
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		map =new int[N][M];

		st =new StringTokenizer(br.readLine());			//input line2
		r =Integer.parseInt(st.nextToken());
		c =Integer.parseInt(st.nextToken());
		d =Integer.parseInt(st.nextToken());

		for(int i =0; i <N; ++i) {
			st =new StringTokenizer(br.readLine());
			for(int j =0; j <M; ++j)
				map[i][j] =Integer.parseInt(st.nextToken());
		}

		bw.write(cleanMap(r, c, d) +"\n");
		bw.flush();
	}

	//dfs 해결
	static int cleanMap(int r, int c, int d) {
		int ret =0;
		boolean check =false;
		
		if(map[r][c] ==0) {
			map[r][c] =2;				//1. 현재 위치를 청소.
			++ret;
		}

		for(int i =0; i <4; ++i) {		//2. 왼쪽 방향부터 차례대로 탐색.
			d =(d+3) %4;
			int nextR =r +dirR[d];
			int nextC =c +dirC[d];

			if(map[nextR][nextC] ==0) {
				ret +=cleanMap(nextR, nextC, d);
				check =true;
				return ret;
			}
		}
		if(!check && map[r +backR[d]][c +backC[d]] !=1)
			return ret +=cleanMap(r +backR[d], c +backC[d], d);
		
		return ret;
	}

}
