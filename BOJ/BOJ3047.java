import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String input;
		int[] numbers = new int[3];
		int[] abc = new int[3];

		st = new StringTokenizer(br.readLine());
		numbers[0] = Integer.parseInt(st.nextToken());
		numbers[1] = Integer.parseInt(st.nextToken());
		numbers[2] = Integer.parseInt(st.nextToken());
		Arrays.sort(numbers);

		input = br.readLine();
		abc[0] = input.charAt(0) - 'A';
		abc[1] = input.charAt(1) - 'A';
		abc[2] = input.charAt(2) - 'A';

		for (int i = 0; i < 3; i++) {
			bw.write(numbers[abc[i]] + " ");
		}
		bw.flush();
	}

}
