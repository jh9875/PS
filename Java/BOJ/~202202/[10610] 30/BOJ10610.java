import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;

		input = br.readLine();

		if (conditionOf30Multiples(input)) {
			String result = getReversedNumbers(input);
			bw.write(result);
		} else {
			bw.write("-1\n");
		}
		bw.flush();
	}

	// 30배수의 조건 => 끝자리가 0, 모든 자리수의 합이 3의 배수.
	static boolean conditionOf30Multiples(String input) {
		int len = input.length();
		long sum = 0;
		boolean containsN = false;

		for (int i = 0; i < len; i++) {
			int n = input.charAt(i) - '0';
			if (n == 0)
				containsN = true;
			sum += n;
		}
		return (containsN && sum % 3 == 0) ? true : false;
	}

	static String getReversedNumbers(String input) {
		StringBuilder sb = new StringBuilder();
		int[] numberCount = new int[10];
		int len = input.length();

		for (int i = 0; i < len; i++) {
			numberCount[input.charAt(i) - '0']++;
		}
		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < numberCount[i]; j++)
				sb.append(i);
		}

		return sb.toString();
	}
}
