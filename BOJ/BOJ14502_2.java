import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
	static int[] dirY ={1, 0, -1, 0};
	static int[] dirX ={0, 1, 0, -1};

	static int N, M;
	static int[][] map;
	static int[][] copy;
	static List<Pos> virusPos =new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		

		st =new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		map =new int[N][M];
		copy =new int[N][M];
		
		for(int i =0; i <N; ++i) {
			st =new StringTokenizer(br.readLine());
			for(int j =0; j <M; ++j) {
				map[i][j] =Integer.parseInt(st.nextToken());
				if(map[i][j] ==2)
					virusPos.add(new Pos(i, j));
			}
		}

		bw.write(setUpWall(3) +"\n");
		bw.flush();
	}

	static int setUpWall(int rest) {
		if(rest ==0) {
			copyMap();;
			spreadVirus();
			return getSafeArea();
		}
		int ret =0;

		for(int y =0; y <N; ++y) {
			for(int x =0; x <M; ++x) {
				if(map[y][x] ==0) {
					map[y][x] =1;
					ret =Math.max(ret, setUpWall(rest-1));
					map[y][x] =0;
				}
			}
		}

		return ret;
	}

	static void spreadVirus() {
		Queue<Pos> queue =new LinkedList<>();

		for(Pos p : virusPos) 
			queue.add(p);
		
		while(!queue.isEmpty()) {
			Pos p =queue.poll();

			for(int dir =0; dir <4; ++dir) {
				int nextY =p.y +dirY[dir];
				int nextX =p.x +dirX[dir];

				if(inRange(nextY, nextX) && copy[nextY][nextX] ==0) {
					copy[nextY][nextX] =2;
					queue.add(new Pos(nextY, nextX));
				}
			}
		}
	}

	static boolean inRange(int y, int x) {
		if(y <0 || y >=N || x <0 || x >=M) return false;
		return true;
	}

	static void copyMap() {
		for(int i =0; i <N; ++i) {
			for(int j =0; j <M; ++j)
				copy[i][j] =map[i][j];
		}
	}

	static int getSafeArea() {
		int ret =0;

		for(int i =0; i <N; ++i) {
			for(int j =0; j <M; ++j) {
				if(copy[i][j] ==0)
					++ret;
			}
		}

		return ret;
	}
	
}
