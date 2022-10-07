import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Pos {
		int y, x, cnt;
		Pos(int y, int x, int cnt) {
			this.y =y;
			this.x =x;
			this.cnt =cnt;
		}
	}
	
	static int N, M;
	static boolean[][] map;

	static int[] dirY ={1, 0, -1, 0};
	static int[] dirX ={0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st =new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		map =new boolean[N+1][M+1];
		for(int i =1; i <=N; ++i) {
			String line =br.readLine();
			for(int j =1; j <=M; ++j) {
				if(line.charAt(j-1) =='1')		//map[i][j] ==1 일때 true => 이동 가능.
					map[i][j] =true;
			}
		}

		bw.write(bfs() +"\n");
		bw.flush();
	}

	static int bfs() {
		Queue<Pos> queue =new LinkedList<>();
		boolean[][] visited =new boolean[N+1][M+1];

		queue.add(new Pos(1, 1, 1));
		visited[1][1] =true;

		while(!queue.isEmpty()) {
			int nowY =queue.peek().y;
			int nowX =queue.peek().x;
			int cnt =queue.peek().cnt;
			queue.poll();

			if(nowY==N && nowX==M)
				return cnt;
			
			for(int i =0; i <4; ++i) {
				int nextY =nowY +dirY[i];
				int nextX =nowX +dirX[i];
				if(!inRange(nextY, nextX) || visited[nextY][nextX] || !map[nextY][nextX]) continue;

				queue.add(new Pos(nextY, nextX, cnt+1));
				visited[nextY][nextX] =true;
			}
		}
		return -1;
	}

	static boolean inRange(int y, int x) {
		if(y <1 || y >N || x <1 || x >M)
			return false;
		return true;
	}
}
