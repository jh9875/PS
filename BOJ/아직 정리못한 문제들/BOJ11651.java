import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static class Coordinate implements Comparable<Coordinate> {
		public int x, y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Coordinate o) {
			if (this.y == o.y) {
				return this.x - o.x;
			} else {
				return this.y - o.y;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Coordinate[] coordinates = new Coordinate[N];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);

			coordinates[i] = new Coordinate(x, y);
		}

		Arrays.sort(coordinates);

		printResult(coordinates);
	}

	private static void printResult(Coordinate[] coordinates) {
		StringBuilder sb = new StringBuilder();

		for (Coordinate coordinate : coordinates) {
			sb.append(coordinate.x).append(" ").append(coordinate.y).append("\n");
		}

		System.out.println(sb.toString());
	}

}