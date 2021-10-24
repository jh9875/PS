import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		boolean[][] isConnected = new boolean[N + 1][N + 1];

		int line = Integer.parseInt(br.readLine());
		for (int i = 0; i < line; i++) {
			String[] input = br.readLine().split(" ");
			int c1 = Integer.parseInt(input[0]);
			int c2 = Integer.parseInt(input[1]);

			isConnected[c1][c2] = true;
			isConnected[c2][c1] = true;
		}

		System.out.println(getNumOfInfectedComputers(N, isConnected));
	}

	private static int getNumOfInfectedComputers(int N, boolean[][] isConnected) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] isInfectedComputer = new boolean[N + 1];

		queue.add(1);

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int computer = 1; computer <= N; computer++) {
				if (isConnected[now][computer] && !isInfectedComputer[computer]) {
					queue.add(computer);
					isInfectedComputer[computer] = true;
				}
			}
		}

		return getNumOfTrueInBooleanArray(N, isInfectedComputer);
	}

	private static int getNumOfTrueInBooleanArray(int N, boolean[] isInfectedComputer) {
		int result = 0;
		for (int i = 2; i <= N; i++) {
			if (isInfectedComputer[i])
				result++;
		}
		return result;
	}
}