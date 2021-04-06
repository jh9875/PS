import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static String word;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		word =br.readLine();
		changeCroatiaAlphbet();
		bw.write(word.length() +"\n");
		bw.flush();
	}

	static void changeCroatiaAlphbet() {
		word =word.replaceAll("c=", " ");
		word =word.replaceAll("c-", " ");
		word =word.replaceAll("dz=", " ");
		word =word.replaceAll("d-", " ");
		word =word.replaceAll("lj", " ");
		word =word.replaceAll("nj", " ");
		word =word.replaceAll("s=", " ");
		word =word.replaceAll("z=", " ");
	}
}
