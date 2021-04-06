import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Robot {
		int r, c, d;
		Robot(int r, int c, int d) {
			this.r =r; this.c =c; this.d =d;
		}
	}

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
	//bfs 해결
	static int cleanMap(int r, int c, int d) {
		int ret =0;
		Queue<Robot> queue =new LinkedList<>();

		++ret;
		map[r][c] =2;
		queue.add(new Robot(r, c, d));

		while(!queue.isEmpty()) {
			int curR =queue.peek().r;
			int curC =queue.peek().c;
			int curD =queue.peek().d;
			boolean check =false;
			queue.poll();

			for(int i =0; i <4; ++i) {
				curD =(curD+3) %4;
				int nextR =curR +dirR[curD];
				int nextC =curC +dirC[curD];

				if(map[nextR][nextC] ==0) {
					++ret;
					map[nextR][nextC] =2;
					queue.add(new Robot(nextR, nextC, curD));
					check =true;
					break;
				}
			}
			if(!check && map[curR +backR[curD]][curC +backC[curD]] !=1) {
				queue.add(new Robot(curR +backR[curD], curC +backC[curD], curD));
			}
		}
		
		return ret;
	}

}
