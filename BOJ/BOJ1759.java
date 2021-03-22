import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int L, C;
	static char[] alphabets;
	static List<String> answers =new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st =new StringTokenizer(br.readLine());
		L =Integer.parseInt(st.nextToken());
		C =Integer.parseInt(st.nextToken());
		alphabets =new char[C];
		
		st =new StringTokenizer(br.readLine());
		for(int i =0; i <C; ++i)
			alphabets[i] =st.nextToken().charAt(0);

		Arrays.sort(alphabets);
		search(-1, L, new Stack<>());
		for(String s : answers)
			bw.write(s +"\n");
		bw.flush();
	}

	static void search(int index, int toPick, Stack<Character> picked) {
		if(toPick ==0) {
			StringBuilder sb =new StringBuilder();
			Iterator<Character> it =picked.iterator();
			while(it.hasNext()) sb.append(it.next());

			if(conditionCheck(sb.toString()))
				answers.add(sb.toString());
			return;
		}

		for(int next =index+1; next <C; ++next) {
			picked.add(alphabets[next]);
			search(next, toPick-1, picked);
			picked.pop();
		}
	}

	static boolean conditionCheck(String cand) {
		int vowels =0, consonants=0;
		for(int i =0; i <L; ++i) {
			if(cand.charAt(i) =='a' || cand.charAt(i) =='e' || cand.charAt(i) =='i' || cand.charAt(i) =='o' || cand.charAt(i) =='u')
				++vowels;
			else		
				++consonants;
		}
		
		if(vowels >0 && consonants >1) return true;
		return false;
	}
}
