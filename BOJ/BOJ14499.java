import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	
	static int[] moveX ={0, 0, -1, 1};		//동,서,북,남
	static int[] moveY ={1, -1, 0, 0};

	static int N, M;
	static int[][] map;

	static int[] dice;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int x, y, K;

		st =new StringTokenizer(br.readLine());				//입력정보
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		x =Integer.parseInt(st.nextToken());
		y =Integer.parseInt(st.nextToken());
		K =Integer.parseInt(st.nextToken());
		map =new int[N][M];
		dice =new int[7];
		for(int i =0; i <N; ++i) {							//지도
			st =new StringTokenizer(br.readLine());
			for(int j =0; j <M; ++j) {
				map[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		st =new StringTokenizer(br.readLine());				//명령

		while(st.hasMoreTokens()) {
			int command =Integer.parseInt(st.nextToken());
			
			int nextX =x +moveX[command-1];
			int nextY =y +moveY[command-1];

			if(inRange(nextX, nextY)) {
				int temp =dice[1];
				if(command ==1) {			//동
					dice[1] =dice[3];
					dice[3] =dice[6];
					dice[6] =dice[4];
					dice[4] =temp;

				}else if(command ==2) {		//서
					dice[1] =dice[4];
					dice[4] =dice[6];
					dice[6] =dice[3];
					dice[3] =temp;
				} else if(command ==3) {	//북
					dice[1] =dice[2];
					dice[2] =dice[6];
					dice[6] =dice[5];
					dice[5] =temp;
				}else if(command ==4) {		//남
					dice[1] =dice[5];
					dice[5] =dice[6];
					dice[6] =dice[2];
					dice[2] =temp;
				}
				if(map[nextX][nextY] ==0) {
					map[nextX][nextY] =dice[1];
				}else {
					dice[1] =map[nextX][nextY];
					map[nextX][nextY] =0;
				}
				x =nextX;
				y =nextY;
				bw.write(dice[6] +"\n");
			} 
		}

		bw.flush();
	}

	static boolean inRange(int x, int y) {
		if(x <0 || x >=N || y <0 || y >=M)
			return false;
		return true;
	}
}
