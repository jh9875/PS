import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] result = getGoldbachPartition(n);
			bw.write(result[0] + " " + result[1] + "\n");
		}
		bw.flush();
	}

	private static int[] getGoldbachPartition(int n) {
		int[] result = new int[2];
		int num1 = n / 2, num2 = n / 2;
		while (num1 > 0) {
			if(isPrime(num1) && isPrime(num2)) {
				result[0] = num1;
				result[1] = num2;
				break;
			}
			num1--;
			num2 = n-num1;
		}
		return result;
	}

	private static boolean isPrime(int num) {
		if (num == 1)
			return false;
		for (int i = 2; i * i <= num; i++)
			if (num % i == 0)
				return false;
		return true;
	}
}
