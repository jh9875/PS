import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		bw.write(findConstructor(N) + "\n");
		bw.flush();
	}

	private static int findConstructor(int N) {
		int ret = 0;

		for (int cand = 1; cand <= N; cand++) {
			if (isConstructor(cand, N)) {
				ret = cand;
				break;
			}
		}

		return ret;
	}

	private static boolean isConstructor(int cand, int N) {
		List<Integer> partsOfNumber = getPartsOfNumber(cand);

		int sum = cand;
		for (int partNum : partsOfNumber) {
			sum += partNum;
		}

		return sum == N ? true : false;
	}

	private static List<Integer> getPartsOfNumber(int num) {
		List<Integer> result = new ArrayList<>();
		String strNum = Integer.toString(num);

		for (int i = 0, length = strNum.length(); i < length; i++) {
			result.add(strNum.charAt(i) - '0');
		}

		return result;
	}

}
