import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String answer = isPalindrome(br.readLine()) ? "1" : "0";
		bw.write(answer);
		bw.flush();
	}

	private static boolean isPalindrome(String str) {
		int strLen = str.length();
		int halfStrLen = strLen / 2;

		for (int i = 0; i < halfStrLen; i++) {
			if (str.charAt(i) != str.charAt(strLen - 1 - i))
				return false;
		}
		return true;
	}
}