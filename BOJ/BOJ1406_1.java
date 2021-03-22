import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {

	//방법 1 ListIterator 사용.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		List<Character> list =new LinkedList<>();
		ListIterator<Character> listIterator;
		String input;
		int N, inputLen;

		input =br.readLine();
		inputLen =input.length();
		for(int i =0; i <inputLen; ++i)
			list.add(input.charAt(i));
		
		listIterator =list.listIterator();
		while(listIterator.hasNext())
			listIterator.next();

		N =Integer.parseInt(br.readLine());

		while(N-->0) {					
			st =new StringTokenizer(br.readLine());
			char command =st.nextToken().charAt(0);

			if(command =='L') {
				if(listIterator.hasPrevious()) listIterator.previous();
			}else if(command =='D') {
				if(listIterator.hasNext()) listIterator.next();
			}else if(command =='B') {
				if(listIterator.hasPrevious()) {
					listIterator.previous();
					listIterator.remove();
				}
			}else if(command =='P') {
				char ch =st.nextToken().charAt(0);
				listIterator.add(ch);
			}
		}

		for(Character ch : list)
			bw.write(ch+"");
		bw.flush();
	}
}
