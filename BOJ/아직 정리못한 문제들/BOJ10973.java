import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		boolean isFind =false;

		N =Integer.parseInt(br.readLine());
		arr =new int[N];

		st =new StringTokenizer(br.readLine());
		for(int i =0; i <N; ++i)
			arr[i] =Integer.parseInt(st.nextToken());
		

		for(int i =N-1; i >0; --i) {
			if(arr[i-1] >arr[i]) {
				int index =getSwapIndex(arr[i-1], i);
				swap(i-1, index);
				Arrays.sort(arr, i, N);

				for(int j =0; j <i; ++j)
					bw.write(arr[j] +" ");
				for(int j =N-1; j >=i; --j)
					bw.write(arr[j] +" ");

				isFind =true;
				break;
			}
		}
		if(!isFind)
			bw.write(-1 +"\n");
		bw.flush();
	}
	static int getSwapIndex(int value, int startIndex) {
		int index =0;
		int max =0;

		for(int i =startIndex; i <N; ++i) {
			if(arr[i] <value && arr[i] >max) {
				index =i;
				max =arr[i];
			}
		}

		return index;
	}

	static void swap(int i, int j) {
		int temp =arr[i];
		arr[i] =arr[j];
		arr[j] =temp;
	}

}