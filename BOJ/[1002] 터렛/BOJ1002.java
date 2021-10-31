import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			sb.append(getNumOfCoordinates(x1, y1, r1, x2, y2, r2)).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int getNumOfCoordinates(int x1, int y1, int r1, int x2, int y2, int r2) {
		int ans = -1;
		int distance = (int) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

		// �� ��ǥ�� ��ġ�� ����, �������� ���� ��
		if (distance == 0 && r1 == r2) {
			ans = -1;
		}
		// �����ϸ鼭 �������� ������
		else if (distance == Math.pow(r1 - r2, 2)) {
			ans = 1;
		}
		// �����ϸ鼭 �������� ������
		else if (distance == Math.pow(r1 + r2, 2)) {
			ans = 1;
		}
		// ���ȿ� ������ ������ ������
		else if (distance < Math.pow(r1 - r2, 2)) {
			ans = 0;
		}
		// ���� ������ ������
		else if (distance > Math.pow(r1 + r2, 2)) {
			ans = 0;
		} else {
			ans = 2;
		}

		return ans;
	}
}