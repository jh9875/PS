import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static final int MAX =100001;
	static int[] path =new int[MAX];
	static int[] time =new int[MAX];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Stack<Integer> stack =new Stack<>();
		int N, K;

		st =new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		K =Integer.parseInt(st.nextToken());

		bfs(N, K);

		int pos =K;

		while(pos !=N) {
			stack.add(pos);
			pos =path[pos];
		}
		stack.add(N);

		bw.write(time[K] +"\n");
		while(!stack.isEmpty())
			bw.write(stack.pop() +" ");

		bw.flush();
	}

	static void bfs(int N, int K) {
		Queue<Integer> queue =new LinkedList<>();

		queue.add(N);

		while(!queue.isEmpty()) {
			int curPos =queue.poll();

			if(curPos ==K)
				return;

			if(curPos-1 >= 0 && time[curPos-1] ==0) {
				time[curPos-1] =time[curPos] +1;
				path[curPos-1] =curPos;
				queue.add(curPos-1);
			}
			if(curPos+1 <MAX && time[curPos+1] ==0) {
				time[curPos+1] =time[curPos] +1;
				path[curPos+1] =curPos;
				queue.add(curPos+1);
			}
			if(curPos*2 <MAX && time[curPos*2] ==0) {
				time[curPos*2] =time[curPos] +1;
				path[curPos*2] =curPos;
				queue.add(curPos*2);
			}
		}
	}

}
