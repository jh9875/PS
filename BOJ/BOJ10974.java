import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Stack;

public class Main {

	static int N;
	static StringBuilder answers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		answers =new StringBuilder();

		N =Integer.parseInt(br.readLine());
		permutation(N, new boolean[N+1], new Stack<>());
		bw.write(answers.toString());
		bw.flush();
	}

	static void permutation(int rest, boolean[] check, Stack<Integer> stack) {
		if(rest ==0) {
			Iterator<Integer> it =stack.iterator();
			while(it.hasNext()) answers.append(it.next() +" ");
			answers.append("\n");
			return;
		}

		for(int i =1; i <=N; ++i) {
			if(check[i]) continue;

			check[i] =true;
			stack.add(i);
			permutation(rest-1, check, stack);
			check[i] =false;
			stack.pop();
		}
	}
}