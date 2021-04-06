import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N, ans =0;

		N =Integer.parseInt(br.readLine());
		while(N-->0) {
			String word =br.readLine();

			if(isGroupWord(word))
				++ans;
		}
		bw.write(ans +"\n");
		bw.flush();
	}

	static boolean isGroupWord(String word) {
		boolean[] alphabetCheck =new boolean[26];
		int index =0;
		int len =word.length();

		while(index <len) {
			char ch =word.charAt(index++);
			if(alphabetCheck[ch-'a']) return false;
			else alphabetCheck[ch-'a'] =true;

			while(index <len && ch ==word.charAt(index))
				++index;
		}
		return true;
	}
}
