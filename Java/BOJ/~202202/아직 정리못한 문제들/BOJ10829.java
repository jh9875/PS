import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String input;
		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			input = br.readLine();
			st = new StringTokenizer(input);
			String command = st.nextToken();

			if (command.equals("push")) {
				int n = Integer.parseInt(st.nextToken());
				stack.push(n);
			} else if (command.equals("pop")) {
				if (stack.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(stack.pop() + "\n");
			} else if (command.equals("size")) {
				bw.write(stack.size() + "\n");
			} else if (command.equals("empty")) {
				if (stack.isEmpty())
					bw.write(1 + "\n");
				else
					bw.write(0 + "\n");
			} else if (command.equals("top")) {
				if (stack.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(stack.peek() + "\n");
			}
		}

		bw.flush();
	}

}
