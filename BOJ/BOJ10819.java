import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N =Integer.parseInt(br.readLine());
		arr =new int[N];

		st =new StringTokenizer(br.readLine());
		for(int i =0; i <N; ++i)
			arr[i] =Integer.parseInt(st.nextToken());

		bw.write(changeOrder(0, new boolean[N], new int[N]) +"\n");
		bw.flush();
	}

	static int changeOrder(int index, boolean[] isPicked, int[] picked) {
		if(index ==N)
			return getDiffValue(picked);
		int ret =0;

		for(int i =0; i <N; ++i) {
			if(isPicked[i]) continue;
			
			isPicked[i] =true;
			picked[index] =arr[i];
			ret =Math.max(ret, changeOrder(index+1, isPicked, picked));
			isPicked[i] =false;
		}

		return ret;
	}

	static int getDiffValue(int[] picked) {
		int sum =0;
		
		for(int i =0; i <N-1; ++i)
			sum +=Math.abs(picked[i] -picked[i+1]);

		return sum;
	}

}