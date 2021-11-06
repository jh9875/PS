import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			sb.append(getNumOfPeopleInTheRoom(k, n)).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int getNumOfPeopleInTheRoom(int k, int n) {
		int[][] apart = new int[k + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			apart[0][i] = i;
		}

		for (int floor = 1; floor <= k; floor++) {
			for (int roomNumber = 1; roomNumber <= n; roomNumber++) {
				for (int downstairsRoomNumber = 1; downstairsRoomNumber <= roomNumber; downstairsRoomNumber++) {
					apart[floor][roomNumber] += apart[floor - 1][downstairsRoomNumber];
				}
			}
		}

		return apart[k][n];
	}
}