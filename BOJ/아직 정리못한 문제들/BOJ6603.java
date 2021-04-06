import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb =new StringBuilder();
	static int N;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while(true) {
			st =new StringTokenizer(br.readLine());
			N =Integer.parseInt(st.nextToken());
			if(N ==0)
				break;

			arr =new int[N];
			for(int i =0; i <N; i++)
				arr[i] =Integer.parseInt(st.nextToken());

			pick(6, -1, new Stack<Integer>());
			bw.write(sb.toString() +"\n");
			sb.setLength(0);
		}
		bw.flush();
	}

	static void pick(int toPick, int prevIndex, Stack<Integer> picked) {
		if(toPick ==0) {
			Iterator<Integer> it =picked.iterator();
			while(it.hasNext())
				sb.append(it.next() +" ");
			sb.append("\n");
			return;
		}

		for(int next =prevIndex+1; next <N; ++next) {
			picked.push(arr[next]);
			pick(toPick-1, next,  picked);
			picked.pop();
		}
	}
	
}
