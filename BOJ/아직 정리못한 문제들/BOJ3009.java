import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> xList = new LinkedList<>();
		List<Integer> yList = new LinkedList<>();

		String[] input = null;
		for (int i = 0; i < 3; i++) {
			input = br.readLine().split(" ");
			DrawLine(xList, yList, Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}

		System.out.printf("%d %d", xList.get(0), yList.get(0));
	}

	private static void DrawLine(List<Integer> xList, List<Integer> yList, Integer x, Integer y) {
		if (xList.contains(x))
			xList.remove(x);
		else
			xList.add(x);
		if (yList.contains(y))
			yList.remove(y);
		else
			yList.add(y);
	}

}