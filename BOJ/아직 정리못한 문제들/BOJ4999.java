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

		String jaehwan = br.readLine();
		String doctor = br.readLine();

		if (canGoHospital(jaehwan, doctor)) {
			bw.write("go\n");
		} else {
			bw.write("no\n");
		}
		bw.flush();
	}

	private static boolean canGoHospital(String jaehwan, String doctor) {
		return jaehwan.length() >= doctor.length() ? true : false;
	}
}
