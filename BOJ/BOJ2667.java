import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	static class Pos {
		int y, x;
		Pos(int y, int x) {
			this.y =y;
			this.x =x;
		}
	}
	
	static int N;
	static int[][] map;
	static int[] dirY ={1, 0, -1, 0};
	static int[] dirX ={0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N =Integer.parseInt(br.readLine());
		map =new int[N][N];

		for(int i =0; i <N; ++i) {
			String input =br.readLine();
			for(int j =0; j <N; ++j)
				map[i][j] =input.charAt(j)-'0';
		}

		List<Integer> ans =getTotalAptComplexList();
		Collections.sort(ans);
		bw.write(ans.size() +"\n");
		for(int n : ans)
			bw.write(n +"\n");
		bw.flush();
	}

	static List<Integer> getTotalAptComplexList() {
		List<Integer> list =new ArrayList<>();
		int aptNum =101;

		for(int i =0; i <N; ++i) {
			for(int j =0; j <N; ++j) {
				if(map[i][j] ==1) {
					list.add(bfs(i, j, aptNum));
				}
			}
		}
		return list;
	}

	static int bfs(int y, int x, int aptNum) {
		int ret =1;											//시작위치 포함
		Queue<Pos> queue =new LinkedList<>();
		boolean[][] visited =new boolean[N][N];

		queue.add(new Pos(y, x));
		visited[y][x] =true;
		map[y][x] =aptNum;

		while(!queue.isEmpty()) {
			int curY =queue.peek().y;
			int curX =queue.peek().x;
			queue.poll();

			for(int d =0; d <4; ++d) {
				int nextY =curY +dirY[d];
				int nextX =curX +dirX[d];

				if(!inRange(nextY, nextX) || visited[nextY][nextX] || map[nextY][nextX] !=1) continue;

				queue.add(new Pos(nextY, nextX));
				visited[nextY][nextX] =true;
				map[nextY][nextX] =aptNum;
				++ret;
			}
		}
		return ret;
	}

	static boolean inRange(int y, int x) {
		if(y <0 || y >=N || x <0 || x >=N)
			return false;
		return true;
	}
} 