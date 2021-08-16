import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int answer = 0;

		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			int[] intArr = convertIntToIntArr(i);
			if (isArithmeticSequence(intArr))
				answer++;
		}

		bw.write(answer + "\n");
		bw.flush();
	}

	private static int[] convertIntToIntArr(int num) {
		String numStr = Integer.toString(num);
		int length = numStr.length();
		int[] ret = new int[length];

		for (int i = 0; i < length; i++)
			ret[i] = numStr.charAt(i) - '0';

		return ret;
	}

	private static boolean isArithmeticSequence(int[] arr) {
		if (arr.length == 1)
			return true;

		int diff = arr[1] - arr[0];
		for (int i = 2, length = arr.length; i < length; i++) {
			if ((arr[i] - arr[i - 1]) != diff)
				return false;
		}

		return true;
	}
}
