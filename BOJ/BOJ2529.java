import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static List<String> cand =new ArrayList<>();
	static boolean[] sign;		// < =true, > =false
	static boolean[] check;
	static int K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Stack<Integer> stack =new Stack<>();

		K =Integer.parseInt(br.readLine());
		sign =new boolean[K];
		check =new boolean[10];

		st =new StringTokenizer(br.readLine());
		for(int i =0; i <K; ++i) {
			if(st.nextToken().charAt(0) =='<')
				sign[i] =true;
		}
		for(int i =0; i <10; ++i) {
			stack.add(i);
			check[i] =true;
			solve(0, stack);
			stack.pop();
			check[i] =false;
		}

		bw.write(cand.get(cand.size()-1) +"\n");
		bw.write(cand.get(0) +"\n");
		bw.flush();
	}

	static void solve(int index, Stack<Integer> stack) {
		if(index ==K) {
			Iterator<Integer> it =stack.iterator();
			StringBuilder sb =new StringBuilder();

			while(it.hasNext())
				sb.append(it.next());
			
			cand.add(sb.toString());
			return;
		}
			
		for(int next =0; next <10; ++next) {
			if(!check[next]) {
				int prev =stack.peek();

				if(isOk(index, prev, next)) {
					stack.add(next);
						check[next] =true;
						solve(index+1, stack);
						stack.pop();
						check[next] =false;
				}
			}
		}
		
	}
	static boolean isOk(int index, int prev, int next) {
		if(sign[index]) {
			if(prev <next)
				return true;
		}else {
			if(prev >next)
				return true;
		}
		return false;
	}
}
