import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static final String CUTE_STR = "driip";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		System.out.println(isCute(input) ? "cute" : "not cute");
	}

	private static boolean isCute(String word) {
		if (word.length() < CUTE_STR.length()) {
			return false;
		}
		if (!word.substring(word.length() - CUTE_STR.length()).equals(CUTE_STR)) {
			return false;
		}
		return true;
	}

}