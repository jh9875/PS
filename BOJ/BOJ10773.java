import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack =new Stack<>();
		int N;

		N =Integer.parseInt(br.readLine());
		for(int i =0; i <N; ++i) {
			int n =Integer.parseInt(br.readLine());
			if(n ==0)
				stack.pop();
			else
				stack.push(n);
		}
		bw.write(getSum(stack) +"\n");
		bw.flush();
	}
	static int getSum(Stack<Integer> stack) {
		int sum =0;
		Iterator<Integer> it =stack.iterator();

		while(it.hasNext())
			sum +=it.next();

		return sum;
	}
}
