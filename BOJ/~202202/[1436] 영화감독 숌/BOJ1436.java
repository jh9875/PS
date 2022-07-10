import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		System.out.println(getNthMovieTitle(N));
	}

	private static int getNthMovieTitle(int N) {
		int index = 0;
		int number = 666;

		while (index < N) {
			if (isContains666(number++)) {
				index++;
			}
		}

		return number - 1;
	}

	private static boolean isContains666(int number) {
		String strNumber = number + "";

		if (strNumber.contains("666"))
			return true;
		return false;
	}
}