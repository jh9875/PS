import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[][][] shape = {
		{{0, 0}, {0, 1}, {0, 2}, {0, 3}},		//ㅡ 모양
		{{0, 0}, {1, 0}, {2, 0}, {3, 0}},

		{{0, 0}, {0, 1}, {1, 0}, {1, 1}},		//ㅁ 모양

		{{0, 0}, {1, 0}, {2, 0}, {2, 1}},		//ㄴ 모양
		{{0, 0}, {0, 1}, {0, 2}, {-1, 2}},
		{{0, 0}, {-1, 0}, {-2, 0}, {-2, -1}},
		{{0, 0}, {0, -1}, {0, -2}, {1, -2}},

		{{0, 0}, {0, 1}, {-1, 1}, {-2, 1}},		//ㄴ 모양 대칭
		{{0, 0}, {0, 1}, {0, 2}, {1, 2}},
		{{0, 0}, {-1, 0}, {-2, 0}, {-2, 1}},
		{{0, 0}, {1, 0}, {1, 1}, {1, 2}},

		{{0, 0}, {1, 0}, {1, 1}, {2, 1}},		//? 모양
		{{0, 0}, {0, 1}, {-1, 1}, {-1, 2}},
		{{0, 0}, {-1, 0}, {-1, 1}, {-2, 1}},	//? 모양 대칭
		{{0, 0}, {0, 1}, {1, 1}, {1, 2}},

		{{0, 0}, {0, 1}, {0, 2}, {1, 1}},		//ㅗ 모양
		{{0, 0}, {1, 0}, {1, 1}, {2, 0}},
		{{0, 0}, {0, 1}, {-1, 1}, {0, 2}},
		{{0, 0}, {1, 0}, {1, -1}, {2, 0}}
	};

	static int N, M;
	static int[][] paper;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st =new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		paper =new int[N][M];

		for(int i =0; i <N; ++i) {
			st =new StringTokenizer(br.readLine());
			for(int j =0; j <M; ++j)
				paper[i][j] =Integer.parseInt(st.nextToken());
		}

		bw.write(solve() +"\n");
		bw.flush();
	}

	static int solve() {
		int ret =0;
		int shapeLen =shape.length;

		for(int row =0; row <N; ++row) {
			for(int col =0; col <M; ++col) {
				for(int i =0; i <shapeLen; ++i) {
					int sum =0;

					for(int j =0; j <4; ++j) {
						int y =row +shape[i][j][0];
						int x =col +shape[i][j][1];

						if(!inRange(y, x)) {
							sum =0;
							break;
						}

						sum +=paper[y][x];
					}
					ret =Math.max(ret, sum);
				}
			}
		} 
		
		return ret;
	}

	static boolean inRange(int y, int x) {
		if(y <0 || y >=N || x <0 || x >=M)
			return false;
		return true;
	}
} 