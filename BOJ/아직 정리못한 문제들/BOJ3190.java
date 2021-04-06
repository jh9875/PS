import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
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

		@Override										//contains를 비교하기위해
		public boolean equals(Object obj) {
			if(obj instanceof Pos) {
				Pos p =(Pos) obj;

				if(this.y ==p.y && this.x ==p.x)
					return true;
			}
			return false;
		}
	}
	static class Turn {
		int sec;
		char dir;
		Turn(int sec, char dir) {
			this.sec =sec;
			this.dir =dir;
		}
	}
	static int N, L;
	static boolean[][] board;

	static int[] dirY ={1, 0, -1, 0};			//남 동 북 서
	static int[] dirX ={0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Queue<Turn> turns;
		int K;

		N =Integer.parseInt(br.readLine());
		board =new boolean[N+1][N+1];
		
		K =Integer.parseInt(br.readLine());
		while(K-->0) {
			st =new StringTokenizer(br.readLine());
			int y =Integer.parseInt(st.nextToken());
			int x =Integer.parseInt(st.nextToken());
			board[y][x] =true;
		}

		L =Integer.parseInt(br.readLine());
		turns =new LinkedList<>();
		for(int i =0; i <L; ++i) {
			st =new StringTokenizer(br.readLine());
			int X =Integer.parseInt(st.nextToken());
			char C =st.nextToken().charAt(0);
			turns.add(new Turn(X, C));
		}

		bw.write(getPlayTime(turns) +"\n");
		bw.flush();
	}

	static int getPlayTime(Queue<Turn> turns) {
		Deque<Pos> snake =new ArrayDeque<>();
		int second =0;
		int dir =1;														//dir ==0~3 남 동 북 서

		snake.addFirst(new Pos(1, 1));

		while(true) {	
			int headY =snake.peekFirst().y;
			int headX =snake.peekFirst().x;

			int nextY =headY +dirY[dir];
			int nextX =headX +dirX[dir];
			++second;

			if(gameOver(snake, nextY, nextX)) break;

			snake.addFirst(new Pos(nextY, nextX));

			if(!board[nextY][nextX])									//사과가 없다면 꼬리 제거.
				snake.pollLast();
			else
				board[nextY][nextX] =false;

			if(!turns.isEmpty() && turns.peek().sec ==second) {			//방향 전환 해야되는 경우.
				if(turns.peek().dir =='L')								//왼쪽 (dir+1)
					dir =(dir+1) %4;
				else if(turns.peek().dir =='D')							//오른쪽(dir-1)
					dir =(dir+3) %4;

				turns.poll();
			}
		}
		return second;
	}

	static boolean gameOver(Deque<Pos> snake, int nextY, int nextX) {
		if(!inRange(nextY, nextX)) return true;							//벽에 부딪히는 경우.
		if(snake.contains(new Pos(nextY, nextX))) return true;			//몸통에 부딪히는 경우.

		return false;
	}

	static boolean inRange(int y, int x) {
		if(y <1 || y >N || x <1 || x >N) return false;
		return true;
	}

}