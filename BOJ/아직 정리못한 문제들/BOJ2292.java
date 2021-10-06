import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int roomNumber = Integer.parseInt(br.readLine());
		bw.write(getMinimumPassingRoom(roomNumber) + "\n");
		bw.flush();
	}

	private static int getMinimumPassingRoom(int roomNumber) {
		int ans = 1;
		int count = 1;

		while (count < roomNumber) {
			count += (ans * 6);
			ans++;
		}

		return ans;
	}
}
