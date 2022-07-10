import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

	public static int ABS_MAX_NUMBER = 1000000;
	public static int TOTOAL_NUMBER_RANGE = ABS_MAX_NUMBER * 2 + 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] isCheckedNumber = new boolean[TOTOAL_NUMBER_RANGE];

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int index = Integer.parseInt(br.readLine()) + ABS_MAX_NUMBER;
			isCheckedNumber[index] = true;
		}

		for (int i = 0; i < TOTOAL_NUMBER_RANGE; i++) {
			if (isCheckedNumber[i]) {
				bw.write((i - ABS_MAX_NUMBER) + "\n");
			}
		}
		bw.flush();
	}

}
