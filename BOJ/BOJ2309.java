import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] dwarfs =new int[9];
		int sum =0;

		for(int i =0; i <9; ++i)
			sum +=dwarfs[i] =Integer.parseInt(br.readLine());
		Arrays.sort(dwarfs);
		solve(dwarfs, sum);
		
		for(int n : dwarfs)
			if(n !=-1)
				bw.write(n +"\n");

		bw.flush();
	}

	static void solve(int[] dwarfs, int sum) {
		for(int i =0; i <9; ++i) {
			for(int j =i+1; j <9; ++j) {
				if(sum -dwarfs[i] -dwarfs[j] ==100) {
					dwarfs[i] =-1;
					dwarfs[j] =-1;
					return;
				}
			}
		}
	}
}
