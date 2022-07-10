import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Pos {
		int y, x;
		Pos(int y, int x) {
			this.y =y;
			this.x =x;
		}
	}
	
	static int[] dirY ={-1, -1, -1, 0, 1, 1, 1, 0};		//현재 점을 중심으로 11시 방향부터 시계방향으로
	static int[] dirX ={-1, 0, 1, 1, 1, 0, -1, -1};
	
	static int[][] map;
	static int W, H;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while(true) {
			st =new StringTokenizer(br.readLine());
			W =Integer.parseInt(st.nextToken());
			H =Integer.parseInt(st.nextToken());
			map =new int[H][W];

			if(W ==0 && H ==0) break;

			for(int i =0; i <H; ++i) {
				st =new StringTokenizer(br.readLine());
				for(int j =0; j <W; ++j)
					map[i][j] =Integer.parseInt(st.nextToken());
			}
			bw.write(getNumOfIsland() +"\n");
		}
		bw.flush();
	}

	static int getNumOfIsland() {
		int ret =0;
		
		for(int i =0; i <H; ++i) {
			for(int j =0; j <W; ++j) {
				if(map[i][j] ==1) {
					bfs(i, j);
					++ret;
				}
			}
		}
		return ret;
	}

	static void bfs(int y, int x) {
		Queue<Pos> queue =new LinkedList<>();

		queue.add(new Pos(y, x));
		map[y][x] =2;							//방문 표시를 2로

		while(!queue.isEmpty()) {
			int curY =queue.peek().y;
			int curX =queue.peek().x;
			queue.poll();

			for(int i =0; i <8; ++i) {
				int nextY =curY +dirY[i];
				int nextX =curX +dirX[i];

				if(!inRange(nextY, nextX) || map[nextY][nextX] !=1) continue;

				queue.add(new Pos(nextY, nextX));
				map[nextY][nextX] =2;
			}
		}
	}
	static boolean inRange(int y, int x) {
		if(y <0 || y >=H || x <0 || x >=W)
			return false;
		return true;
	}
	
} 