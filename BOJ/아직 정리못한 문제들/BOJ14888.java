import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int max =-1000000000, min =1000000000;
	static int N;
	static int[] numbers, operator;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;	

		N =Integer.parseInt(br.readLine());				//전체 수 입력
		numbers =new int[N];
		operator =new int[4];
		
		st =new StringTokenizer(br.readLine());			//수 입력
		for(int i =0; i <N; ++i)
			numbers[i] =Integer.parseInt(st.nextToken());

		st =new StringTokenizer(br.readLine());			//연산자 입력
		for(int i =0; i <4; ++i)
			operator[i] =Integer.parseInt(st.nextToken());

		solve(1, numbers[0]);
		bw.write(max +"\n");
		bw.write(min +"\n");
		bw.flush();
	}

	static void solve(int index, int total) {
		if(index ==N) {
			max =Math.max(max, total);
			min =Math.min(min, total);
			return;
		}

		for(int i =0; i <4; ++i) {
			if(operator[i] !=0) {
				--operator[i];
				if(i ==0)
					solve(index+1, total+numbers[index]);
				else if(i ==1)
					solve(index+1, total-numbers[index]);
				else if(i ==2)
					solve(index+1, total*numbers[index]);
				else if(i ==3)
					solve(index+1, total/numbers[index]);
				++operator[i];
			}
		}

	}
}
