import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] cards;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		cards = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(getBestBlackjackNumber(0, new Stack<Integer>()));
	}

	private static int getBestBlackjackNumber(int index, Stack<Integer> pickedNumbers) {
		if (pickedNumbers.size() == 3) {
			int sum = 0;
			Iterator<Integer> it = pickedNumbers.iterator();
			while (it.hasNext())
				sum += it.next();
			return sum > M ? 0 : sum;
		}
		int ans = 0;
		for(int i = index; i < N; i++) {
			pickedNumbers.add(cards[i]);
			ans = Math.max(ans, getBestBlackjackNumber(i+1, pickedNumbers));
			pickedNumbers.pop();
		}
		return ans;
	}
}