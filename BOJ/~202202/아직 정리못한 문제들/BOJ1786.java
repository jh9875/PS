import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String T, P;
		List<Integer> list;

		T =br.readLine();
		P =br.readLine();
		list =kmp(T, P);
		bw.write(list.size() +"\n");
		for(int n : list)
			bw.write(n +" ");
		bw.flush();
	}

	static int[] getPartialMatch(String word) {
		int wordLen =word.length();
		int[] pi =new int[wordLen];
		int begin =1, matched =0;

		while(begin+matched <wordLen) {
			if(word.charAt(begin+matched) ==word.charAt(matched)) {
				++matched;
				pi[begin+matched-1] =matched;
			}else {
				if(matched ==0) {
					++begin;
				}else {
					begin +=matched-pi[matched-1];
					matched =pi[matched-1];
				}

			}
		}

		return pi;
	}

	static List<Integer> kmp(String text, String word) {
		List<Integer> ret =new ArrayList<>();
		int[] pi =getPartialMatch(word);
		int textLen =text.length(), wordLen =word.length();
		int begin =0, matched =0;

		while(begin <=textLen-wordLen) {
			if(matched <wordLen && text.charAt(begin +matched) ==word.charAt(matched)) {
				++matched;
				if(matched ==wordLen) ret.add(begin+1);
			}else {
				if(matched ==0) {
					++begin;
				}else {
					begin +=matched-pi[matched-1];
					matched =pi[matched-1];
				}
			}
		}

		return ret;
	}
}
