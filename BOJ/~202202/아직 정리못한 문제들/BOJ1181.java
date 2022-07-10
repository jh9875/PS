import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Main {

	static class Word implements Comparable<Word> {
		String str;
		int len;

		Word(String str) {
			this.str =str;
			len =str.length();
		}
		@Override
		public int compareTo(Word w) {
			if(this.len !=w.len)
				return this.len -w.len;
			else {
				return this.str.compareTo(w.str);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashSet<String> hs =new HashSet<>();
		List<Word> words =new ArrayList<>();
		int N;

		N =Integer.parseInt(br.readLine());

		for(int i =0; i <N; ++i)
			hs.add(br.readLine());
		
		Iterator<String> it =hs.iterator();
		while(it.hasNext())
			words.add(new Word(it.next()));

		Collections.sort(words);

		for(Word w : words)
			bw.write(w.str +"\n");
		bw.flush();
	}

}