import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static final int MAX = 100001;

	static class Pair {
		int cur;
		int cnt;

		public Pair(int cur, int cnt) {
			this.cur = cur;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		System.out.println(getShortestPath(N, K));
	}

	private static int getShortestPath(int N, int K) {
		int ret = 0;
		Queue<Pair> queue = new LinkedList<>();
		boolean[] isVisited = new boolean[100001];

		queue.add(new Pair(N, 0));
		isVisited[N] = true;

		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			int cur = pair.cur;
			int cnt = pair.cnt;

			if (cur == K) {
				ret = cnt;
				break;
			}

			if (inRange(cur + 1) && !isVisited[cur + 1]) {
				isVisited[cur + 1] = true;
				queue.add(new Pair(cur + 1, cnt + 1));
			}
			if (inRange(cur - 1) && !isVisited[cur - 1]) {
				isVisited[cur - 1] = true;
				queue.add(new Pair(cur - 1, cnt + 1));
			}
			if (inRange(cur * 2) && !isVisited[cur * 2]) {
				isVisited[cur * 2] = true;
				queue.add(new Pair(cur * 2, cnt + 1));
			}
		}

		return ret;
	}

	private static boolean inRange(int cur) {
		if (cur < 0 || MAX <= cur)
			return false;
		return true;
	}
}