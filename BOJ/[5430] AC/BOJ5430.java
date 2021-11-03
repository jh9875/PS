import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String input = br.readLine();

			sb.append(executeAC(p, n, input)).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static String executeAC(String p, int n, String input) {
		// L이 왼쪽, R이 오른쪽
		char pointer = 'L';

		Deque<Integer> deque = parseStringArrayToDeque(n, input);

		for (int len = p.length(), i = 0; i < len; i++) {
			char command = p.charAt(i);

			if (command == 'R') {
				pointer = pointer == 'L' ? 'R' : 'L';
			} else if (command == 'D') {
				if (deque.isEmpty()) {
					return "error";
				}
				if (pointer == 'L') {
					deque.pollFirst();
				} else if (pointer == 'R') {
					deque.pollLast();
				}
			}
		}

		String result = getResultFromDeque(deque, pointer);
		return result;
	}

	private static Deque<Integer> parseStringArrayToDeque(int n, String input) {
		Deque<Integer> deque = new LinkedList<>();

		// "[", "]" 제거
		String temp = input.substring(1, input.length() -1);
		// 숫자 사이를 ","로 구분
		StringTokenizer st = new StringTokenizer(temp, ",");

		for (int i = 0; i < n; i++) {
			deque.addLast(Integer.parseInt(st.nextToken()));
		}

		return deque;
	}

	private static String getResultFromDeque(Deque<Integer> deque, char pointer) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		while (!deque.isEmpty()) {
			if (pointer == 'L') {
				sb.append(deque.pollFirst());
			} else if (pointer == 'R') {
				sb.append(deque.pollLast());
			}
			sb.append(",");
		}
		if (sb.length() != 1) {
			sb.setLength(sb.length() - 1);
		}
		sb.append("]");

		return sb.toString();
	}

}