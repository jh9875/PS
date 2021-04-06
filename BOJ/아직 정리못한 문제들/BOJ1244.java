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
		int N, T;
		boolean[] switchArr;

		N =Integer.parseInt(br.readLine());			//input line1
		switchArr =new boolean[N+1];
		st =new StringTokenizer(br.readLine());		//input line2
		for(int i =1; i <=N; ++i) {
			if(st.nextToken().equals("1"))
				switchArr[i] =true;
		}
		T =Integer.parseInt(br.readLine());			//input line3
		while(T-->0) {
			st =new StringTokenizer(br.readLine());
			int sex =Integer.parseInt(st.nextToken());
			int num =Integer.parseInt(st.nextToken());
			onAndOff(switchArr, N, sex, num);
		}
		for(int i =1; i <=N; ++i) {
			if(switchArr[i])
				bw.write(1 +" ");
			else
				bw.write(0 +" ");

			if(i %20 ==0)
				bw.write("\n");
		}
		bw.flush();
	}

	static void onAndOff(boolean[] switchArr, int N, int sex, int num) {
		if(sex ==1) {
			for(int i =1; i*num <=N; ++i)
				switchArr[i*num] =!switchArr[i*num];
		}else if(sex ==2) {
			switchArr[num] =!switchArr[num];
			int i =1;
			while(inRange(num-i, N) && inRange(num+i, N) && switchArr[num-i] ==switchArr[num+i]) {
				switchArr[num-i] =!switchArr[num-i];
				switchArr[num+i] =!switchArr[num+i];
				++i;
			}
		}
	}

	static boolean inRange(int num, int N) {
		if(num <1 || num >N) return false;
		return true;
	}
}
