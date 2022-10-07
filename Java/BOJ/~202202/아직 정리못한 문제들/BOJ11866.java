import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		List<Integer> josephusPermutation = getJosephusPermutation(N, K);
		printJosephusPermutation(josephusPermutation);
	}

	private static List<Integer> getJosephusPermutation(int N, int K) {
		List<Integer> result = new LinkedList<>();
		List<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++)
			list.add(i);

		int index = 0;
		int size = N;
		while (!list.isEmpty()) {
			index = (index + K - 1) % (size--);
			int num = list.get(index);
			list.remove(index);
			result.add(num);
		}

		return result;
	}

	private static void printJosephusPermutation(List<Integer> josephusPermutation) {
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		for (int num : josephusPermutation) {
			sb.append(num).append(", ");
		}

		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb.toString());
	}
}