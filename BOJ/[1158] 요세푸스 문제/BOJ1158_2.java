import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		printJosephusSeq(N, K);
	}

	private static void printJosephusSeq(int N, int K) {
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		List<Integer> list = new ArrayList<>();
		int index = 0;
		int size = N;

		for (int i = 1; i <= N; i++)
			list.add(i);

		while (!list.isEmpty()) {
			index = (index + (K - 1)) % (size--);
			int num = list.get(index);
			list.remove(index);
			sb.append(num).append(", ");
		}

		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb.toString());
	}
}