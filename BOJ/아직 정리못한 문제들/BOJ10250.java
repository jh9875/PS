import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			bw.write(getHotelRoomNumber(H, W, N) + "\n");
		}
		bw.flush();
	}

	private static String getHotelRoomNumber(int H, int W, int N) {
		StringBuilder ans = new StringBuilder();
		int count = 0;

		for (int x = 1; x <= W; x++) {
			for (int y = 1; y <= H; y++) {
				count++;
				if (count == N) {
					ans.append(y);
					if (x < 10)
						ans.append("0");
					ans.append(x);
					break;
				}
			}
		}

		return ans.toString();
	}
}
