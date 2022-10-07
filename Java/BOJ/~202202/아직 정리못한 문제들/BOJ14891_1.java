import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int[][] gears =new int[5][8];
		int K;

		for(int i =1; i <=4; ++i) {
			String input =br.readLine();
			for(int j =0; j <8; ++j) {
				if(input.charAt(j) =='1')
					gears[i][j] =1;
			}
		}

		K =Integer.parseInt(br.readLine());
		while(K-->0) {
			st =new StringTokenizer(br.readLine());
			int num =Integer.parseInt(st.nextToken());
			int dir =Integer.parseInt(st.nextToken());
			
			left(gears, num, dir);
			right(gears, num, dir);
			rotate(gears, num, dir);
		}
		int sum =0;
		for(int i =1; i <=4; ++i)
			sum +=gears[i][0] *(int)Math.pow(2, i-1);
		bw.write(sum +"\n");
		bw.flush();
	}
	static void left(int[][] gears, int num, int dir) {				//¿ŞÂÊ Åé´Ï¹ÙÄû	
		if((num-1 >0) && (gears[num-1][2] !=gears[num][6])) {
			left(gears, num-1, dir*(-1));
			rotate(gears, num-1, dir*(-1));
		}
	}
	static void right(int[][] gears, int num, int dir) {			//¿À¸¥ÂÊ Åé´Ï¹ÙÄû
		if((num+1 <=4) && (gears[num][2] !=gears[num+1][6])) {		
			right(gears, num+1, dir*(-1));
			rotate(gears, num+1, dir*(-1));
		}
	}
	static void rotate(int[][] gears, int num, int dir) {
		if(dir ==1) {												//½Ã°è ¹æÇâ
			int temp =gears[num][7];
			for(int i =7; i >0; --i)
				gears[num][i] =gears[num][i-1];
			gears[num][0] =temp;
		}else if(dir ==-1) {										//¹İ ½Ã°è ¹æÇâ
			int temp =gears[num][0];
			for(int i =0; i <7; ++i)
				gears[num][i] =gears[num][i+1];
			gears[num][7] =temp;
		}
	}
}
