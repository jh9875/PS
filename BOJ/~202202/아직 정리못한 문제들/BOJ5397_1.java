import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
	
	//ListIterator 사용.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Character> list;
		ListIterator<Character> listIt;
		String input;
		int T, inputLen;

		T =Integer.parseInt(br.readLine());
		while(T-->0) {
			input =br.readLine();
			inputLen =input.length();	
			list =new LinkedList<>();
			listIt =list.listIterator();
			
			for(int i =0; i <inputLen; ++i) {
				char ch =input.charAt(i);

				if(ch =='<') {
					if(listIt.hasPrevious()) listIt.previous();
				}else if(ch =='>') {
					if(listIt.hasNext()) listIt.next();
				}else if(ch =='-') {
					if(listIt.hasPrevious()) {
						listIt.previous();
						listIt.remove();
					} 
				}else {
					listIt.add(ch);
				}
			}
			for(Character ch : list)
				bw.write(ch +"");
			bw.write("\n");
		}
		bw.flush();
	}
}
