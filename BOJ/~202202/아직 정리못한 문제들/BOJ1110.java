import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(getSizeOfCycle(Integer.parseInt(br.readLine())) + "\n");
		bw.flush();
	}

	public static int getSizeOfCycle(int N) {
		int ret = 0, num = N;
		boolean[] numberCheck = new boolean[100];

		while (!numberCheck[num]) {
			numberCheck[num] = true;
			ret++;
			num = operation(num);

		}
		return ret;
	}

	public static int operation(int n) {
		int left = n / 10;
		int right = n % 10;
		return (right * 10) + ((left + right) % 10);
	}

}