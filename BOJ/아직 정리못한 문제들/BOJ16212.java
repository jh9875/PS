import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N;
		int[] arr;

		N =Integer.parseInt(br.readLine());
		arr =new int[N];
		st =new StringTokenizer(br.readLine());
		for(int i =0; i <N; ++i)
			arr[i] =Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		for(int n : arr)
			bw.write(n +" ");
		bw.flush();
	}
}
