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
		boolean[][] check =new boolean[101][101];;

		for(int i =0; i <4; ++i) {
			st =new StringTokenizer(br.readLine());
			int lbx =Integer.parseInt(st.nextToken());
			int lby =Integer.parseInt(st.nextToken());
			int rtx =Integer.parseInt(st.nextToken());
			int rty =Integer.parseInt(st.nextToken());

			for(int x =lbx; x <rtx; ++x) {
				for(int y =lby; y <rty; ++y) {
					check[x][y] =true;
				}
			}
		}

		int ret =0;
		for(int i =1; i <101; ++i) {
			for(int j =1; j <101; ++j)
				if(check[i][j])
					++ret;
		}
		bw.write(ret +"\n");
		bw.flush();	
	}

}
