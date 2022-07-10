import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Deque<Integer> deque = new LinkedList<>();

		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			if (command.equals("push")) {
				deque.addLast(Integer.parseInt(st.nextToken()));
			} else if (command.equals("pop")) {
				if (deque.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(deque.pollFirst() + "\n");
			} else if (command.equals("size")) {
				bw.write(deque.size() + "\n");
			} else if (command.equals("empty")) {
				if (deque.isEmpty())
					bw.write(1 + "\n");
				else
					bw.write(0 + "\n");
			} else if (command.equals("front")) {
				if (deque.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(deque.peekFirst() + "\n");
			} else if (command.equals("back")) {
				if (deque.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(deque.peekLast() + "\n");
			}
		}
		bw.flush();
	}
}
