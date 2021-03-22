import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	static Pattern pattern =Pattern.compile("((100+1+)|(01))+");

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T;

		T =Integer.parseInt(br.readLine());
		while(T-->0) {
			String input =br.readLine();
			bw.write(hasPattern(input));
		}
		bw.flush();
	}

	static String hasPattern(String input) {
		Matcher matcher =pattern.matcher(input);

		return matcher.matches()? "YES\n": "NO\n";
	}

}
