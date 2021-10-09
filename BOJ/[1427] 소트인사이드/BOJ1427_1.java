import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String num = br.readLine();
		bw.write(getDesSortedNumber(num));
		bw.flush();
	}

	private static String getDesSortedNumber(String num) {
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int len = num.length();
		for (int i = 0; i < len; i++) {
			pq.add(num.charAt(i) - '0');
		}

		while (!pq.isEmpty()) {
			sb.append(pq.poll());
		}
		return sb.reverse().toString();
	}
}
