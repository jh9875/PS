import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	static final int MAX = 10000;
	static boolean[] isPrime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		eratosthenes();
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
		while (num1 > 1) {
			if (isPrime[num1] && isPrime[num2]) {
				result[0] = num1;
				result[1] = num2;
				break;
			}
			num1--;
			num2 = n - num1;
		}
		return result;
	}

	private static void eratosthenes() {
		isPrime = new boolean[MAX + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		int sqrtn = (int) Math.sqrt(10000);
		for(int i =2; i <=sqrtn; i++) {
			if(isPrime[i]) {
				for(int j = i*i; j <=MAX; j +=i)
					isPrime[j] = false;
			}
		}
	}
}
