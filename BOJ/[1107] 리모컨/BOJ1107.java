import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int MAX =500000;
	static int target;
	static boolean[] button;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		button =new boolean[10];
		Arrays.fill(button, true);

		target =Integer.parseInt(br.readLine());
		if(Integer.parseInt(br.readLine()) !=0) {
			st =new StringTokenizer(br.readLine());
			while(st.hasMoreTokens())
				button[Integer.parseInt(st.nextToken())] =false;
		}
		
		bw.write(solve() +"\n");
		bw.flush();
	}

	static int solve() {
		int ret =Math.abs(target-100);		//+,- 버튼으로만 최소인 경우.

		for(int i =0; i <10; i++)			//숫자버튼 누르는 경우.
			if(button[i]) ret =Math.min(ret, pressButton(i) +1);

		return ret;
	}

	static int pressButton(int curChannel) {
		if(curChannel >MAX*10) return MAX;
		if(curChannel ==target) return 0;

		int ret =Math.abs(target-curChannel);

		for(int i =0; i <10; i++)
			if(curChannel !=0 && button[i]) ret =Math.min(ret, pressButton(curChannel*10 +i) +1);
		
		return ret;
	}
}