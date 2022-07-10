import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Pos {
		int y, x;
		Pos(int y, int x) {
			this.y =y;
			this.x =x;
		}
	}

	static boolean find =false;
	static int[][] board;
	static List<Pos> emptyList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		board =new int[9][9];
		emptyList =new ArrayList<>();

		for(int i =0; i <9; ++i) {
			st =new StringTokenizer(br.readLine());
			for(int j =0; j <9; ++j) {
				board[i][j] =Integer.parseInt(st.nextToken());
				if(board[i][j] ==0) emptyList.add(new Pos(i, j));
			}
		}

		backTrack(0);

		for(int i =0; i <9; ++i) {
			for(int j =0; j <9; ++j)
				bw.write(board[i][j] +" ");
			bw.write("\n");
		}
		bw.flush();
	}

	static void backTrack(int index) {
		if(index ==emptyList.size()) {			//빈곳 모두 확인
			find =true;
			return;
		}
		int y =emptyList.get(index).y;
		int x =emptyList.get(index).x;

		for(int n =1; n <=9; ++n) {				//빈 곳에 하나씩 가능성 있는 것 넣어보기.
			if(!possible(y, x, n)) continue;

			board[y][x] =n;
			backTrack(index +1);
			if(find) return;
			board[y][x] =0;
		}

	}

	static boolean possible(int y, int x, int n) {
		if(!rowCheck(y, n)) return false;
		if(!colCheck(x, n)) return false;
		if(!squareCheck(y, x, n)) return false;
		
		return true;
	}

	static boolean rowCheck(int row, int n) {
		for(int col =0; col <9; ++col)
			if(board[row][col] ==n) return false;
		return true;
	}
	static boolean colCheck(int col, int n) {
		for(int row =0; row <9; ++row)
			if(board[row][col] ==n) return false;
		return true;
	}
	static boolean squareCheck(int y, int x, int n) {
		int rowStart =(y/3)*3;
		int colStart =(x/3)*3;
		for(int row =rowStart; row <rowStart+3; ++row) {
			for(int col =colStart; col <colStart+3; ++col) {
				if(board[row][col] ==n) return false;
			}
		}
		return true;
	}
}
