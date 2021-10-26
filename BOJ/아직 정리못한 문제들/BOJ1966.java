import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static class Pair {
		int index;
		int priority;

		public Pair(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			Queue<Pair> queue = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				queue.add(new Pair(i, Integer.parseInt(st.nextToken())));
			}

			sb.append(getNumberOfPriorityInPrintQueue(N, M, queue)).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int getNumberOfPriorityInPrintQueue(int N, int M, Queue<Pair> queue) {
		int ans = 0;

		while (!queue.isEmpty()) {
			if (isTopPriority(queue)) {
				Pair pair = queue.poll();
				ans++;

				if (pair.index == M)
					break;
			} else {
				queue.add(queue.poll());
			}

		}

		return ans;
	}

	private static boolean isTopPriority(Queue<Pair> queue) {
		int priority = queue.peek().priority;
		Iterator<Pair> iterator = queue.iterator();
		iterator.next();

		while (iterator.hasNext()) {
			if (priority < iterator.next().priority) {
				return false;
			}
		}
		return true;
	}
}