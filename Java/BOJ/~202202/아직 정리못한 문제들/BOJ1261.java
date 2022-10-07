import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Pos implements Comparable<Pos>{
		int y, x, cnt;
		Pos(int y, int x, int cnt) {
			this.y =y; this.x =x; this.cnt =cnt;
		}

		@Override
		public int compareTo(Pos p) {
			return this.cnt -p.cnt;
		}
	}
	static int[] dirY ={1, 0, -1, 0};
	static int[] dirX ={0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, M;
		boolean[][] map;

		st =new StringTokenizer(br.readLine());
		M =Integer.parseInt(st.nextToken());
		N =Integer.parseInt(st.nextToken());
		map =new boolean[N+1][M+1];

		for(int i =1; i <=N; ++i) {
			String line =br.readLine();
			for(int j =1; j <=M; ++j)
				if(line.charAt(j-1) =='1')
					map[i][j] =true;
		}

		bw.write(search(N, M, map) +"\n");
		bw.flush();
	}

	static int search(int N, int M, boolean[][] map) {
		PriorityQueue<Pos> pq =new PriorityQueue<>();
		boolean[][] visited =new boolean[N+1][M+1];
		
		pq.add(new Pos(1, 1, 0));
		visited[1][1] =true;

		while(!pq.isEmpty()) {
			int curY =pq.peek().y;
			int curX =pq.peek().x;
			int cnt =pq.peek().cnt;
			pq.poll();

			if(curY ==N && curX ==M) return cnt;

			for(int i =0; i <4; ++i) {
				int nextY =curY +dirY[i];
				int nextX =curX +dirX[i];

				if(!inRange(nextY, nextX, N, M) || visited[nextY][nextX]) continue;

				if(map[nextY][nextX])
					pq.add(new Pos(nextY, nextX, cnt+1));
				else
					pq.add(new Pos(nextY, nextX, cnt));
				visited[nextY][nextX] =true;
			}
		}
		return 0;
	}

	static boolean inRange(int y, int x, int N, int M) {
		if(y <1 || y >N || x <1 || x >M) return false;
		return true;
	}
}
